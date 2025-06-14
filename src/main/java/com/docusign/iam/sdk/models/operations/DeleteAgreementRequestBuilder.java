/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.docusign.iam.sdk.models.operations;

import com.docusign.iam.sdk.utils.LazySingletonValue;
import com.docusign.iam.sdk.utils.Options;
import com.docusign.iam.sdk.utils.RetryConfig;
import com.docusign.iam.sdk.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class DeleteAgreementRequestBuilder {

    private Optional<String> accountId = Utils.readDefaultOrConstValue(
                            "accountId",
                            "\"00000000-0000-0000-0000-000000000000\"",
                            new TypeReference<Optional<String>>() {});
    private Optional<String> agreementId = Utils.readDefaultOrConstValue(
                            "agreementId",
                            "\"00000000-0000-0000-0000-000000000000\"",
                            new TypeReference<Optional<String>>() {});
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallDeleteAgreement sdk;

    public DeleteAgreementRequestBuilder(SDKMethodInterfaces.MethodCallDeleteAgreement sdk) {
        this.sdk = sdk;
    }
                
    public DeleteAgreementRequestBuilder accountId(String accountId) {
        Utils.checkNotNull(accountId, "accountId");
        this.accountId = Optional.of(accountId);
        return this;
    }

    public DeleteAgreementRequestBuilder accountId(Optional<String> accountId) {
        Utils.checkNotNull(accountId, "accountId");
        this.accountId = accountId;
        return this;
    }
                
    public DeleteAgreementRequestBuilder agreementId(String agreementId) {
        Utils.checkNotNull(agreementId, "agreementId");
        this.agreementId = Optional.of(agreementId);
        return this;
    }

    public DeleteAgreementRequestBuilder agreementId(Optional<String> agreementId) {
        Utils.checkNotNull(agreementId, "agreementId");
        this.agreementId = agreementId;
        return this;
    }
                
    public DeleteAgreementRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public DeleteAgreementRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public DeleteAgreementResponse call() throws Exception {
        if (accountId == null) {
            accountId = _SINGLETON_VALUE_AccountId.value();
        }
        if (agreementId == null) {
            agreementId = _SINGLETON_VALUE_AgreementId.value();
        }        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.deleteAgreement(
            accountId,
            agreementId,
            options);
    }

    private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_AccountId =
            new LazySingletonValue<>(
                    "accountId",
                    "\"00000000-0000-0000-0000-000000000000\"",
                    new TypeReference<Optional<String>>() {});

    private static final LazySingletonValue<Optional<String>> _SINGLETON_VALUE_AgreementId =
            new LazySingletonValue<>(
                    "agreementId",
                    "\"00000000-0000-0000-0000-000000000000\"",
                    new TypeReference<Optional<String>>() {});
}
