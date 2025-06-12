package com.docusign.iam.sdk.models.components;

public enum GrantType {
  AUTHORIZATION_CODE("authorization_code"),
  REFRESH_TOKEN("refresh_token");

  private final String value;

  GrantType(String authorizationCode) {
    this.value = authorizationCode;
  }

  public String getValue() {
    return value;
  }
}
