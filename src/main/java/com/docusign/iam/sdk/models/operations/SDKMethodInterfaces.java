/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.docusign.iam.sdk.models.operations;

import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.components.PublicAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.components.TriggerWorkflow;
import com.docusign.iam.sdk.utils.Options;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;

public class SDKMethodInterfaces {

    public interface MethodCallGetTokenFromConfidentialAuthCode {
        GetTokenFromConfidentialAuthCodeResponse getTokenFromConfidentialAuthCode(
            ConfidentialAuthCodeGrantRequestBody request,
            GetTokenFromConfidentialAuthCodeSecurity security,
            Optional<String> serverURL,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetTokenFromPublicAuthCode {
        GetTokenFromPublicAuthCodeResponse getTokenFromPublicAuthCode(
            PublicAuthCodeGrantRequestBody request,
            Optional<String> serverURL,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetTokenFromJWTGrant {
        GetTokenFromJWTGrantResponse getTokenFromJwtGrant(
            JWTGrant request,
            Optional<String> serverURL,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetTokenFromRefreshToken {
        GetTokenFromRefreshTokenResponse getTokenFromRefreshToken(
            AuthorizationCodeGrant request,
            GetTokenFromRefreshTokenSecurity security,
            Optional<String> serverURL,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetUserInfo {
        GetUserInfoResponse getUserInfo(
            Optional<String> serverURL,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetWorkflowsList {
        GetWorkflowsListResponse getWorkflowsList(
            String accountId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetWorkflowTriggerRequirements {
        GetWorkflowTriggerRequirementsResponse getWorkflowTriggerRequirements(
            String accountId,
            String workflowId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallTriggerWorkflow {
        TriggerWorkflowResponse triggerWorkflow(
            String accountId,
            String workflowId,
            TriggerWorkflow triggerWorkflow,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetWorkflowInstancesList {
        GetWorkflowInstancesListResponse getWorkflowInstancesList(
            String accountId,
            String workflowId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetWorkflowInstance {
        GetWorkflowInstanceResponse getWorkflowInstance(
            String accountId,
            String workflowId,
            String instanceId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallCancelWorkflowInstance {
        CancelWorkflowInstanceResponse cancelWorkflowInstance(
            String accountId,
            String workflowId,
            String instanceId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetAgreementsList {
        GetAgreementsListResponse getAgreementsList(
            Optional<String> accountId,
            JsonNullable<Integer> limit,
            JsonNullable<String> ctoken,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallGetAgreement {
        GetAgreementResponse getAgreement(
            Optional<String> accountId,
            Optional<String> agreementId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallDeleteAgreement {
        DeleteAgreementResponse deleteAgreement(
            Optional<String> accountId,
            Optional<String> agreementId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallCreateAgreementSummary {
        CreateAgreementSummaryResponse createAgreementSummary(
            Optional<String> accountId,
            Optional<String> agreementId,
            Optional<Options> options) throws Exception;
    }

    public interface MethodCallConnectedFieldsApiGetTabGroups {
        ConnectedFieldsApiGetTabGroupsResponse getConnectedFieldsTabGroups(
            String accountId,
            Optional<String> appId,
            Optional<Options> options) throws Exception;
    }
}
