# Docusign IAM Java SDK

Developer-friendly & type-safe Java SDK specifically catered to leverage
*Docusign IAM* APIs.

## Summary

This SDK enables Java developers to abstract and simplify the
use of the Docusign IAM APIs.

By installing this package, developers can then use Java objects and
methods to interact with the following Docusign APIs:

* [Maestro API](https://developers.docusign.com/docs/maestro-api/)
* [Navigator API](https://developers.docusign.com/docs/navigator-api/)
* [Connected Fields API](https://developers.docusign.com/docs/connected-fields-api/)

This repo contains the source-code for this SDK. You only need to use the code
in this repo if you want to customize the SDK for your own needs. To use the
SDK you just need to install the npm package and do not need to use this repo.

You can also find code examples and documentation for this SDK in the [Docusign
Developer Center](https://developers.docusign.com/).

<!-- No Summary [summary] -->

<!-- Start Table of Contents [toc] -->
## Table of Contents
<!-- $toc-max-depth=2 -->
* [Docusign IAM Java SDK](#docusign-iam-java-sdk)
  * [SDK Installation](#sdk-installation)
  * [SDK Example Usage](#sdk-example-usage)
  * [Authentication](#authentication)
  * [Available Resources and Operations](#available-resources-and-operations)
  * [Retries](#retries)
  * [Error Handling](#error-handling)
  * [Server Selection](#server-selection)
* [Development](#development)
  * [Maturity](#maturity)
  * [Contributions](#contributions)

<!-- End Table of Contents [toc] -->

<!-- Start SDK Installation [installation] -->
## SDK Installation

### Getting started

JDK 11 or later is required.

The samples below show how a published SDK artifact is used:

Gradle:
```groovy
implementation 'com.docusign:iam-sdk:1.0.0-beta.3'
```

Maven:
```xml
<dependency>
    <groupId>com.docusign</groupId>
    <artifactId>iam-sdk</artifactId>
    <version>1.0.0-beta.3</version>
</dependency>
```

### How to build
After cloning the git repository to your file system you can build the SDK artifact from source to the `build` directory by running `./gradlew build` on *nix systems or `gradlew.bat` on Windows systems.

If you wish to build from source and publish the SDK artifact to your local Maven repository (on your filesystem) then use the following command (after cloning the git repo locally):

On *nix:
```bash
./gradlew publishToMavenLocal -Pskip.signing
```
On Windows:
```bash
gradlew.bat publishToMavenLocal -Pskip.signing
```

### Logging
A logging framework/facade has not yet been adopted but is under consideration.

For request and response logging (especially json bodies), call `enableHTTPDebugLogging(boolean)` on the SDK builder like so:
```java
SDK.builder()
    .enableHTTPDebugLogging(true)
    .build();
```
Example output:
```
Sending request: http://localhost:35123/bearer#global GET
Request headers: {Accept=[application/json], Authorization=[******], Client-Level-Header=[added by client], Idempotency-Key=[some-key], x-speakeasy-user-agent=[speakeasy-sdk/java 0.0.1 internal 0.1.0 org.openapis.openapi]}
Received response: (GET http://localhost:35123/bearer#global) 200
Response headers: {access-control-allow-credentials=[true], access-control-allow-origin=[*], connection=[keep-alive], content-length=[50], content-type=[application/json], date=[Wed, 09 Apr 2025 01:43:29 GMT], server=[gunicorn/19.9.0]}
Response body:
{
  "authenticated": true, 
  "token": "global"
}
```
__WARNING__: This should only used for temporary debugging purposes. Leaving this option on in a production system could expose credentials/secrets in logs. <i>Authorization</i> headers are redacted by default and there is the ability to specify redacted header names via `SpeakeasyHTTPClient.setRedactedHeaders`.

__NOTE__: This is a convenience method that calls `HTTPClient.enableDebugLogging()`. The `SpeakeasyHTTPClient` honors this setting. If you are using a custom HTTP client, it is up to the custom client to honor this setting.

Another option is to set the System property `-Djdk.httpclient.HttpClient.log=all`. However, this second option does not log bodies.
<!-- End SDK Installation [installation] -->

<!-- Start SDK Example Usage [usage] -->
## SDK Example Usage

### Example

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetUserInfoResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken(System.getenv().getOrDefault("ACCESS_TOKEN", ""))
            .build();

        GetUserInfoResponse res = sdk.auth().getUserInfo()
                .call();

        if (res.userInfo().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End SDK Example Usage [usage] -->

<!-- Start Authentication [security] -->
## Authentication

### Using an Access Token

Once you have obtained an access token, you can use it to make authenticated
API calls to Docusign services:

```java
import com.docusign.iam.sdk.IamClient;

// Initialize the SDK with your access token
IamClient sdk = IamClient.builder()
    .accessToken("<YOUR_ACCESS_TOKEN_HERE>")
    .build();

// Make API calls on behalf of the user
var res = sdk.auth().getUserInfo().call();
```

Continue reading for more information on using the SDK to obtain an access
token!

### Obtaining an Access Token

Before using the SDK to interact with Docusign APIs on behalf of a user, you
must authenticate your application. This SDK supports OAuth2 authentication
flows for secure access to Docusign services.

To get started with authentication, you will need:

* An Integrator Key (also known as "Client ID")
* A Client Secret
* Your application registered with Docusign

These credentials are obtained by registering your application in the [Docusign
Developer Portal][ds-dev-site]. This section will guide you through setting up authentication
using the confidential authorization code grant flow, which is recommended for
server-side applications.

[ds-dev-site]: https://developers.docusign.com/

#### Step 1: Obtain User Consent

Before your application can interact with the Docusign API, you must first
obtain explicit user consent. This authorization process is a mandatory first
step for all OAuth2 flows.

Construct a consent url using `AuthorizationUrlBuilder`:

```java
import java.util.Optional;
import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.OAuthBasePath;
import com.docusign.iam.sdk.models.components.OAuthResponseType;
import com.docusign.iam.sdk.utils.auth.AuthorizationUrlBuilder;

// Create the authorization URL
String consentUrl = AuthorizationUrlBuilder.create()
    .withBasePath(OAuthBasePath.DEMO)
    .withResponseType(OAuthResponseType.CODE)
    .withClientId(System.getenv("DOCUSIGN_CLIENT_ID"))
    .withRedirectUri(System.getenv("DOCUSIGN_REDIRECT_URI"))
    .build();

// Direct the user to grant consent
System.out.println(
    "Please visit the following URL to authorize the application: " + consentUrl
);
```

After the user grants permission, Docusign will redirect them to your specified
redirect URI with an authorization code included as a query parameter named
`code`.

> [!NOTE]
> For local development, you set the redirect URI to a localhost URL (e.g.,
> `http://localhost:3000/callback`). When testing, you'll be redirected to this
> local URL and can simply copy the authorization code from your browser's
> address bar. Look for the parameter that appears after `code=` in the URL.

#### Step 2: Exchange Authorization Code for Access Token

After the user grants permission and is redirected to your application with an
authorization code, you need to exchange this code for an access token. The SDK
provides helper functions to simplify this process.

Here is an example of how one might handle the OAuth2 callback in a console
application:

```java
import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import java.util.Scanner;

try {
    // Prompt user for the authorization code
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the authorization code from the redirect URL: ");
    String authCode = scanner.nextLine();

    // Create an unauthenticated client to exchange the auth code for a token
    IamClient anonClient = IamClient.builder().build();

    // Prepare the request with the auth code
    ConfidentialAuthCodeGrantRequestBody request = ConfidentialAuthCodeGrantRequestBody.builder()
        .code(authCode)
        .build();

    // Get token using client credentials
    GetTokenFromConfidentialAuthCodeResponse res = anonClient.auth().getTokenFromConfidentialAuthCode()
        .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
            .clientId(System.getenv("DOCUSIGN_CLIENT_ID"))
            .secretKey(System.getenv("DOCUSIGN_CLIENT_SECRET"))
            .build())
        .request(request)
        .call();

    /**
     * Use the token response as needed. Eg:
     * - Store the access token and refresh token in a database
     * - Use the access token to make API calls
     * - Show the user a success message
     **/

    System.out.println("Access Token: " + res.authorizationCodeGrantResponse().get().accessToken());
} catch (OAuthErrorResponse e) {
    // Handle OAuth error
    System.out.println("OAuth Error: " + e.getMessage());
}
```

> [!NOTE]
> Additional SDK methods for obtaining access can be found
> [here][gh-oauth2-docs].

[gh-oauth2-docs]: /docs/sdks/auth/README.md

#### Step 3: Use the Access Token

Once you have obtained an access token, you can use it to make authenticated
API calls to Docusign services:

```java
import com.docusign.iam.sdk.IamClient;

// Initialize the SDK with your access token
IamClient sdk = IamClient.builder()
    .accessToken("<YOUR_ACCESS_TOKEN_HERE>")
    .build();

// Make API calls on behalf of the user
var res = sdk.auth().getUserInfo().call();
```

<!-- No Authentication [security] -->

<!-- Start Available Resources and Operations [operations] -->
## Available Resources and Operations

<details open>
<summary>Available methods</summary>

### [auth()](docs/sdks/auth/README.md)

* [getTokenFromConfidentialAuthCode](docs/sdks/auth/README.md#gettokenfromconfidentialauthcode) - Obtains an access token from the Docusign API using an authorization code.
* [getTokenFromPublicAuthCode](docs/sdks/auth/README.md#gettokenfrompublicauthcode) - Obtains an access token from the Docusign API using an authorization code.
* [getTokenFromJwtGrant](docs/sdks/auth/README.md#gettokenfromjwtgrant) - Obtains an access token from the Docusign API using a JWT grant.
* [getTokenFromRefreshToken](docs/sdks/auth/README.md#gettokenfromrefreshtoken) - Obtains an access token from the Docusign API using an authorization code.
* [getUserInfo](docs/sdks/auth/README.md#getuserinfo) - Get user information

### [connectedFields()](docs/sdks/connectedfields/README.md)


#### [connectedFields().tabInfo()](docs/sdks/tabinfo/README.md)

* [getConnectedFieldsTabGroups](docs/sdks/tabinfo/README.md#getconnectedfieldstabgroups) - Returns all tabs associated with the given account


### [maestro()](docs/sdks/maestro/README.md)


#### [maestro().workflowInstanceManagement()](docs/sdks/workflowinstancemanagement/README.md)

* [getWorkflowInstancesList](docs/sdks/workflowinstancemanagement/README.md#getworkflowinstanceslist) - Retrieve All Workflow Instances
* [getWorkflowInstance](docs/sdks/workflowinstancemanagement/README.md#getworkflowinstance) - Retrieve a Workflow Instance
* [cancelWorkflowInstance](docs/sdks/workflowinstancemanagement/README.md#cancelworkflowinstance) - Cancel a Running Workflow Instance

#### [maestro().workflows()](docs/sdks/workflows/README.md)

* [getWorkflowsList](docs/sdks/workflows/README.md#getworkflowslist) - Retrieve a list of available Maestro workflows
* [getWorkflowTriggerRequirements](docs/sdks/workflows/README.md#getworkflowtriggerrequirements) - Retrieve trigger requirements for a specific Maestro workflow
* [triggerWorkflow](docs/sdks/workflows/README.md#triggerworkflow) - Trigger a new instance of a Maestro workflow
* [pauseNewWorkflowInstances](docs/sdks/workflows/README.md#pausenewworkflowinstances) - Pause an Active Workflow
* [resumePausedWorkflow](docs/sdks/workflows/README.md#resumepausedworkflow) - Resume a Paused Workflow

### [navigator()](docs/sdks/navigator/README.md)


#### [navigator().agreements()](docs/sdks/agreements/README.md)

* [getAgreementsList](docs/sdks/agreements/README.md#getagreementslist) - Retrieve a list of agreements
* [getAgreement](docs/sdks/agreements/README.md#getagreement) - Retrieve detailed information about a specific agreement
* [deleteAgreement](docs/sdks/agreements/README.md#deleteagreement) - Delete a specific agreement
* [createAgreementSummary](docs/sdks/agreements/README.md#createagreementsummary) - Create an AI-generated summary of an agreement document

</details>
<!-- End Available Resources and Operations [operations] -->

<!-- Start Retries [retries] -->
## Retries

Some of the endpoints in this SDK support retries. If you use the SDK without any configuration, it will fall back to the default retry strategy provided by the API. However, the default retry strategy can be overridden on a per-operation basis, or across the entire SDK.

To change the default retry strategy for a single API call, you can provide a `RetryConfig` object through the `retryConfig` builder method:
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import com.docusign.iam.sdk.utils.BackoffStrategy;
import com.docusign.iam.sdk.utils.RetryConfig;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
            .build();

        ConfidentialAuthCodeGrantRequestBody req = ConfidentialAuthCodeGrantRequestBody.builder()
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .build();

        GetTokenFromConfidentialAuthCodeResponse res = sdk.auth().getTokenFromConfidentialAuthCode()
                .request(req)
                .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
                    .clientId(System.getenv().getOrDefault("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79", ""))
                    .secretKey(System.getenv().getOrDefault("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI", ""))
                    .build())
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```

If you'd like to override the default retry strategy for all operations that support retries, you can provide a configuration at SDK initialization:
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import com.docusign.iam.sdk.utils.BackoffStrategy;
import com.docusign.iam.sdk.utils.RetryConfig;
import java.lang.Exception;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .retryConfig(RetryConfig.builder()
                    .backoff(BackoffStrategy.builder()
                        .initialInterval(1L, TimeUnit.MILLISECONDS)
                        .maxInterval(50L, TimeUnit.MILLISECONDS)
                        .maxElapsedTime(1000L, TimeUnit.MILLISECONDS)
                        .baseFactor(1.1)
                        .jitterFactor(0.15)
                        .retryConnectError(false)
                        .build())
                    .build())
            .build();

        ConfidentialAuthCodeGrantRequestBody req = ConfidentialAuthCodeGrantRequestBody.builder()
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .build();

        GetTokenFromConfidentialAuthCodeResponse res = sdk.auth().getTokenFromConfidentialAuthCode()
                .request(req)
                .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
                    .clientId(System.getenv().getOrDefault("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79", ""))
                    .secretKey(System.getenv().getOrDefault("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI", ""))
                    .build())
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Retries [retries] -->

<!-- Start Error Handling [errors] -->
## Error Handling

Handling errors in this SDK should largely match your expectations. All operations return a response object or raise an exception.

By default, an API error will throw a `models/errors/APIException` exception. When custom error responses are specified for an operation, the SDK may also throw their associated exception. You can refer to respective *Errors* tables in SDK docs for more details on possible exception types for each operation. For example, the `getTokenFromConfidentialAuthCode` method throws the following exceptions:

| Error Type                       | Status Code | Content Type     |
| -------------------------------- | ----------- | ---------------- |
| models/errors/OAuthErrorResponse | 400         | application/json |
| models/errors/APIException       | 4XX, 5XX    | \*/\*            |

### Example

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
            .build();

        ConfidentialAuthCodeGrantRequestBody req = ConfidentialAuthCodeGrantRequestBody.builder()
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .build();

        GetTokenFromConfidentialAuthCodeResponse res = sdk.auth().getTokenFromConfidentialAuthCode()
                .request(req)
                .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
                    .clientId(System.getenv().getOrDefault("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79", ""))
                    .secretKey(System.getenv().getOrDefault("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI", ""))
                    .build())
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Error Handling [errors] -->

<!-- Start Server Selection [server] -->
## Server Selection

### Select Server by Name

You can override the default server globally using the `.server(AvailableServers server)` builder method when initializing the SDK client instance. The selected server will then be used as the default on the operations that use it. This table lists the names associated with the available servers:

| Name   | Server                       | Description |
| ------ | ---------------------------- | ----------- |
| `demo` | `https://api-d.docusign.com` | Demo        |
| `prod` | `https://api.docusign.com`   | Production  |

#### Example

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .server(IamClient.AvailableServers.PROD)
            .build();

        ConfidentialAuthCodeGrantRequestBody req = ConfidentialAuthCodeGrantRequestBody.builder()
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .build();

        GetTokenFromConfidentialAuthCodeResponse res = sdk.auth().getTokenFromConfidentialAuthCode()
                .request(req)
                .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
                    .clientId(System.getenv().getOrDefault("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79", ""))
                    .secretKey(System.getenv().getOrDefault("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI", ""))
                    .build())
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Override Server URL Per-Client

The default server can also be overridden globally using the `.serverURL(String serverUrl)` builder method when initializing the SDK client instance. For example:
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .serverURL("https://api-d.docusign.com")
            .build();

        ConfidentialAuthCodeGrantRequestBody req = ConfidentialAuthCodeGrantRequestBody.builder()
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .build();

        GetTokenFromConfidentialAuthCodeResponse res = sdk.auth().getTokenFromConfidentialAuthCode()
                .request(req)
                .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
                    .clientId(System.getenv().getOrDefault("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79", ""))
                    .secretKey(System.getenv().getOrDefault("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI", ""))
                    .build())
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Override Server URL Per-Operation

The server URL can also be overridden on a per-operation basis, provided a server list was specified for the operation. For example:
```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.ConfidentialAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
            .build();

        ConfidentialAuthCodeGrantRequestBody req = ConfidentialAuthCodeGrantRequestBody.builder()
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .build();

        GetTokenFromConfidentialAuthCodeResponse res = sdk.auth().getTokenFromConfidentialAuthCode()
                .request(req)
                .security(GetTokenFromConfidentialAuthCodeSecurity.builder()
                    .clientId(System.getenv().getOrDefault("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79", ""))
                    .secretKey(System.getenv().getOrDefault("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI", ""))
                    .build())
                .serverURL("https://account.docusign.com")
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```
<!-- End Server Selection [server] -->

<!-- Placeholder for Future Speakeasy SDK Sections -->

# Development

## Maturity

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning usage
to a specific package version. This way, you can install the same version each time without breaking changes unless you are intentionally
looking for the latest version.

## Contributions

While we value open-source contributions to this SDK, this library is generated programmatically. Any manual changes added to internal files will be overwritten on the next generation. 
We look forward to hearing your feedback. Feel free to open a PR or an issue with a proof of concept and we'll do our best to include it in a future release. 

### SDK Created by [Speakeasy](https://www.speakeasy.com/?utm_source=openapi&utm_campaign=java)
