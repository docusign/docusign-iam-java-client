# Workspaces.WorkspaceDocuments

## Overview

### Available Operations

* [getWorkspaceDocuments](#getworkspacedocuments) - Get documents in the workspace accessible to the calling user
* [addWorkspaceDocument](#addworkspacedocument) - Add a document to a workspace via file contents upload
* [getWorkspaceDocument](#getworkspacedocument) - Get information about the document
* [deleteWorkspaceDocument](#deleteworkspacedocument) - Deletes a document in the workspace
* [getWorkspaceDocumentContents](#getworkspacedocumentcontents) - Get the file contents of the document

## getWorkspaceDocuments

This operation retrieves the documents in the workspace that are accessible to the calling user. Documents may be added directly or automatically through tasks such as envelopes. Documents may be used to create envelopes.

Pagination is supported by passing `start_position` and `count` in the request. The response will include `resultSetSize`, `start_position`, and `end_position` which may be utilized for subsequent requests.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceDocuments" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/documents" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceDocumentsRequest;
import com.docusign.iam.sdk.models.operations.GetWorkspaceDocumentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceDocumentsRequest req = GetWorkspaceDocumentsRequest.builder()
                .accountId("61364114-072d-477f-a9fc-f9af7aea7896")
                .workspaceId("d44e8655-55a3-498e-bfc3-e23027c5c36a")
                .build();

        GetWorkspaceDocumentsResponse res = sdk.workspaces().workspaceDocuments().getWorkspaceDocuments()
                .request(req)
                .call();

        if (res.getWorkspaceDocumentsResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [GetWorkspaceDocumentsRequest](../../models/operations/GetWorkspaceDocumentsRequest.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |

### Response

**[GetWorkspaceDocumentsResponse](../../models/operations/GetWorkspaceDocumentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## addWorkspaceDocument

This operation adds a document to a workspace via file contents upload. The file is passed in the request body as a multipart/form-data file. The file name is used as the document name.

Once added, it may be used to create an envelope associated with the workspace.

### Example Usage

<!-- UsageSnippet language="java" operationID="addWorkspaceDocument" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/documents" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.AddWorkspaceDocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        AddWorkspaceDocumentResponse res = sdk.workspaces().workspaceDocuments().addWorkspaceDocument()
                .accountId("5eddb8e1-d00e-47c4-9ed6-3b1c8915ae0d")
                .workspaceId("7f9e0991-b6d1-4de8-bfa5-7724e59a3087")
                .call();

    }
}
```

### Parameters

| Parameter                                                                                        | Type                                                                                             | Required                                                                                         | Description                                                                                      |
| ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------ |
| `accountId`                                                                                      | *String*                                                                                         | :heavy_check_mark:                                                                               | The ID of the account                                                                            |
| `workspaceId`                                                                                    | *String*                                                                                         | :heavy_check_mark:                                                                               | The ID of the workspace                                                                          |
| `addWorkspaceDocumentRequest`                                                                    | [Optional\<AddWorkspaceDocumentRequest>](../../models/components/AddWorkspaceDocumentRequest.md) | :heavy_minus_sign:                                                                               | N/A                                                                                              |

### Response

**[AddWorkspaceDocumentResponse](../../models/operations/AddWorkspaceDocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspaceDocument

This operation retrieves information about the document. The response includes the document ID, name, and metadata.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceDocument" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/documents/{documentId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceDocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceDocumentResponse res = sdk.workspaces().workspaceDocuments().getWorkspaceDocument()
                .accountId("92293164-1793-41a1-8cb1-d6fdf0660804")
                .workspaceId("dfef9b70-860f-4798-889d-2f28cf5df5f4")
                .documentId("b9ed137b-5b0a-4abf-abac-ab9720001190")
                .call();

        if (res.getWorkspaceDocumentResponse().isPresent()) {
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
| `documentId`            | *String*                | :heavy_check_mark:      | The ID of the document  |

### Response

**[GetWorkspaceDocumentResponse](../../models/operations/GetWorkspaceDocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## deleteWorkspaceDocument

This operation permanently deletes a document by ID.

### Example Usage

<!-- UsageSnippet language="java" operationID="deleteWorkspaceDocument" method="delete" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/documents/{documentId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.DeleteWorkspaceDocumentResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        DeleteWorkspaceDocumentResponse res = sdk.workspaces().workspaceDocuments().deleteWorkspaceDocument()
                .accountId("2e37a9af-e272-4059-96ff-0bfcf9620437")
                .workspaceId("0013f129-d585-40d0-a299-1141daa04cf3")
                .documentId("20dad844-6281-4b04-834a-b5979c0329b7")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter               | Type                    | Required                | Description             |
| ----------------------- | ----------------------- | ----------------------- | ----------------------- |
| `accountId`             | *String*                | :heavy_check_mark:      | The ID of the account   |
| `workspaceId`           | *String*                | :heavy_check_mark:      | The ID of the workspace |
| `documentId`            | *String*                | :heavy_check_mark:      | The ID of the document  |

### Response

**[DeleteWorkspaceDocumentResponse](../../models/operations/DeleteWorkspaceDocumentResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspaceDocumentContents

This operation retrieves the file contents of the document. The file is returned as a stream in the response body. The Content-Disposition response header contains the document name as the `filename`.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceDocumentContents" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/documents/{documentId}/contents" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceDocumentContentsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceDocumentContentsResponse res = sdk.workspaces().workspaceDocuments().getWorkspaceDocumentContents()
                .accountId("4bc13f41-0697-41ee-8a11-d96266a80841")
                .workspaceId("4a268145-6144-48d9-b009-283af8fd83e8")
                .documentId("b62fd488-5ecf-4b73-878f-72550a413ac3")
                .call();

        if (res.getWorkspaceDocumentContentsResponse().isPresent()) {
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
| `documentId`            | *String*                | :heavy_check_mark:      | The ID of the document  |

### Response

**[GetWorkspaceDocumentContentsResponse](../../models/operations/GetWorkspaceDocumentContentsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |