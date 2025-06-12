package com.docusign.iam.sdk.hooks;

import com.docusign.iam.sdk.utils.Helpers;
import com.docusign.iam.sdk.utils.Hook;
import com.nimbusds.jose.util.Pair;
import java.net.http.HttpRequest;

public class UserAgentHook implements Hook.BeforeRequest {

  @Override
  public HttpRequest beforeRequest(Hook.BeforeRequestContext context, HttpRequest request) {

    String userAgentHeader = request.headers().firstValue("User-Agent").orElse("");
    String[] userAgentParts = userAgentHeader.split(" ");

    String sdkVersion = userAgentParts[1];
    String genVersion = userAgentParts[2];
    String oasVersion = userAgentParts[3];
    String sdkName = userAgentParts[4];

    Pair<String, String> runtime = getRuntime();
    String userAgent =
        String.format(
            "docusign-sdk/%s/%s/%s/%s_%s/%s/%s",
            oasVersion,
            sdkVersion,
            "java",
            runtime.getLeft(),
            runtime.getRight(),
            genVersion,
            sdkName);

    return Helpers.copy(request).setHeader("User-Agent", userAgent).build();
  }

  Pair<String, String> getRuntime() {
    String runtime = System.getProperty("java.runtime.name");
    String runtimeVersion = System.getProperty("java.runtime.version");
    return Pair.of(runtime, runtimeVersion);
  }
}
