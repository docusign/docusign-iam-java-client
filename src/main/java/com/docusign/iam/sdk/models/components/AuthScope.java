package com.docusign.iam.sdk.models.components;

import java.util.Arrays;
import java.util.List;

/** Enum representing the OAuth2 scopes for Docusign. */
public enum AuthScope {
  /** Allows read access to the unified repository. */
  ADM_STORE_UNIFIED_REPO_READ("adm_store_unified_repo_read"),

  /** Allows management of advanced workflow operations. */
  AOW_MANAGE("aow_manage"),

  /** Required for applications that impersonate users to perform API calls. */
  IMPERSONATION("impersonation"),

  /** Required to call most eSignature REST API endpoints. */
  SIGNATURE("signature"),

  /** Read workspace profile information */
  DTR_COMPANY_READ("dtr.company.read"),

  /** Read workspace data */
  DTR_ROOMS_READ("dtr.rooms.read"),

  /** Update workspace data */
  DTR_ROOMS_WRITE("dtr.rooms.write"),

  /** Modify workspace documents */
  DTR_DOCUMENTS_WRITE("dtr.documents.write");

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
    return List.of(ADM_STORE_UNIFIED_REPO_READ, SIGNATURE);
  }

  /** Returns scopes required for Workspace operations. */
  public static List<AuthScope> getWorkspaceScopes() {
    return List.of(DTR_COMPANY_READ, DTR_ROOMS_READ, DTR_ROOMS_WRITE, DTR_DOCUMENTS_WRITE);
  }

  /** Finds enum by string value. */
  public static AuthScope fromValue(String value) {
    return Arrays.stream(values())
        .filter(scope -> scope.value.equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown scope: " + value));
  }
}
