package com.docusign.iam.sdk.utils.auth;

import com.docusign.iam.sdk.models.components.AuthScope;
import com.docusign.iam.sdk.models.components.OAuthBasePath;
import com.docusign.iam.sdk.models.components.OAuthResponseType;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class AuthorizationUrlBuilder {

  private final Set<String> scopes = new HashSet<>();
  private String oauthBasePath;
  private String responseType;
  private String clientId;
  private String redirectUri;
  private String state;
  private String codeChallenge;

  private AuthorizationUrlBuilder() {}

  public static AuthorizationUrlBuilder builder() {
    return new AuthorizationUrlBuilder();
  }

  public AuthorizationUrlBuilder basePath(OAuthBasePath oauthBasePath) {
    this.oauthBasePath = oauthBasePath.getUrl();
    return this;
  }

  public AuthorizationUrlBuilder responseType(OAuthResponseType responseType) {
    this.responseType = responseType.getValue();
    return this;
  }

  public AuthorizationUrlBuilder clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  public AuthorizationUrlBuilder addScopes(Collection<AuthScope> scopes) {
    for (AuthScope scope : scopes) {
      this.scopes.add(scope.getValue());
    }
    return this;
  }

  public AuthorizationUrlBuilder redirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
    return this;
  }

  public AuthorizationUrlBuilder state(String state) {
    this.state = state;
    return this;
  }

  public AuthorizationUrlBuilder codeChallenge(String codeChallenge) {
    this.codeChallenge = codeChallenge;
    return this;
  }

  public String build() {
    Map<String, String> queryParams = new LinkedHashMap<>();

    if (oauthBasePath == null || oauthBasePath.isBlank()) {
      basePath(OAuthBasePath.DEMO);
    }

    queryParams.put("response_type", requireNonBlank(responseType, "response_type"));
    queryParams.put("client_id", requireNonBlank(clientId, "client_id"));
    queryParams.put("redirect_uri", requireNonBlank(redirectUri, "redirect_uri"));

    String scopeString =
        scopes.isEmpty()
            ? AuthScope.getAllScopes().stream()
                .map(AuthScope::getValue)
                .collect(Collectors.joining(" "))
            : String.join(" ", scopes);
    queryParams.put("scope", scopeString);

    if (codeChallenge != null && !codeChallenge.isBlank()) {
      queryParams.put("code_challenge", codeChallenge);
      queryParams.put("code_challenge_method", "S256");
    }

    if (state != null && !state.isBlank()) {
      queryParams.put("state", state);
    }

    String query =
        queryParams.entrySet().stream()
            .map(e -> e.getKey() + "=" + urlEncode(e.getValue()))
            .collect(Collectors.joining("&"));

    try {
      return new URI("https://" + oauthBasePath + "/oauth/auth?" + query).toString();
    } catch (URISyntaxException e) {
      throw new IllegalStateException("Invalid URI construction", e);
    }
  }

  private String requireNonBlank(String value, String fieldName) {
    if (value == null || value.isBlank()) {
      throw new IllegalStateException(fieldName + " is required.");
    }
    return value;
  }

  private String urlEncode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }
}
