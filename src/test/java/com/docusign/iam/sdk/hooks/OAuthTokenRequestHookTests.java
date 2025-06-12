package com.docusign.iam.sdk.hooks;

import com.docusign.iam.sdk.SecuritySource;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import com.docusign.iam.sdk.utils.HasSecurity;
import com.docusign.iam.sdk.utils.Helpers;
import com.docusign.iam.sdk.utils.Hook;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class OAuthTokenRequestHookTest {

    private Hook.BeforeRequestContext context;
    private HttpRequest request;
    private HttpRequest.Builder requestBuilder;
    private SecuritySource securitySource;
    private GetTokenFromConfidentialAuthCodeSecurity confidentialAuthCodeSecurity;
    private HasSecurity differentSecurityType;
    private OAuthTokenRequestHook hook;

    @BeforeEach
    void setUp() {
        // Initialize all mocks manually
        context = mock(Hook.BeforeRequestContext.class);
        request = mock(HttpRequest.class);
        requestBuilder = mock(HttpRequest.Builder.class);
        securitySource = mock(SecuritySource.class);
        confidentialAuthCodeSecurity = mock(GetTokenFromConfidentialAuthCodeSecurity.class);
        differentSecurityType = mock(HasSecurity.class);

        hook = new OAuthTokenRequestHook();
    }

    @Test
    void shouldAddAuthorizationHeaderForConfidentialAuthCode() throws Exception {
        // Given
        String operationId = "GetTokenFromConfidentialAuthCode";
        String clientId = "test-client-id";
        String secretKey = "test-secret-key";
        String expectedEncoded = Base64.getEncoder().encodeToString(
            (clientId + ":" + secretKey).getBytes(StandardCharsets.UTF_8));
        HttpRequest modifiedRequest = mock(HttpRequest.class);

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);
        when(context.securitySource()).thenReturn(Optional.of(securitySource));
        when(securitySource.getSecurity()).thenReturn(confidentialAuthCodeSecurity);
        when(confidentialAuthCodeSecurity.clientId()).thenReturn(clientId);
        when(confidentialAuthCodeSecurity.secretKey()).thenReturn(secretKey);

        try (MockedStatic<Helpers> helpersMock = mockStatic(Helpers.class)) {
            helpersMock.when(() -> Helpers.copy(request)).thenReturn(requestBuilder);
            when(requestBuilder.header("Authorization", "Basic " + expectedEncoded)).thenReturn(requestBuilder);
            when(requestBuilder.build()).thenReturn(modifiedRequest);

            // When
            HttpRequest result = hook.beforeRequest(context, request);

            // Then
            assertEquals(modifiedRequest, result);
            verify(requestBuilder).header("Authorization", "Basic " + expectedEncoded);
            verify(requestBuilder).build();
        }
    }

    @Test
    void shouldAddAuthorizationHeaderForRefreshTokenSecurity() throws Exception {
        // Given
        String operationId = "GetTokenFromRefreshToken";
        String clientId = "test-client-id";
        String secretKey = "test-secret-key";
        String expectedEncoded = Base64.getEncoder().encodeToString(
            (clientId + ":" + secretKey).getBytes(StandardCharsets.UTF_8));
        HttpRequest modifiedRequest = mock(HttpRequest.class);

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);
        when(context.securitySource()).thenReturn(Optional.of(securitySource));
        when(securitySource.getSecurity()).thenReturn(confidentialAuthCodeSecurity);
        when(confidentialAuthCodeSecurity.clientId()).thenReturn(clientId);
        when(confidentialAuthCodeSecurity.secretKey()).thenReturn(secretKey);

        try (MockedStatic<Helpers> helpersMock = mockStatic(Helpers.class)) {
            helpersMock.when(() -> Helpers.copy(request)).thenReturn(requestBuilder);
            when(requestBuilder.header("Authorization", "Basic " + expectedEncoded)).thenReturn(requestBuilder);
            when(requestBuilder.build()).thenReturn(modifiedRequest);

            // When
            HttpRequest result = hook.beforeRequest(context, request);

            // Then
            assertEquals(modifiedRequest, result);
            verify(requestBuilder).header("Authorization", "Basic " + expectedEncoded);
            verify(requestBuilder).build();
        }
    }

    @Test
    void shouldHandleNullClientId() throws Exception {
        // Given
        String operationId = "GetTokenFromConfidentialAuthCode";
        String secretKey = "test-secret-key";
        String expectedEncoded = Base64.getEncoder().encodeToString(
            (":" + secretKey).getBytes(StandardCharsets.UTF_8));
        HttpRequest modifiedRequest = mock(HttpRequest.class);

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);
        when(context.securitySource()).thenReturn(Optional.of(securitySource));
        when(securitySource.getSecurity()).thenReturn(confidentialAuthCodeSecurity);
        when(confidentialAuthCodeSecurity.clientId()).thenReturn(null);
        when(confidentialAuthCodeSecurity.secretKey()).thenReturn(secretKey);

        try (MockedStatic<Helpers> helpersMock = mockStatic(Helpers.class)) {
            helpersMock.when(() -> Helpers.copy(request)).thenReturn(requestBuilder);
            when(requestBuilder.header("Authorization", "Basic " + expectedEncoded)).thenReturn(requestBuilder);
            when(requestBuilder.build()).thenReturn(modifiedRequest);

            // When
            HttpRequest result = hook.beforeRequest(context, request);

            // Then
            assertEquals(modifiedRequest, result);
            verify(requestBuilder).header("Authorization", "Basic " + expectedEncoded);
            verify(requestBuilder).build();
        }
    }

    @Test
    void shouldHandleNullSecretKey() throws Exception {
        // Given
        String operationId = "GetTokenFromConfidentialAuthCode";
        String clientId = "test-client-id";
        String expectedEncoded = Base64.getEncoder().encodeToString(
            (clientId + ":").getBytes(StandardCharsets.UTF_8));
        HttpRequest modifiedRequest = mock(HttpRequest.class);

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);
        when(context.securitySource()).thenReturn(Optional.of(securitySource));
        when(securitySource.getSecurity()).thenReturn(confidentialAuthCodeSecurity);
        when(confidentialAuthCodeSecurity.clientId()).thenReturn(clientId);
        when(confidentialAuthCodeSecurity.secretKey()).thenReturn(null);

        try (MockedStatic<Helpers> helpersMock = mockStatic(Helpers.class)) {
            helpersMock.when(() -> Helpers.copy(request)).thenReturn(requestBuilder);
            when(requestBuilder.header("Authorization", "Basic " + expectedEncoded)).thenReturn(requestBuilder);
            when(requestBuilder.build()).thenReturn(modifiedRequest);

            // When
            HttpRequest result = hook.beforeRequest(context, request);

            // Then
            assertEquals(modifiedRequest, result);
            verify(requestBuilder).header("Authorization", "Basic " + expectedEncoded);
            verify(requestBuilder).build();
        }
    }

    @Test
    void shouldThrowExceptionWhenSecuritySourceIsEmpty() {
        // Given
        String operationId = "GetTokenFromConfidentialAuthCode";

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);
        when(context.securitySource()).thenReturn(Optional.empty());

        // When & Then
        IllegalStateException exception = assertThrows(IllegalStateException.class,
            () -> hook.beforeRequest(context, request));
        assertEquals("Security source is not defined", exception.getMessage());
    }

    @Test
    void shouldReturnOriginalRequestForNonMatchingOperationId() throws Exception {
        // Given
        String operationId = "SomeOtherOperation";

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);

        // When
        HttpRequest result = hook.beforeRequest(context, request);

        // Then
        assertSame(request, result);
        verifyNoMoreInteractions(securitySource, confidentialAuthCodeSecurity);
    }

    @Test
    void shouldReturnOriginalRequestForNonMatchingSecurityType() throws Exception {
        // Given
        String operationId = "GetTokenFromConfidentialAuthCode";

        // Setup mocks
        when(context.operationId()).thenReturn(operationId);
        when(context.securitySource()).thenReturn(Optional.of(securitySource));

        // Use a mock that implements HasSecurity but is not GetTokenFromConfidentialAuthCodeSecurity
        when(securitySource.getSecurity()).thenReturn(differentSecurityType);

        // When
        HttpRequest result = hook.beforeRequest(context, request);

        // Then
        assertSame(request, result);
    }
}
