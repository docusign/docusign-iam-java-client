package com.docusign.iam.sdk.models.components;

public enum OAuthBasePath {
  PRODUCTION("account.docusign.com"),
  DEMO("account-d.docusign.com");

  private String url;

  OAuthBasePath(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
