package com.docusign.iam.sdk.hooks;

//
// This file is written once by speakeasy code generation and
// thereafter will not be overwritten by speakeasy updates. As a
// consequence any customization of this class will be preserved.
//

public final class SDKHooks {

  private SDKHooks() {
    // prevent instantiation
  }

  public static void initialize(com.docusign.iam.sdk.utils.Hooks hooks) {

    UserAgentHook userAgentHook = new UserAgentHook();
    hooks.registerBeforeRequest(userAgentHook);

    OAuthTokenRequestHook oAuthTokenRequestHook = new OAuthTokenRequestHook();
    hooks.registerBeforeRequest(oAuthTokenRequestHook);

    // https://www.speakeasy.com/docs/additional-features/sdk-hooks
  }
}
