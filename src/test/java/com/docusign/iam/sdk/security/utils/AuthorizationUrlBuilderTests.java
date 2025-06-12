package com.docusign.iam.sdk.security.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.docusign.iam.sdk.models.components.AuthScope;
import com.docusign.iam.sdk.models.components.OAuthBasePath;
import com.docusign.iam.sdk.models.components.OAuthResponseType;
import com.docusign.iam.sdk.utils.auth.AuthorizationUrlBuilder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;

class AuthorizationUrlBuilderTest {

  @Test
  void testBuildUrlWithAllFields() {
    String url =
        AuthorizationUrlBuilder.builder()
            .basePath(OAuthBasePath.DEMO)
            .responseType(OAuthResponseType.CODE)
            .clientId("test-client-id")
            .redirectUri("https://example.com/callback")
            .addScopes(List.of(AuthScope.IMPERSONATION, AuthScope.SIGNATURE))
            .state("xyz123")
            .codeChallenge("testChallenge")
            .build();

    assertTrue(url.startsWith("https://account-d.docusign.com/oauth/auth?"));
    assertTrue(url.contains("response_type=code"));
    assertTrue(url.contains("client_id=test-client-id"));
    assertTrue(url.contains("redirect_uri=" + urlEncode("https://example.com/callback")));
    assertTrue(url.contains("scope=" + urlEncode("impersonation signature")));
    assertTrue(url.contains("code_challenge=testChallenge"));
    assertTrue(url.contains("code_challenge_method=S256"));
    assertTrue(url.contains("state=xyz123"));
  }

  @Test
  void testDefaultScopeWhenNotProvided() {
    String url =
        AuthorizationUrlBuilder.builder()
            .basePath(OAuthBasePath.DEMO)
            .responseType(OAuthResponseType.CODE)
            .clientId("client-id")
            .redirectUri("https://example.com")
            .build();

    String allScopes =
        AuthScope.getAllScopes().stream()
            .map(AuthScope::getValue)
            .reduce((a, b) -> a + " " + b)
            .orElseThrow();

    assertTrue(url.contains("scope=" + urlEncode(allScopes)));
  }

  @Test
  void testWhenNoBasePathProvided() {
    String url =
        AuthorizationUrlBuilder.builder()
            .responseType(OAuthResponseType.CODE)
            .clientId("test-client-id")
            .redirectUri("https://example.com/callback")
            .build();

    assertTrue(url.startsWith("https://account-d.docusign.com/oauth/auth?"));
  }

  @Test
  void testMissingResponseTypeThrowsException() {
    IllegalStateException ex =
        assertThrows(
            IllegalStateException.class,
            () ->
                AuthorizationUrlBuilder.builder()
                    .basePath(OAuthBasePath.DEMO)
                    .clientId("client-id")
                    .redirectUri("https://example.com")
                    .build());
    assertEquals("response_type is required.", ex.getMessage());
  }

  @Test
  void testMissingClientIdThrowsException() {
    IllegalStateException ex =
        assertThrows(
            IllegalStateException.class,
            () ->
                AuthorizationUrlBuilder.builder()
                    .basePath(OAuthBasePath.DEMO)
                    .responseType(OAuthResponseType.CODE)
                    .redirectUri("https://example.com")
                    .build());
    assertEquals("client_id is required.", ex.getMessage());
  }

  @Test
  void testMissingRedirectUriThrowsException() {
    IllegalStateException ex =
        assertThrows(
            IllegalStateException.class,
            () ->
                AuthorizationUrlBuilder.builder()
                    .basePath(OAuthBasePath.DEMO)
                    .responseType(OAuthResponseType.CODE)
                    .clientId("client-id")
                    .build());
    assertEquals("redirect_uri is required.", ex.getMessage());
  }

  private static String urlEncode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }
}
