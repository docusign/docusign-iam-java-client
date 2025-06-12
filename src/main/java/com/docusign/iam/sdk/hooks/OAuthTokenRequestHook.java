package com.docusign.iam.sdk.hooks;

import com.docusign.iam.sdk.SecuritySource;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import com.docusign.iam.sdk.models.operations.GetTokenFromRefreshTokenSecurity;
import com.docusign.iam.sdk.utils.HasSecurity;
import com.docusign.iam.sdk.utils.Helpers;
import com.docusign.iam.sdk.utils.Hook;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.Set;

/**
 * Hook that adds Basic Authentication headers to OAuth token requests. This hook handles both
 * refresh token and authorization code grant types.
 */
public class OAuthTokenRequestHook implements Hook.BeforeRequest {

  private static final Set<String> SUPPORTED_OPERATIONS =
      Set.of("GetTokenFromRefreshToken", "GetTokenFromConfidentialAuthCode");

  @Override
  public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request)
      throws Exception {
    String operationId = context.operationId();

    if (!SUPPORTED_OPERATIONS.contains(operationId)) {
      return request;
    }

    Optional<SecuritySource> securitySourceOpt = context.securitySource();
    if (securitySourceOpt.isEmpty()) {
      throw new IllegalStateException("Security source is not defined");
    }

    HasSecurity security = securitySourceOpt.get().getSecurity();
    return addBasicAuthHeader(request, security);
  }

  /**
   * Adds a Basic Authentication header to the request using client credentials.
   *
   * @param request The original HTTP request
   * @param security The security object containing client credentials
   * @return The modified HTTP request with Basic Auth header
   */
  private HttpRequest addBasicAuthHeader(HttpRequest request, HasSecurity security) {
    String clientId = "";
    String secretKey = "";

    if (security instanceof GetTokenFromConfidentialAuthCodeSecurity) {
      GetTokenFromConfidentialAuthCodeSecurity authCodeSecurity =
          (GetTokenFromConfidentialAuthCodeSecurity) security;
      clientId = Optional.ofNullable(authCodeSecurity.clientId()).orElse("");
      secretKey = Optional.ofNullable(authCodeSecurity.secretKey()).orElse("");
    } else if (security instanceof GetTokenFromRefreshTokenSecurity) {
      GetTokenFromRefreshTokenSecurity refreshTokenSecurity =
          (GetTokenFromRefreshTokenSecurity) security;
      clientId = refreshTokenSecurity.clientId().orElse("");
      secretKey = refreshTokenSecurity.secretKey().orElse("");
    } else {
      return request; 
    }

    String credentials = clientId + ":" + secretKey;
    String encoded =
        Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));

    Builder requestBuilder = Helpers.copy(request).header("Authorization", "Basic " + encoded);

    return requestBuilder.build();
  }
}
