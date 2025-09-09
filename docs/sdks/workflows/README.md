# Workflows
(*maestro().workflows()*)

## Overview

### Available Operations

* [getWorkflowsList](#getworkflowslist) - Retrieve a list of available Maestro workflows
* [getWorkflowTriggerRequirements](#getworkflowtriggerrequirements) - Retrieve trigger requirements for a specific Maestro workflow
* [triggerWorkflow](#triggerworkflow) - Trigger a new instance of a Maestro workflow
* [pauseNewWorkflowInstances](#pausenewworkflowinstances) - Pause an Active Workflow
* [resumePausedWorkflow](#resumepausedworkflow) - Resume a Paused Workflow

## getWorkflowsList

This operation retrieves a list of all available Maestro workflows. It returns basic information
about each workflow, including its unique identifier (`id`), name, description, and the input
schema required to trigger the workflow.

The response provides key details that help users identify which workflows are available
and understand the input requirements for triggering each one. Each workflow entry also includes
metadata, such as when it was created, last modified, and by whom.

This operation is useful for obtaining an overview of all workflows within the system, helping
users and systems know what workflows are defined, what inputs they require, and how they can
be triggered.

### Use Cases:
- Listing all available workflows in a system for manual or automated workflow initiation.
- Reviewing the input requirements for a workflow before triggering it programmatically.
- Gathering basic metadata about workflows for auditing, logging, or reporting purposes.

### Key Features:
- **Comprehensive Workflow Overview**: Provides a full list of workflows, giving visibility








  into all the automated processes available within the Maestro platform.
- **Input Schema Information**: Each workflow includes its trigger input schema, showing








  what data must be provided when triggering the workflow.
- **Metadata for Tracking**: Useful metadata like creation time, last modification date,








  and user details are included to support tracking and auditing workflows.
- **Future-Proof**: The operation is designed to be expandable as more workflows are added








  or the platform grows, ensuring scalability in the workflow management process.


### Example Usage

<!-- UsageSnippet language="java" operationID="GetWorkflowsList" method="get" path="/v1/accounts/{accountId}/workflows" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.GetWorkflowsListResponse;
import com.docusign.iam.sdk.models.operations.Status;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkflowsListResponse res = sdk.maestro().workflows().getWorkflowsList()
                .accountId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .status(Status.ACTIVE)
                .call();

        if (res.workflowsListSuccess().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                                                                                                                                                                                                                                                                                                                                      | Type                                                                                                                                                                                                                                                                                                                                                                                                                                                           | Required                                                                                                                                                                                                                                                                                                                                                                                                                                                       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                    | Example                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `accountId`                                                                                                                                                                                                                                                                                                                                                                                                                                                    | *String*                                                                                                                                                                                                                                                                                                                                                                                                                                                       | :heavy_check_mark:                                                                                                                                                                                                                                                                                                                                                                                                                                             | The unique identifier of the account.                                                                                                                                                                                                                                                                                                                                                                                                                          | ae232f1f-8efc-4b8c-bb08-626847fad8bb                                                                                                                                                                                                                                                                                                                                                                                                                           |
| `status`                                                                                                                                                                                                                                                                                                                                                                                                                                                       | [Optional\<Status>](../../models/operations/Status.md)                                                                                                                                                                                                                                                                                                                                                                                                         | :heavy_minus_sign:                                                                                                                                                                                                                                                                                                                                                                                                                                             | Filter workflows by their status. If provided, only workflows with the specified status will be returned.<br/>- `active`: Returns only active workflows.<br/>- `inactive`: Returns only inactive workflows.<br/>- `publishing`: Returns workflows currently being published.<br/>- `unpublishing`: Returns workflows currently being unpublished.<br/>- `archived`: Returns workflows that have been archived.<br/>- `archiving`: Returns workflows currently being archived.        <br/> | active                                                                                                                                                                                                                                                                                                                                                                                                                                                         |

### Response

**[GetWorkflowsListResponse](../../models/operations/GetWorkflowsListResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404              | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## getWorkflowTriggerRequirements

This operation retrieves the configuration and input requirements necessary to trigger a specific
Maestro workflow. It provides detailed information about the `trigger_event_type`, such as HTTP
or other supported types, and specifies the required input schema, including field names, data types,
and any default values.

This information is essential for understanding the data and parameters required to initiate the
workflow. It enables developers to prepare the necessary inputs and configuration before triggering
the workflow instance, ensuring seamless execution and compliance with workflow requirements.

### Use Cases:
- Identifying the required input fields and their data types to successfully trigger the workflow.
- Reviewing the trigger configuration for validation and compliance with expected input.
- Preparing and validating data in advance of triggering the workflow, minimizing runtime errors.

### Key Features:
- **Detailed Trigger Input Requirements**: Provides an exhaustive schema of required fields,








  their data types, and optional default values for easy reference and data validation.
- **Trigger Event Type Information**: Specifies the type of event required to initiate the workflow








  (e.g., HTTP), helping developers configure their systems to invoke the workflow appropriately.
- **Configurable for Custom Triggers**: Suitable for custom configurations, enabling flexibility








  in how workflows can be triggered according to system needs.


### Example Usage

<!-- UsageSnippet language="java" operationID="GetWorkflowTriggerRequirements" method="get" path="/v1/accounts/{accountId}/workflows/{workflowId}/trigger-requirements" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.GetWorkflowTriggerRequirementsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetWorkflowTriggerRequirementsResponse res = sdk.maestro().workflows().getWorkflowTriggerRequirements()
                .accountId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .workflowId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .call();

        if (res.workflowTriggerRequirementsSuccess().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                             | Type                                  | Required                              | Description                           | Example                               |
| ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- | ------------------------------------- |
| `accountId`                           | *String*                              | :heavy_check_mark:                    | The unique identifier of the account. | ae232f1f-8efc-4b8c-bb08-626847fad8bb  |
| `workflowId`                          | *String*                              | :heavy_check_mark:                    | N/A                                   |                                       |

### Response

**[GetWorkflowTriggerRequirementsResponse](../../models/operations/GetWorkflowTriggerRequirementsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404              | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## triggerWorkflow

This operation triggers a new instance of a specified Maestro workflow. When invoked,
the workflow is started based on the provided input data, and the workflow instance
begins executing according to its defined logic and configuration.

The request requires an `instance_name` and any input data necessary to start the workflow,
as described by the workflow's `trigger_input_schema`. The `instance_name` is a user-defined
label for tracking the workflow run, while the input data fields should match the schema defined
in the workflow.

The operation is event-driven and typically triggered by an external HTTP event or system call,
allowing for the automatic execution of complex processes that span multiple systems or components.

Upon successful execution, the response returns the unique identifier (`id`) for the newly
created workflow instance, along with a URL (`workflow_instance_url`) that can be used to
interact with or track the running instance.

### Use Cases:
- Automating user registration workflows where input fields like `name` and `email` are provided.
- Processing financial transactions where details such as `amount` and `currency` are required.
- Sending notifications based on user interactions in other systems.

### Key Features:
- **Automated Execution**: Once triggered, the workflow runs until a step requires manual intervention.
- **Input-Driven**: Workflow execution is based on the provided input data, which is validated








  against the workflow's input schema.
- **Real-Time Triggering**: Designed to be invoked as part of an event-driven architecture,








  allowing for workflows to respond to external events.
- **Tracking and Interaction**: The response includes a URL that allows users to check the status








  of the workflow instance or take further actions while it runs.


### Example Usage

<!-- UsageSnippet language="java" operationID="TriggerWorkflow" method="post" path="/v1/accounts/{accountId}/workflows/{workflowId}/actions/trigger" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.TriggerInputs;
import com.docusign.iam.sdk.models.components.TriggerWorkflow;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.TriggerWorkflowResponse;
import java.lang.Exception;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        TriggerWorkflowResponse res = sdk.maestro().workflows().triggerWorkflow()
                .accountId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .workflowId("ae232f1f-8efc-4b8c-bb08-626847fad8bb")
                .triggerWorkflow(TriggerWorkflow.builder()
                    .instanceName("My Instance")
                    .triggerInputs(Map.ofEntries(
                        Map.entry("name", TriggerInputs.of("Jon Doe")),
                        Map.entry("email", TriggerInputs.of("jdoe@example.com"))))
                    .build())
                .call();

        if (res.triggerWorkflowSuccess().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                | Type                                                                                                     | Required                                                                                                 | Description                                                                                              | Example                                                                                                  |
| -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| `accountId`                                                                                              | *String*                                                                                                 | :heavy_check_mark:                                                                                       | The unique identifier of the account.                                                                    | ae232f1f-8efc-4b8c-bb08-626847fad8bb                                                                     |
| `workflowId`                                                                                             | *String*                                                                                                 | :heavy_check_mark:                                                                                       | N/A                                                                                                      |                                                                                                          |
| `triggerWorkflow`                                                                                        | [TriggerWorkflow](../../models/components/TriggerWorkflow.md)                                            | :heavy_check_mark:                                                                                       | N/A                                                                                                      | {<br/>"instance_name": "My Instance",<br/>"trigger_inputs": {<br/>"name": "Jon Doe",<br/>"email": "jdoe@example.com"<br/>}<br/>} |

### Response

**[TriggerWorkflowResponse](../../models/operations/TriggerWorkflowResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404              | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## pauseNewWorkflowInstances

This operation pauses new workflow instances from being created. Any running workflows instances will be unaffected.


### Example Usage

<!-- UsageSnippet language="java" operationID="pauseNewWorkflowInstances" method="post" path="/v1/accounts/{accountId}/workflows/{workflowId}/actions/pause" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.PauseNewWorkflowInstancesResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        PauseNewWorkflowInstancesResponse res = sdk.maestro().workflows().pauseNewWorkflowInstances()
                .accountId("<id>")
                .workflowId("<id>")
                .call();

        if (res.pauseNewWorkflowInstancesSuccess().isPresent()) {
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

**[PauseNewWorkflowInstancesResponse](../../models/operations/PauseNewWorkflowInstancesResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404, 409         | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |

## resumePausedWorkflow

This operation enables new workflow instances to be created


### Example Usage

<!-- UsageSnippet language="java" operationID="resumePausedWorkflow" method="post" path="/v1/accounts/{accountId}/workflows/{workflowId}/actions/resume" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.Error;
import com.docusign.iam.sdk.models.operations.ResumePausedWorkflowResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Error, Error, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        ResumePausedWorkflowResponse res = sdk.maestro().workflows().resumePausedWorkflow()
                .accountId("<id>")
                .workflowId("<id>")
                .call();

        if (res.resumeNewWorkflowInstancesSuccess().isPresent()) {
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

**[ResumePausedWorkflowResponse](../../models/operations/ResumePausedWorkflowResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/Error        | 400, 403, 404, 409         | application/json           |
| models/errors/Error        | 500                        | application/json           |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |