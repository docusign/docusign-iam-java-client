# ConnectedFields.TabInfo

## Overview

### Available Operations

* [getConnectedFieldsTabGroups](#getconnectedfieldstabgroups) - Returns all tabs associated with the given account

## getConnectedFieldsTabGroups

Returns all tabs associated with the given account. 

 **Note**: Unlike the Connected Fields UI, this endpoint returns only fields that are either mandatory or have the **IsRequiredForVerifyingType** <a href="https://concerto.accordproject.org/docs/design/specification/model-decorators/" target="_blank">decorator</a>

### Example Usage

<!-- UsageSnippet language="java" operationID="ConnectedFieldsApi_GetTabGroups" method="get" path="/v1/accounts/{accountId}/connected-fields/tab-groups" -->
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.operations.ConnectedFieldsApiGetTabGroupsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        ConnectedFieldsApiGetTabGroupsResponse res = sdk.connectedFields().tabInfo().getConnectedFieldsTabGroups()
                .accountId("<id>")
                .call();

        if (res.tabInfos().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter           | Type                | Required            | Description         |
| ------------------- | ------------------- | ------------------- | ------------------- |
| `accountId`         | *String*            | :heavy_check_mark:  | N/A                 |
| `appId`             | *Optional\<String>* | :heavy_minus_sign:  | N/A                 |

### Response

**[ConnectedFieldsApiGetTabGroupsResponse](../../models/operations/ConnectedFieldsApiGetTabGroupsResponse.md)**

### Errors

| Error Type                 | Status Code                | Content Type               |
| -------------------------- | -------------------------- | -------------------------- |
| models/errors/APIException | 4XX, 5XX                   | \*/\*                      |