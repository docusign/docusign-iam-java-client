# WorkspaceUploadRequest
(*workspaces().workspaceUploadRequest()*)

## Overview

### Available Operations

* [createWorkspaceUploadRequest](#createworkspaceuploadrequest) - Creates a new upload request within a workspace
* [getWorkspaceUploadRequests](#getworkspaceuploadrequests) - Gets upload requests within a workspace
* [getWorkspaceUploadRequest](#getworkspaceuploadrequest) - Gets details for a specific upload request
* [updateWorkspaceUploadRequest](#updateworkspaceuploadrequest) - Updates a specific upload request
* [deleteWorkspaceUploadRequest](#deleteworkspaceuploadrequest) - Deletes a specific upload request
* [addWorkspaceUploadRequestDocument](#addworkspaceuploadrequestdocument) - Add a document to an upload request via file upload
* [completeWorkspaceUploadRequest](#completeworkspaceuploadrequest) - Complete an upload request

## createWorkspaceUploadRequest

This operation creates a new upload request within a workspace. The upload request includes name, description, due date, and user assignments. Upload requests can be created as drafts or sent immediately based on the status field.

### Example Usage

<!-- UsageSnippet language="java" operationID="createWorkspaceUploadRequest" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.*;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.CreateWorkspaceUploadRequestResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;
import java.util.List;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        CreateWorkspaceUploadRequestResponse res = sdk.workspaces().workspaceUploadRequest().createWorkspaceUploadRequest()
                .accountId("1cbbee87-a846-4a71-86d2-26b7972bb7c4")
                .workspaceId("c2ab6f98-e507-43b1-8c9d-43f1db751c40")
                .createWorkspaceUploadRequestBody(CreateWorkspaceUploadRequestBody.builder()
                    .name("<value>")
                    .description("what than unique limply quaintly tattered grown")
                    .dueDate(OffsetDateTime.parse("2024-04-25T08:01:44.605Z"))
                    .assignments(List.of(
                        CreateWorkspaceUploadRequestAssignment.builder()
                            .uploadRequestResponsibilityTypeId(WorkspaceUploadRequestResponsibilityType.ASSIGNEE)
                            .build()))
                    .status(WorkspaceUploadRequestStatus.DRAFT)
                    .build())
                .call();

        if (res.getWorkspaceUploadRequestResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `accountId`                                                                                     | *String*                                                                                        | :heavy_check_mark:                                                                              | The ID of the account                                                                           |
| `workspaceId`                                                                                   | *String*                                                                                        | :heavy_check_mark:                                                                              | The ID of the workspace                                                                         |
| `createWorkspaceUploadRequestBody`                                                              | [CreateWorkspaceUploadRequestBody](../../models/components/CreateWorkspaceUploadRequestBody.md) | :heavy_check_mark:                                                                              | The upload request details including name, description, assignments, and status                 |

### Response

**[CreateWorkspaceUploadRequestResponse](../../models/operations/CreateWorkspaceUploadRequestResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspaceUploadRequests

This operation retrieves a list of upload requests within a workspace. Each upload request includes details such as ID, name, description, status, owner information, associated documents, assignments, and various dates.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceUploadRequests" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceUploadRequestsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceUploadRequestsResponse res = sdk.workspaces().workspaceUploadRequest().getWorkspaceUploadRequests()
                .accountId("5be78df1-c1f7-4e27-8b93-b0613a620dce")
                .workspaceId("b6719b00-fae9-4c7d-afce-b03f5e783434")
                .call();

        if (res.getWorkspaceUploadRequestsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter               | Type                    | Required                | Description             |
| ----------------------- | ----------------------- | ----------------------- | ----------------------- |
| `accountId`             | *String*                | :heavy_check_mark:      | The ID of the account   |
| `workspaceId`           | *String*                | :heavy_check_mark:      | The ID of the workspace |

### Response

**[GetWorkspaceUploadRequestsResponse](../../models/operations/GetWorkspaceUploadRequestsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspaceUploadRequest

This operation retrieves details about a specific upload request within a workspace. The response includes comprehensive information about the upload request including status, assigned users, associated documents, owner details, and various dates.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceUploadRequest" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests/{uploadRequestId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceUploadRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceUploadRequestResponse res = sdk.workspaces().workspaceUploadRequest().getWorkspaceUploadRequest()
                .accountId("7c24b49f-1dcd-49f1-be71-5b7d65118ca4")
                .workspaceId("0d068551-32a6-491f-8107-a554d3760bc6")
                .uploadRequestId("291c9759-17f1-4e96-8db4-c006050dc1c8")
                .call();

        if (res.getWorkspaceUploadRequestResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                    | Type                         | Required                     | Description                  |
| ---------------------------- | ---------------------------- | ---------------------------- | ---------------------------- |
| `accountId`                  | *String*                     | :heavy_check_mark:           | The ID of the account        |
| `workspaceId`                | *String*                     | :heavy_check_mark:           | The ID of the workspace      |
| `uploadRequestId`            | *String*                     | :heavy_check_mark:           | The ID of the upload request |

### Response

**[GetWorkspaceUploadRequestResponse](../../models/operations/GetWorkspaceUploadRequestResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateWorkspaceUploadRequest

This operation updates a specific upload request within a workspace. Only draft upload requests can be edited. The editable fields are name, description, due date, and status. Status changes are restricted - only transitions from draft to in_progress are allowed. Attempting to update a non-draft upload request will result in an INVALID_STATUS error. Attempting an invalid status change will result in an INVALID_STATUS_CHANGE error.

### Example Usage

<!-- UsageSnippet language="java" operationID="updateWorkspaceUploadRequest" method="put" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests/{uploadRequestId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.UpdateWorkspaceUploadRequestBody;
import com.docusign.iam.sdk.models.components.WorkspaceUploadRequestStatus;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.UpdateWorkspaceUploadRequestResponse;
import java.lang.Exception;
import java.time.OffsetDateTime;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        UpdateWorkspaceUploadRequestResponse res = sdk.workspaces().workspaceUploadRequest().updateWorkspaceUploadRequest()
                .accountId("caf60771-df4b-4068-9ca5-0e088e4b6ebc")
                .workspaceId("da4b7335-e975-49b8-9307-923a86c3b10f")
                .uploadRequestId("5d8c2cfe-7346-46e3-a188-681b6aadfcc3")
                .updateWorkspaceUploadRequestBody(UpdateWorkspaceUploadRequestBody.builder()
                    .name("<value>")
                    .description("at providence phew furthermore save digitize than how circa never")
                    .status(WorkspaceUploadRequestStatus.OVERDUE)
                    .dueDate(OffsetDateTime.parse("<value>"))
                    .build())
                .call();

        if (res.getWorkspaceUploadRequestResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                       | Type                                                                                            | Required                                                                                        | Description                                                                                     |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| `accountId`                                                                                     | *String*                                                                                        | :heavy_check_mark:                                                                              | The ID of the account                                                                           |
| `workspaceId`                                                                                   | *String*                                                                                        | :heavy_check_mark:                                                                              | The ID of the workspace                                                                         |
| `uploadRequestId`                                                                               | *String*                                                                                        | :heavy_check_mark:                                                                              | The ID of the upload request to update                                                          |
| `updateWorkspaceUploadRequestBody`                                                              | [UpdateWorkspaceUploadRequestBody](../../models/components/UpdateWorkspaceUploadRequestBody.md) | :heavy_check_mark:                                                                              | The upload request object with updated values                                                   |

### Response

**[UpdateWorkspaceUploadRequestResponse](../../models/operations/UpdateWorkspaceUploadRequestResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteWorkspaceUploadRequest

This operation deletes a specific upload request within a workspace. Upload requests cannot be deleted if they are complete or have associated documents.

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteWorkspaceUploadRequest" method="delete" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests/{uploadRequestId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.DeleteWorkspaceUploadRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        DeleteWorkspaceUploadRequestResponse res = sdk.workspaces().workspaceUploadRequest().deleteWorkspaceUploadRequest()
                .accountId("4911c672-2369-401a-b334-65cc19aa9316")
                .workspaceId("1886fee0-c032-4423-a512-78c15992cb4d")
                .uploadRequestId("81d3b642-96bd-4b5e-822b-5a5ebc552ab2")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                              | Type                                   | Required                               | Description                            |
| -------------------------------------- | -------------------------------------- | -------------------------------------- | -------------------------------------- |
| `accountId`                            | *String*                               | :heavy_check_mark:                     | The ID of the account                  |
| `workspaceId`                          | *String*                               | :heavy_check_mark:                     | The ID of the workspace                |
| `uploadRequestId`                      | *String*                               | :heavy_check_mark:                     | The ID of the upload request to delete |

### Response

**[DeleteWorkspaceUploadRequestResponse](../../models/operations/DeleteWorkspaceUploadRequestResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## addWorkspaceUploadRequestDocument

This operation adds a document to a specific upload request within a workspace via file upload. The file is passed in the request body as multipart/form-data. The file name is used as the document name.

### Example Usage

<!-- UsageSnippet language="java" operationID="addWorkspaceUploadRequestDocument" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests/{uploadRequestId}/documents" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.AddWorkspaceUploadRequestDocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        AddWorkspaceUploadRequestDocumentResponse res = sdk.workspaces().workspaceUploadRequest().addWorkspaceUploadRequestDocument()
                .accountId("8b599acd-faa6-4529-b5ad-02f99b937198")
                .workspaceId("4cbc6785-7806-4970-8bca-94d8b557bc6e")
                .uploadRequestId("a1972622-e272-42d7-9477-b2574b1da2ae")
                .call();

    }
}
```

### Parameters

| Parameter                                                                                                                  | Type                                                                                                                       | Required                                                                                                                   | Description                                                                                                                |
| -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| `accountId`                                                                                                                | *String*                                                                                                                   | :heavy_check_mark:                                                                                                         | The ID of the account                                                                                                      |
| `workspaceId`                                                                                                              | *String*                                                                                                                   | :heavy_check_mark:                                                                                                         | The ID of the workspace                                                                                                    |
| `uploadRequestId`                                                                                                          | *String*                                                                                                                   | :heavy_check_mark:                                                                                                         | The ID of the upload request                                                                                               |
| `addWorkspaceUploadRequestDocumentRequest`                                                                                 | [Optional\<AddWorkspaceUploadRequestDocumentRequest>](../../models/components/AddWorkspaceUploadRequestDocumentRequest.md) | :heavy_minus_sign:                                                                                                         | N/A                                                                                                                        |

### Response

**[AddWorkspaceUploadRequestDocumentResponse](../../models/operations/AddWorkspaceUploadRequestDocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## completeWorkspaceUploadRequest

This operation completes a specific upload request within a workspace and is intended to be called by the user completing the upload request. Only upload requests that are in progress can be completed.

### Example Usage

<!-- UsageSnippet language="java" operationID="completeWorkspaceUploadRequest" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/upload-requests/{uploadRequestId}/actions/complete" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.CompleteWorkspaceUploadRequestResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        CompleteWorkspaceUploadRequestResponse res = sdk.workspaces().workspaceUploadRequest().completeWorkspaceUploadRequest()
                .accountId("66e3adbf-237a-4dc6-a239-f5b562487126")
                .workspaceId("d44b9cea-0e4e-45ec-8c2f-4e0ce9729584")
                .uploadRequestId("ecdb900d-7e60-4a2c-8e83-0252dc622fcb")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                | Type                                     | Required                                 | Description                              |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| `accountId`                              | *String*                                 | :heavy_check_mark:                       | The ID of the account                    |
| `workspaceId`                            | *String*                                 | :heavy_check_mark:                       | The ID of the workspace                  |
| `uploadRequestId`                        | *String*                                 | :heavy_check_mark:                       | The ID of the upload request to complete |

### Response

**[CompleteWorkspaceUploadRequestResponse](../../models/operations/CompleteWorkspaceUploadRequestResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |