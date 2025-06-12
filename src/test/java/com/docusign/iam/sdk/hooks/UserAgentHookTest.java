package com.docusign.iam.sdk.hooks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.docusign.iam.sdk.utils.Hook;
import com.nimbusds.jose.util.Pair;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class UserAgentHookTest {

  @Test
  void testBeforeRequest_ModifiesUserAgentHeader() throws Exception {
    HttpRequest originalRequest =
        HttpRequest.newBuilder()
            .uri(new URI("https://example.com"))
            .header("User-Agent", "speakeasy-sdk/java 0.0.31 2.597.9 v1 docusign-test")
            .build();

    UserAgentHook hook = spy(new UserAgentHook());

    doReturn(Pair.of("TestRuntime", "1.2.3")).when(hook).getRuntime();

    Hook.BeforeRequestContext context = mock(Hook.BeforeRequestContext.class);

    HttpRequest modifiedRequest = hook.beforeRequest(context, originalRequest);

    Optional<String> userAgent = modifiedRequest.headers().firstValue("User-Agent");
    assertTrue(userAgent.isPresent());

    String expectedUserAgent =
        "docusign-sdk/v1/0.0.31/java/TestRuntime_1.2.3/2.597.9/docusign-test";
    assertEquals(expectedUserAgent, userAgent.get());
  }
}
