# WorkspaceUsers
(*workspaces().workspaceUsers()*)

## Overview

### Available Operations

* [getWorkspaceUsers](#getworkspaceusers) - Retrieves the list of users in the given workspace
* [addWorkspaceUser](#addworkspaceuser) - Adds a user to the workspace by email address
* [updateWorkspaceUser](#updateworkspaceuser) - Updates the specified user's role
* [revokeWorkspaceUserAccess](#revokeworkspaceuseraccess) - Revokes the specified user's access to the workspace
* [restoreWorkspaceUserAccess](#restoreworkspaceuseraccess) - Restores the specified user's access to the workspace

## getWorkspaceUsers

This operations retrieves the users in a workspace. Users sent envelopes or assigned tasks will automatically be added to the workspace with the Participate role.

Pagination is supported by passing `start_position` and `count` in the request. The response will include `resultSetSize`, `start_position`, and `end_position` which may be utilized for subsequent requests.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceUsers" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/users" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceUsersRequest;
import com.docusign.iam.sdk.models.operations.GetWorkspaceUsersResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceUsersRequest req = GetWorkspaceUsersRequest.builder()
                .accountId("9ae55a64-d2c4-4631-8668-7f4264e89a7c")
                .workspaceId("0a03290d-af53-43c0-81a3-aa5e7db57ccc")
                .build();

        GetWorkspaceUsersResponse res = sdk.workspaces().workspaceUsers().getWorkspaceUsers()
                .request(req)
                .call();

        if (res.getWorkspaceUsersResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `request`                                                                       | [GetWorkspaceUsersRequest](../../models/operations/GetWorkspaceUsersRequest.md) | :heavy_check_mark:                                                              | The request object to use for the request.                                      |

### Response

**[GetWorkspaceUsersResponse](../../models/operations/GetWorkspaceUsersResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## addWorkspaceUser

This operation manually adds an internal or external user to a specific workspace by email address. Users within the account are considered "Internal" and may be assigned any role. Users outside the account are considered "External" and may only be assigned the Participate role. This operation is not typically needed for adding external participants to a Workspace as they will be automatically added as tasks are assigned.

Available role IDs can be retrieved via the Assignable Roles operation on a workspace. If the `role_id` is not passed, the user is added with the Participate role.

### Example Usage

<!-- UsageSnippet language="java" operationID="addWorkspaceUser" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/users" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.AddWorkspaceUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        AddWorkspaceUserResponse res = sdk.workspaces().workspaceUsers().addWorkspaceUser()
                .accountId("55ecbf41-d3bb-4ed0-bb6e-019d84813dfb")
                .workspaceId("ac4a8865-6e92-436b-8c1c-596b9bc19344")
                .call();

        if (res.createWorkspaceUserResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `accountId`                                                                            | *String*                                                                               | :heavy_check_mark:                                                                     | The ID of the account                                                                  |
| `workspaceId`                                                                          | *String*                                                                               | :heavy_check_mark:                                                                     | The ID of the workspace                                                                |
| `workspaceUserForCreate`                                                               | [Optional\<WorkspaceUserForCreate>](../../models/components/WorkspaceUserForCreate.md) | :heavy_minus_sign:                                                                     | The user details                                                                       |

### Response

**[AddWorkspaceUserResponse](../../models/operations/AddWorkspaceUserResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateWorkspaceUser

This operation updates the specified user's role in the workspace. Users within the account are considered "Internal" and may be assigned any role. Users outside the account are considered "External" and may only be assigned "External" roles.

### Example Usage

<!-- UsageSnippet language="java" operationID="updateWorkspaceUser" method="put" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/users/{userId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.UpdateWorkspaceUserResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        UpdateWorkspaceUserResponse res = sdk.workspaces().workspaceUsers().updateWorkspaceUser()
                .accountId("9c21c871-31a0-41bd-b7d0-c4bc7d7e7770")
                .workspaceId("f2cc2db5-2b59-4c1d-9b36-ec191a110bd5")
                .userId("3f0ec84d-ca81-4e4e-a476-bb1a630dde86")
                .call();

        if (res.updateWorkspaceUserResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                              | Type                                                                                   | Required                                                                               | Description                                                                            |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------- |
| `accountId`                                                                            | *String*                                                                               | :heavy_check_mark:                                                                     | The ID of the account                                                                  |
| `workspaceId`                                                                          | *String*                                                                               | :heavy_check_mark:                                                                     | The ID of the workspace                                                                |
| `userId`                                                                               | *String*                                                                               | :heavy_check_mark:                                                                     | The ID of the user to update                                                           |
| `workspaceUserForUpdate`                                                               | [Optional\<WorkspaceUserForUpdate>](../../models/components/WorkspaceUserForUpdate.md) | :heavy_minus_sign:                                                                     | The user details to update to including the RoleId                                     |

### Response

**[UpdateWorkspaceUserResponse](../../models/operations/UpdateWorkspaceUserResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## revokeWorkspaceUserAccess

This operation revokes the specified user's access to the workspace. The optional `revocation_date` may be set to schedule revocation in the future. If not specified, the revocation will be immediate.

### Example Usage

<!-- UsageSnippet language="java" operationID="revokeWorkspaceUserAccess" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/users/{userId}/actions/revoke-access" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.RevokeWorkspaceUserAccessResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        RevokeWorkspaceUserAccessResponse res = sdk.workspaces().workspaceUsers().revokeWorkspaceUserAccess()
                .accountId("4b457d23-e0cf-41d6-ab4b-a1cc9d2746e9")
                .workspaceId("7d48c40f-5efb-4c83-8568-002406476a59")
                .userId("6307406e-ab4b-4d4b-b2c0-d2428dc6f8d4")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                                                                      | Type                                                                                           | Required                                                                                       | Description                                                                                    |
| ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------- |
| `accountId`                                                                                    | *String*                                                                                       | :heavy_check_mark:                                                                             | The ID of the account                                                                          |
| `workspaceId`                                                                                  | *String*                                                                                       | :heavy_check_mark:                                                                             | The ID of the workspace to revoke access from                                                  |
| `userId`                                                                                       | *String*                                                                                       | :heavy_check_mark:                                                                             | The ID of the user to be revoked from the workspace                                            |
| `revokeWorkspaceUserDetails`                                                                   | [Optional\<RevokeWorkspaceUserDetails>](../../models/components/RevokeWorkspaceUserDetails.md) | :heavy_minus_sign:                                                                             | Optional details. Allows scheduling the revocation for the future                              |

### Response

**[RevokeWorkspaceUserAccessResponse](../../models/operations/RevokeWorkspaceUserAccessResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## restoreWorkspaceUserAccess

This operation restores the specified user's access to the workspace. The user must have been previously revoked from the workspace. The access is immediately restored.

### Example Usage

<!-- UsageSnippet language="java" operationID="restoreWorkspaceUserAccess" method="post" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/users/{userId}/actions/restore-access" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.RestoreWorkspaceUserAccessResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        RestoreWorkspaceUserAccessResponse res = sdk.workspaces().workspaceUsers().restoreWorkspaceUserAccess()
                .accountId("03055c38-466e-4bf1-91d0-c49ecbc09b8f")
                .workspaceId("0c281df3-a315-4c3f-9f07-6b0a3b953797")
                .userId("cf3df2ba-fa4b-4787-b8ad-9932a4d5f94b")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                                          | Type                                               | Required                                           | Description                                        |
| -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- | -------------------------------------------------- |
| `accountId`                                        | *String*                                           | :heavy_check_mark:                                 | The ID of the account                              |
| `workspaceId`                                      | *String*                                           | :heavy_check_mark:                                 | The ID of the workspace to restore access          |
| `userId`                                           | *String*                                           | :heavy_check_mark:                                 | The ID of the user to be restored to the workspace |

### Response

**[RestoreWorkspaceUserAccessResponse](../../models/operations/RestoreWorkspaceUserAccessResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |