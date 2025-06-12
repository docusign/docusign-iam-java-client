package com.docusign.iam.sdk.models.components;

public enum OAuthResponseType {
  CODE("code"),
  TOKEN("token");

  private final String value;

  OAuthResponseType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
