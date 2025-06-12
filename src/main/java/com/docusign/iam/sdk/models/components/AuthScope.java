package com.docusign.iam.sdk.models.components;

import java.util.Arrays;
import java.util.List;

/** Enum representing the OAuth2 scopes for Docusign. */
public enum AuthScope {
  /** Allows read access to the unified repository. */
  ADM_STORE_UNIFIED_REPO_READ("adm_store_unified_repo_read"),

  /** Allows write access to the unified repository. */
  ADM_STORE_UNIFIED_REPO_WRITE("adm_store_unified_repo_write"),

  /** Allows management of advanced workflow operations. */
  AOW_MANAGE("aow_manage"),

  /** Required for applications that impersonate users to perform API calls. */
  IMPERSONATION("impersonation"),

  /** Used to the read model schema. */
  MODELS_READ("models_read"),

  /** Required to call most eSignature REST API endpoints. */
  SIGNATURE("signature");

  private final String value;

  AuthScope(String value) {
    this.value = value;
  }

  /** Gets the string representation of the scope. */
  public String getValue() {
    return value;
  }

  /** Returns all defined scopes. */
  public static List<AuthScope> getAllScopes() {
    return Arrays.asList(values());
  }

  /** Returns scopes required for Connected Fields integration. */
  public static List<AuthScope> getConnectedFieldsScopes() {
    return List.of(ADM_STORE_UNIFIED_REPO_READ, SIGNATURE);
  }

  /** Returns scopes required for Connected Fields in Navigator. */
  public static List<AuthScope> getConnectedFieldsScopesForNavigator() {
    return List.of(ADM_STORE_UNIFIED_REPO_READ, ADM_STORE_UNIFIED_REPO_WRITE, SIGNATURE);
  }

  /** Finds enum by string value. */
  public static AuthScope fromValue(String value) {
    return Arrays.stream(values())
        .filter(scope -> scope.value.equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown scope: " + value));
  }
}
