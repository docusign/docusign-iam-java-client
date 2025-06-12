package com.docusign.iam.sdk.config;

public class TestConfig {
  public DocusignConfig docusign;

  public static class DocusignConfig {
    public String oauthBasePath;
    public String apiBasePath;
    public String accountId;
    public String redirectUri;

    public JwtConfig jwt;
    public ConfidentialConfig confidential;
    public PublicConfig
        publicConfig; // "public" is a reserved keyword in Java, so we are using publicConfig

    public static class JwtConfig {
      public String clientId;
      public String userId;
      public String privateKey;
    }

    public static class ConfidentialConfig {
      public String clientId;
      public String secretKey;
      public int expiresIn;
      public String accessToken;
      public String refreshToken;
    }

    public static class PublicConfig {
      public String clientId;
      public int expiresIn;
      public String accessToken;
      public String refreshToken;
    }
  }
}
