package com.docusign.iam.sdk.security.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.config.TestConfig;
import com.docusign.iam.sdk.models.components.AuthScope;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetUserInfoResponse;
import com.docusign.iam.sdk.models.operations.JWTGrant;
import com.docusign.iam.sdk.utils.auth.JwtAssertionHelper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

@EnabledIfEnvironmentVariables({
  @EnabledIfEnvironmentVariable(named = "DOCUSIGN_JWT_PRIVATE_KEY", matches = ".+"),
  @EnabledIfEnvironmentVariable(named = "DOCUSIGN_JWT_CLIENT_ID", matches = ".+"),
  @EnabledIfEnvironmentVariable(named = "DOCUSIGN_JWT_USER_ID", matches = ".+"),
  @EnabledIfEnvironmentVariable(named = "DOCUSIGN_OAUTH_BASE_PATH", matches = ".+")
})
public class JwtAssertionHelperIntegrationTest {

  private static TestConfig testConfig;

  @BeforeAll
  public static void setup() throws IOException {
    // Loading test config YAML file from resources and replacing environment variables
    InputStream in =
        JwtAssertionHelperIntegrationTest.class
            .getClassLoader()
            .getResourceAsStream("application-test.yml");
    String rawYaml = new Scanner(in, StandardCharsets.UTF_8).useDelimiter("\\A").next();
    String resolvedYaml = substituteEnvVariables(rawYaml);
    LoaderOptions options = new LoaderOptions();
    Yaml yaml = new Yaml(new Constructor(TestConfig.class, options));
    testConfig = yaml.load(resolvedYaml);
  }

  @Test
  public void testJwtGeneration() throws Exception {

    String jwt =
        JwtAssertionHelper.generateJwt(
            testConfig.docusign.jwt.privateKey,
            testConfig.docusign.jwt.clientId,
            testConfig.docusign.jwt.userId,
            List.of(AuthScope.SIGNATURE));

    IamClient unauthenticatedSDK =
        IamClient.builder().serverURL(testConfig.docusign.oauthBasePath).build();
    String token =
        unauthenticatedSDK
            .auth()
            .getTokenFromJwtGrant()
            .request(JWTGrant.builder().assertion(jwt).build())
            .call()
            .jwtGrantResponse()
            .get()
            .accessToken();
    assertNotNull(token);
    IamClient authenticatedSDK =
        IamClient.builder()
            .serverURL(testConfig.docusign.oauthBasePath)
            .accessToken(token)
            .build();
    GetUserInfoResponse userInfoResponse = authenticatedSDK.auth().getUserInfo().call();
    assertNotNull(userInfoResponse);
    assertTrue(userInfoResponse.userInfo().isPresent());
    assertNotNull(userInfoResponse.userInfo().get().name());
  }

  @Test
  public void testJwtGenerationWithAllScopeWithoutConsent() throws Exception {

    String jwt =
        JwtAssertionHelper.generateJwt(
            testConfig.docusign.jwt.privateKey,
            testConfig.docusign.jwt.clientId,
            testConfig.docusign.jwt.userId,
            AuthScope.getAllScopes());

    IamClient unauthenticatedSDK =
        IamClient.builder().serverURL(testConfig.docusign.oauthBasePath).build();
    OAuthErrorResponse ex =
        assertThrows(
            OAuthErrorResponse.class,
            () ->
                unauthenticatedSDK
                    .auth()
                    .getTokenFromJwtGrant()
                    .request(JWTGrant.builder().assertion(jwt).build())
                    .call());
    assertEquals("consent_required", ex.error().get());
  }

  @Test
  public void testJwtAssertionWithInvalidPrivateKey() {
    Exception ex =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                JwtAssertionHelper.generateJwt(
                    "invalid-private-key",
                    testConfig.docusign.jwt.clientId,
                    testConfig.docusign.jwt.userId,
                    List.of(AuthScope.SIGNATURE)));
    assertTrue(ex.getMessage().contains("Illegal base64 character 2d"));
  }

  private static String substituteEnvVariables(String input) {
    Pattern pattern = Pattern.compile("\\$\\{([^}]+)}");
    StringBuilder result = new StringBuilder();

    String[] lines = input.split("\\r?\\n");
    for (String line : lines) {
      if (line.trim().startsWith("#")) {
        result.append(line).append(System.lineSeparator());
        continue;
      }

      Matcher matcher = pattern.matcher(line);
      StringBuffer sb = new StringBuffer();

      while (matcher.find()) {
        String envVar = matcher.group(1);
        String envValue = System.getenv(envVar);
        if (envValue == null) {
          throw new IllegalArgumentException("Environment variable " + envVar + " is not set");
        }

        matcher.appendReplacement(sb, Matcher.quoteReplacement(envValue));
      }
      matcher.appendTail(sb);
      result.append(sb).append(System.lineSeparator());
    }

    return result.toString();
  }
}
