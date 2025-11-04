# Workspaces2
(*workspaces().workspaces()*)

## Overview

### Available Operations

* [getWorkspaces](#getworkspaces) - Gets workspaces available to the calling user
* [createWorkspace](#createworkspace) - Creates a new workspace
* [updateWorkspace](#updateworkspace) - Updates an existing workspace
* [getWorkspace](#getworkspace) - Returns details about the workspace
* [getWorkspaceAssignableRoles](#getworkspaceassignableroles) - Returns the roles the caller can assign to workspace users
* [createWorkspaceEnvelope](#createworkspaceenvelope) - Creates an envelope with the given documents. Returns the ID of the created envelope
* [getWorkspaceEnvelopes](#getworkspaceenvelopes) - Returns the envelopes associated with the given workspace

## getWorkspaces

This operation retrieves a list of workspaces available to the calling user. It returns basic information about each workspace, including its unique identifier (ID), name, and metadata such as when it was created and by whom.

Pagination is supported by passing `start_position` and `count` in the request. The response will include `resultSetSize`, `start_position`, and `end_position` which may be utilized for subsequent requests.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaces" method="get" path="/v1/accounts/{accountId}/workspaces" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspacesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspacesResponse res = sdk.workspaces().workspaces().getWorkspaces()
                .accountId("c0aa779c-d467-40d4-863c-49bc82f11d0f")
                .call();

        if (res.getWorkspacesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                            | Type                                                                 | Required                                                             | Description                                                          |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- | -------------------------------------------------------------------- |
| `accountId`                                                          | *String*                                                             | :heavy_check_mark:                                                   | The ID of the account                                                |
| `count`                                                              | *Optional\<Integer>*                                                 | :heavy_minus_sign:                                                   | Number of workspaces to return. Defaults to the maximum which is 100 |
| `startPosition`                                                      | *Optional\<Integer>*                                                 | :heavy_minus_sign:                                                   | Position of the first item in the total results. Defaults to 0       |

### Response

**[GetWorkspacesResponse](../../models/operations/GetWorkspacesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## createWorkspace

This operation creates a new workspace. The calling user is automatically added as a member of the workspace with the role of Manage.

Once created, the `workspace_id` is utilized to associate tasks such as envelopes. Participants on tasks will automatically be added to the workspace with the Participate role.

### Example Usage

<!-- UsageSnippet language="java" operationID="createWorkspace" method="post" path="/v1/accounts/{accountId}/workspaces" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.CreateWorkspaceBody;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.CreateWorkspaceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        CreateWorkspaceResponse res = sdk.workspaces().workspaces().createWorkspace()
                .accountId("a112e56c-a7e3-42a4-841a-04ccff785253")
                .createWorkspaceBody(CreateWorkspaceBody.builder()
                    .name("<value>")
                    .build())
                .call();

        if (res.createWorkspaceResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `accountId`                                                           | *String*                                                              | :heavy_check_mark:                                                    | The ID of the account                                                 |
| `createWorkspaceBody`                                                 | [CreateWorkspaceBody](../../models/components/CreateWorkspaceBody.md) | :heavy_check_mark:                                                    | The details of the workspace to be created including the name         |

### Response

**[CreateWorkspaceResponse](../../models/operations/CreateWorkspaceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateWorkspace

This operation updates details about a specific workspace. It returns the workspace's unique identifier (ID), name, and metadata such as when it was created and by whom.

### Example Usage

<!-- UsageSnippet language="java" operationID="updateWorkspace" method="put" path="/v1/accounts/{accountId}/workspaces/{workspaceId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.UpdateWorkspaceBody;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.UpdateWorkspaceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        UpdateWorkspaceResponse res = sdk.workspaces().workspaces().updateWorkspace()
                .accountId("a03ca946-93ee-47cf-8cbe-a53c7e3284bf")
                .workspaceId("c41ace15-4a79-4fe4-84bb-81adc9c7df98")
                .updateWorkspaceBody(UpdateWorkspaceBody.builder()
                    .name("<value>")
                    .build())
                .call();

        if (res.updateWorkspaceResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                             | Type                                                                  | Required                                                              | Description                                                           |
| --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------------------------------------- |
| `accountId`                                                           | *String*                                                              | :heavy_check_mark:                                                    | The ID of the account                                                 |
| `workspaceId`                                                         | *String*                                                              | :heavy_check_mark:                                                    | The ID of the workspace                                               |
| `updateWorkspaceBody`                                                 | [UpdateWorkspaceBody](../../models/components/UpdateWorkspaceBody.md) | :heavy_check_mark:                                                    | N/A                                                                   |

### Response

**[UpdateWorkspaceResponse](../../models/operations/UpdateWorkspaceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspace

This operation retrieves details about a specific workspace. It returns the workspace's unique identifier (ID), name, and metadata such as when it was created and by whom.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspace" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceResponse res = sdk.workspaces().workspaces().getWorkspace()
                .accountId("ad230bf6-0f5f-4b96-87ed-f1dfb60c2369")
                .workspaceId("55f7d452-cda5-4e74-a1a9-d0a5073bb942")
                .call();

        if (res.getWorkspaceResponse().isPresent()) {
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

**[GetWorkspaceResponse](../../models/operations/GetWorkspaceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspaceAssignableRoles

This operation returns roles that are assignable to users in the workspace based on the caller's role in the workspace. Roles available include Manage (internal) and Participate (external). Participate is the default role.

Users within the account are considered "Internal" and may be assigned any role. Users outside the account are considered "External" and may only be assigned "External" roles.

Pagination is supported by passing `start_position` and `count` in the request. The response will include `resultSetSize`, `start_position`, and `end_position` which may be utilized for subsequent requests.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceAssignableRoles" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/assignable-roles" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceAssignableRolesRequest;
import com.docusign.iam.sdk.models.operations.GetWorkspaceAssignableRolesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceAssignableRolesRequest req = GetWorkspaceAssignableRolesRequest.builder()
                .accountId("541b0318-7597-4668-b774-ac66de5ddf28")
                .workspaceId("62ce984d-c201-4336-9e9f-8cf191c29d9c")
                .build();

        GetWorkspaceAssignableRolesResponse res = sdk.workspaces().workspaces().getWorkspaceAssignableRoles()
                .request(req)
                .call();

        if (res.getWorkspaceAssignableRolesResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `request`                                                                                           | [GetWorkspaceAssignableRolesRequest](../../models/operations/GetWorkspaceAssignableRolesRequest.md) | :heavy_check_mark:                                                                                  | The request object to use for the request.                                                          |

### Response

**[GetWorkspaceAssignableRolesResponse](../../models/operations/GetWorkspaceAssignableRolesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## createWorkspaceEnvelope

This operation creates an envelope associated with the workspace. Using the `envelope_id` from the response, the [eSignature API](https://developers.docusign.com/docs/esign-rest-api/) may be utilized to modify the envelope and ultimately send it.

Envelope recipients will automatically be granted Participate access to the workspace. Envelope recipients will receive consolidated notifications from Docusign Workspaces rather than standard individual envelope notifications.

Docusign Connect events may be utilized to receive updates to individual envelope events.

The `envelopes` operation on the workspace may be utilized to query the status of all the envelopes in the workspace.

When `document_ids` is empty or excluded, the envelope is created without any documents from the workspace. eSignature API calls, including adding documents and templates, may be utilized to modify the envelope before it is sent. The eSignature API must be utilized to send the envelope.

### Example Usage

<!-- UsageSnippet language="java" operationID="createWorkspaceEnvelope" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/envelopes" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.WorkspaceEnvelopeForCreate;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.CreateWorkspaceEnvelopeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        CreateWorkspaceEnvelopeResponse res = sdk.workspaces().workspaces().createWorkspaceEnvelope()
                .accountId("d2da53cf-e564-4282-bb1d-8cdaa0948abe")
                .workspaceId("69b8ec97-5be8-40a3-ae01-fbff4ba7a447")
                .workspaceEnvelopeForCreate(WorkspaceEnvelopeForCreate.builder()
                    .envelopeName("<value>")
                    .build())
                .call();

        if (res.createWorkspaceEnvelopeResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                           | Type                                                                                                | Required                                                                                            | Description                                                                                         |
| --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| `accountId`                                                                                         | *String*                                                                                            | :heavy_check_mark:                                                                                  | The ID of the account                                                                               |
| `workspaceId`                                                                                       | *String*                                                                                            | :heavy_check_mark:                                                                                  | The ID of the workspace                                                                             |
| `workspaceEnvelopeForCreate`                                                                        | [WorkspaceEnvelopeForCreate](../../models/components/WorkspaceEnvelopeForCreate.md)                 | :heavy_check_mark:                                                                                  | The details of the envelope to be created including the list of document IDs to add to the envelope |

### Response

**[CreateWorkspaceEnvelopeResponse](../../models/operations/CreateWorkspaceEnvelopeResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkspaceEnvelopes

This operation retrieves a list of all associated workspace envelopes. The [`status`](https://support.docusign.com/s/document-item?bundleId=oeq1643226594604&topicId=wdm1578456348227.html) on each envelope can be used to track envelope progress. Statuses are formatted as ProperCase. e.g. `Sent`, `WaitingForOthers`, `Completed`, etc.

Based on the permissions of the caller, additional envelope details may be retrieved from the [eSignature API](https://developers.docusign.com/docs/esign-rest-api/) using the `envelope_id`.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceEnvelopes" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/envelopes" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceEnvelopesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceEnvelopesResponse res = sdk.workspaces().workspaces().getWorkspaceEnvelopes()
                .accountId("6582b4dd-d705-43f5-8bd2-cebfd9049aa8")
                .workspaceId("c80f66a9-e39c-4ab6-818e-cf6b04f77d1a")
                .call();

        if (res.getWorkspaceEnvelopesResponse().isPresent()) {
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

**[GetWorkspaceEnvelopesResponse](../../models/operations/GetWorkspaceEnvelopesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |