# Workspaces.WorkspaceBrands

## Overview

### Available Operations

* [getWorkspaceBrand](#getworkspacebrand) - Returns details about the brand set for a workspace
* [updateWorkspaceBrand](#updateworkspacebrand) - Updates brand for an existing workspace

## getWorkspaceBrand

This operation retrieves details about a specific workspace. It returns the brand details such as its unique identifier (ID), name, and metadata such as brand colors and logos.

### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkspaceBrand" method="get" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/brand" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.GetWorkspaceBrandResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkspaceBrandResponse res = sdk.workspaces().workspaceBrands().getWorkspaceBrand()
                .accountId("0bfcafb4-f092-4bc8-8ef8-948bc7bf03c3")
                .workspaceId("a0cddd57-5c88-4a44-afcc-5b6de2154b65")
                .call();

        if (res.getWorkspaceBrandResponse().isPresent()) {
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

**[GetWorkspaceBrandResponse](../../models/operations/GetWorkspaceBrandResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## updateWorkspaceBrand

This operation updates brand for a specific workspace. It returns the brand details such as its unique identifier (ID), name, and metadata such as brand colors and logos.

### Example Usage

<!-- UsageSnippet language="java" operationID="updateWorkspaceBrand" method="put" path="/v1/accounts/{accountId}/workspaces/{workspaceId}/brand" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.UpdateWorkspaceBrandBody;
import com.docusign.iam.sdk.models.errors.ErrorDetails;
import com.docusign.iam.sdk.models.operations.UpdateWorkspaceBrandResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDetails, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        UpdateWorkspaceBrandResponse res = sdk.workspaces().workspaceBrands().updateWorkspaceBrand()
                .accountId("1b06d538-9938-4fc1-ac20-f9284b7b9a0a")
                .workspaceId("e99e34d2-4d67-46bb-89e6-29aec34fda9e")
                .updateWorkspaceBrandBody(UpdateWorkspaceBrandBody.builder()
                    .build())
                .call();

        if (res.updateWorkspaceBrandResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                       | Type                                                                            | Required                                                                        | Description                                                                     |
| ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| `accountId`                                                                     | *String*                                                                        | :heavy_check_mark:                                                              | The ID of the account                                                           |
| `workspaceId`                                                                   | *String*                                                                        | :heavy_check_mark:                                                              | The ID of the workspace                                                         |
| `updateWorkspaceBrandBody`                                                      | [UpdateWorkspaceBrandBody](../../models/components/UpdateWorkspaceBrandBody.md) | :heavy_check_mark:                                                              | N/A                                                                             |

### Response

**[UpdateWorkspaceBrandResponse](../../models/operations/UpdateWorkspaceBrandResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/ErrorDetails | 400, 401                   | application/json           |
| models/errors/ErrorDetails | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |