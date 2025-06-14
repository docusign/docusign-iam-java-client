/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.docusign.iam.sdk.models.operations;

import com.docusign.iam.sdk.utils.Options;
import com.docusign.iam.sdk.utils.RetryConfig;
import com.docusign.iam.sdk.utils.Utils;
import java.lang.Exception;
import java.lang.String;
import java.util.Optional;

public class CancelWorkflowInstanceRequestBuilder {

    private String accountId;
    private String workflowId;
    private String instanceId;
    private Optional<RetryConfig> retryConfig = Optional.empty();
    private final SDKMethodInterfaces.MethodCallCancelWorkflowInstance sdk;

    public CancelWorkflowInstanceRequestBuilder(SDKMethodInterfaces.MethodCallCancelWorkflowInstance sdk) {
        this.sdk = sdk;
    }

    public CancelWorkflowInstanceRequestBuilder accountId(String accountId) {
        Utils.checkNotNull(accountId, "accountId");
        this.accountId = accountId;
        return this;
    }

    public CancelWorkflowInstanceRequestBuilder workflowId(String workflowId) {
        Utils.checkNotNull(workflowId, "workflowId");
        this.workflowId = workflowId;
        return this;
    }

    public CancelWorkflowInstanceRequestBuilder instanceId(String instanceId) {
        Utils.checkNotNull(instanceId, "instanceId");
        this.instanceId = instanceId;
        return this;
    }
                
    public CancelWorkflowInstanceRequestBuilder retryConfig(RetryConfig retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = Optional.of(retryConfig);
        return this;
    }

    public CancelWorkflowInstanceRequestBuilder retryConfig(Optional<RetryConfig> retryConfig) {
        Utils.checkNotNull(retryConfig, "retryConfig");
        this.retryConfig = retryConfig;
        return this;
    }

    public CancelWorkflowInstanceResponse call() throws Exception {
        Optional<Options> options = Optional.of(Options.builder()
                                                    .retryConfig(retryConfig)
                                                    .build());
        return sdk.cancelWorkflowInstance(
            accountId,
            workflowId,
            instanceId,
            options);
    }
}
