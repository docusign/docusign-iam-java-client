# WorkflowInstanceManagement
(*maestro().workflowInstanceManagement()*)

## Overview

### Available Operations

* [getWorkflowInstancesList](#getworkflowinstanceslist) - Retrieve All Workflow Instances
* [getWorkflowInstance](#getworkflowinstance) - Retrieve a Workflow Instance
* [cancelWorkflowInstance](#cancelworkflowinstance) - Cancel a Running Workflow Instance

## getWorkflowInstancesList

This operation retrieves a list of all available Maestro workflow instances. It returns basic information
about each workflow instance, including its unique identifier (`id`), name, status, timestamps, and
additional metadata.

The response provides key details that help users understand what workflow instances are in progress
or completed, and the relevant data for each. Each workflow instance entry also includes metadata, such
as who started it, when it was last modified, and how many steps have been completed.

### Use Cases:
- Listing all available workflow instances for manual or automated review
- Monitoring which workflow instances are currently running or have finished
- Gathering basic metadata about workflow instances for auditing, logging, or reporting purposes

### Key Features:
- **Comprehensive Instance Overview**: Provides a full list of workflow instances, giving visibility








  into all ongoing and completed workflows within the Maestro platform
- **Metadata for Tracking**: Includes helpful metadata like creation time, last modification date,








  and user details to support audit trails
- **Scalable and Future-Proof**: Designed to handle growing numbers of workflow instances as the








  platform scales


### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkflowInstancesList" method="get" path="/v1/accounts/{accountId}/workflows/{workflowId}/instances" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.operations.GetWorkflowInstancesListResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkflowInstancesListResponse res = sdk.maestro().workflowInstanceManagement().getWorkflowInstancesList()
                .accountId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .workflowId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .call();

        if (res.workflowInstanceCollection().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                             | Type                                  | Required                              | Description                           |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `accountId`                           | *String*                              | :heavy_check_mark:                    | The unique identifier of the account. |
| `workflowId`                          | *String*                              | :heavy_check_mark:                    | N/A                                   |

### Response

**[GetWorkflowInstancesListResponse](../../models/operations/GetWorkflowInstancesListResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkflowInstance

This operation retrieves a single Maestro workflow instance by its unique identifier (`id`).
It returns the primary details of the workflow instance, including its name, status,
starting information, and other metadata.

The response provides key details that help users understand the current state of the workflow
instance, when it was started, and who initiated it. Additional metadata is included to support
auditing and reporting within the system.

### Use Cases:
- Getting the details of a specific workflow instance for further processing or review
- Monitoring the status of a running workflow instance to determine completion or cancellation
- Accessing metadata for auditing, logging, or reporting on a single workflow instance

### Key Features:
- **Single Workflow Instance**: Provides direct access to a specific workflow instance by `id`
- **Detailed Status Information**: Includes the workflow's start and end times, status, and other lifecycle timestamps
- **Metadata for Tracking**: Useful metadata like who initiated the workflow (`started_by`) and versioning details
- **Future-Proof**: Designed to be extensible if additional fields or nested information are required over time


### Example Usage

<!-- UsageSnippet language="java" operationID="getWorkflowInstance" method="get" path="/v1/accounts/{accountId}/workflows/{workflowId}/instances/{instanceId}" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.GetWorkflowInstanceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkflowInstanceResponse res = sdk.maestro().workflowInstanceManagement().getWorkflowInstance()
                .accountId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .workflowId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .instanceId("ce20ee0f-4090-48d8-b5fa-3d05ca654f73")
                .call();

        if (res.workflowInstance().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                   | Type                                        | Required                                    | Description                                 |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| `accountId`                                 | *String*                                    | :heavy_check_mark:                          | The unique identifier of the account.       |
| `workflowId`                                | *String*                                    | :heavy_check_mark:                          | N/A                                         |
| `instanceId`                                | *String*                                    | :heavy_check_mark:                          | Unique identifier for the workflow instance |

### Response

**[GetWorkflowInstanceResponse](../../models/operations/GetWorkflowInstanceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404              | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## cancelWorkflowInstance

This operation cancels a running Maestro workflow instance by its unique identifier (`instanceId`).
Once canceled, the workflow instance will no longer continue executing any remaining steps.

### Use Cases:
- Stopping a workflow execution when it is no longer needed or relevant
- Manually intervening in a workflow to prevent it from reaching completion if conditions change

### Key Features:
- **Immediate Termination**: Ensures the workflow instance no longer processes subsequent steps
- **Clear Feedback**: Returns a confirmation message including both the instance and workflow identifiers


### Example Usage

<!-- UsageSnippet language="java" operationID="cancelWorkflowInstance" method="post" path="/v1/accounts/{accountId}/workflows/{workflowId}/instances/{instanceId}/actions/cancel" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.CancelWorkflowInstanceResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        CancelWorkflowInstanceResponse res = sdk.maestro().workflowInstanceManagement().cancelWorkflowInstance()
                .accountId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .workflowId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .instanceId("ba4a94fa-3efc-4309-9463-36899a4c6d1e")
                .call();

        if (res.cancelWorkflowInstanceResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                   | Type                                        | Required                                    | Description                                 |
| ------------------------------------------- | ------------------------------------------- | ------------------------------------------- | ------------------------------------------- |
| `accountId`                                 | *String*                                    | :heavy_check_mark:                          | The unique identifier of the account.       |
| `workflowId`                                | *String*                                    | :heavy_check_mark:                          | N/A                                         |
| `instanceId`                                | *String*                                    | :heavy_check_mark:                          | Unique identifier for the workflow instance |

### Response

**[CancelWorkflowInstanceResponse](../../models/operations/CancelWorkflowInstanceResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404, 409         | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |