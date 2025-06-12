# Auth
(*auth()*)

## Overview

### Available Operations

* [getTokenFromConfidentialAuthCode](#gettokenfromconfidentialauthcode) - Obtains an access token from the Docusign API using an authorization code.
* [getTokenFromPublicAuthCode](#gettokenfrompublicauthcode) - Obtains an access token from the Docusign API using an authorization code.
* [getTokenFromJwtGrant](#gettokenfromjwtgrant) - Obtains an access token from the Docusign API using a JWT grant.
* [getTokenFromRefreshToken](#gettokenfromrefreshtoken) - Obtains an access token from the Docusign API using an authorization code.
* [getUserInfo](#getuserinfo) - Get user information

## getTokenFromConfidentialAuthCode

Obtains an access token from the Docusign API using the confidential flow.
For the developer environment, the URI is https://account-d.docusign.com/oauth/token
For the production environment, the URI is https://account.docusign.com/oauth/token
You do not need an integration key to obtain an access token.

### Example Usage

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
                    .clientId("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79")
                    .secretKey("MTIzNDU2Nzxxxxxxxxxxxxxxxxxxxxx0NTY3ODkwMTI")
                    .build())
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                                              | Type                                                                                                                                                   | Required                                                                                                                                               | Description                                                                                                                                            |
| ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `request`                                                                                                                                              | [ConfidentialAuthCodeGrantRequestBody](../../models/shared/ConfidentialAuthCodeGrantRequestBody.md)                                                    | :heavy_check_mark:                                                                                                                                     | The request object to use for the request.                                                                                                             |
| `security`                                                                                                                                             | [com.docusign.iam.sdk.models.operations.GetTokenFromConfidentialAuthCodeSecurity](../../models/operations/GetTokenFromConfidentialAuthCodeSecurity.md) | :heavy_check_mark:                                                                                                                                     | The security requirements to use for the request.                                                                                                      |
| `serverURL`                                                                                                                                            | *String*                                                                                                                                               | :heavy_minus_sign:                                                                                                                                     | An optional server URL to use.                                                                                                                         |

### Response

**[GetTokenFromConfidentialAuthCodeResponse](../../models/operations/GetTokenFromConfidentialAuthCodeResponse.md)**

### Errors

| Error Type                       | Status Code                      | Content Type                     |
| -------------------------------- | -------------------------------- | -------------------------------- |
| models/errors/OAuthErrorResponse | 400                              | application/json                 |
| models/errors/APIException       | 4XX, 5XX                         | \*/\*                            |

## getTokenFromPublicAuthCode

Obtains an access token from the Docusign API using the confidential flow.
For the developer environment, the URI is https://account-d.docusign.com/oauth/token
For the production environment, the URI is https://account.docusign.com/oauth/token
You do not need an integration key to obtain an access token.

### Example Usage

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.components.PublicAuthCodeGrantRequestBody;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromPublicAuthCodeResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken("<YOUR_ACCESS_TOKEN_HERE>")
            .build();

        PublicAuthCodeGrantRequestBody req = PublicAuthCodeGrantRequestBody.builder()
                .clientId("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79")
                .code("eyJ0eXAi.....QFsje43QVZ_gw")
                .codeVerifier("R8zFoqs0yey29G71QITZs3dK1YsdIvFNBfO4D1bukBw")
                .build();

        GetTokenFromPublicAuthCodeResponse res = sdk.auth().getTokenFromPublicAuthCode()
                .request(req)
                .call();

        if (res.authorizationCodeGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                               | Type                                                                                    | Required                                                                                | Description                                                                             |
| --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| `request`                                                                               | [PublicAuthCodeGrantRequestBody](../../models/shared/PublicAuthCodeGrantRequestBody.md) | :heavy_check_mark:                                                                      | The request object to use for the request.                                              |
| `serverURL`                                                                             | *String*                                                                                | :heavy_minus_sign:                                                                      | An optional server URL to use.                                                          |

### Response

**[GetTokenFromPublicAuthCodeResponse](../../models/operations/GetTokenFromPublicAuthCodeResponse.md)**

### Errors

| Error Type                       | Status Code                      | Content Type                     |
| -------------------------------- | -------------------------------- | -------------------------------- |
| models/errors/OAuthErrorResponse | 400                              | application/json                 |
| models/errors/APIException       | 4XX, 5XX                         | \*/\*                            |

## getTokenFromJwtGrant

Obtains an access token from the Docusign API.
                                                                                                                      
For the developer environment, the URI is https://account-d.docusign.com/oauth/token
                                                                                                                      
For the production environment, the URI is https://account.docusign.com/oauth/token
                                                                                                                      
                                                                                                                      
You do not need an integration key to obtain an access token.

### Example Usage

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetTokenFromJWTGrantResponse;
import com.docusign.iam.sdk.models.operations.JWTGrant;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken("<YOUR_ACCESS_TOKEN_HERE>")
            .build();

        JWTGrant req = JWTGrant.builder()
                .assertion("YOUR_JSON_WEB_TOKEN")
                .build();

        GetTokenFromJWTGrantResponse res = sdk.auth().getTokenFromJwtGrant()
                .request(req)
                .call();

        if (res.jwtGrantResponse().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                       | Type                                            | Required                                        | Description                                     |
| ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- | ----------------------------------------------- |
| `request`                                       | [JWTGrant](../../models/operations/JWTGrant.md) | :heavy_check_mark:                              | The request object to use for the request.      |
| `serverURL`                                     | *String*                                        | :heavy_minus_sign:                              | An optional server URL to use.                  |

### Response

**[GetTokenFromJWTGrantResponse](../../models/operations/GetTokenFromJWTGrantResponse.md)**

### Errors

| Error Type                       | Status Code                      | Content Type                     |
| -------------------------------- | -------------------------------- | -------------------------------- |
| models/errors/OAuthErrorResponse | 400                              | application/json                 |
| models/errors/APIException       | 4XX, 5XX                         | \*/\*                            |

## getTokenFromRefreshToken

Obtains an access token from the Docusign API.
For the developer environment, the URI is https://account-d.docusign.com/oauth/token
For the production environment, the URI is https://account.docusign.com/oauth/token

You do not need an integration key to obtain an access token.

### Example Usage

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.AuthorizationCodeGrant;
import com.docusign.iam.sdk.models.operations.GetTokenFromRefreshTokenResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
            .build();

        AuthorizationCodeGrant req = AuthorizationCodeGrant.builder()
                .refreshToken("<value>")
                .clientId("2da1cb14-xxxx-xxxx-xxxx-5b7b40829e79")
                .build();

        GetTokenFromRefreshTokenResponse res = sdk.auth().getTokenFromRefreshToken()
                .request(req)
                .call();

        if (res.object().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                                                                                                                              | Type                                                                                                                                   | Required                                                                                                                               | Description                                                                                                                            |
| -------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| `request`                                                                                                                              | [AuthorizationCodeGrant](../../models/operations/AuthorizationCodeGrant.md)                                                            | :heavy_check_mark:                                                                                                                     | The request object to use for the request.                                                                                             |
| `security`                                                                                                                             | [com.docusign.iam.sdk.models.operations.GetTokenFromRefreshTokenSecurity](../../models/operations/GetTokenFromRefreshTokenSecurity.md) | :heavy_check_mark:                                                                                                                     | The security requirements to use for the request.                                                                                      |
| `serverURL`                                                                                                                            | *String*                                                                                                                               | :heavy_minus_sign:                                                                                                                     | An optional server URL to use.                                                                                                         |

### Response

**[GetTokenFromRefreshTokenResponse](../../models/operations/GetTokenFromRefreshTokenResponse.md)**

### Errors

| Error Type                       | Status Code                      | Content Type                     |
| -------------------------------- | -------------------------------- | -------------------------------- |
| models/errors/OAuthErrorResponse | 400                              | application/json                 |
| models/errors/APIException       | 4XX, 5XX                         | \*/\*                            |

## getUserInfo

This endpoint retrieves user information from the Docusign API using an access token.
For the developer environment, the URI is https://account-d.docusign.com/oauth/userinfo
For the production environment, the URI is https://account.docusign.com/oauth/userinfo

### Example Usage

```java
package hello.world;

import com.docusign.iam.sdk.IamClient;
import com.docusign.iam.sdk.models.errors.OAuthErrorResponse;
import com.docusign.iam.sdk.models.operations.GetUserInfoResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws OAuthErrorResponse, Exception {

        IamClient sdk = IamClient.builder()
                .accessToken("<YOUR_ACCESS_TOKEN_HERE>")
            .build();

        GetUserInfoResponse res = sdk.auth().getUserInfo()
                .call();

        if (res.userInfo().isPresent()) {
            // handle response
        }
    }
}
```

### Parameters

| Parameter                      | Type                           | Required                       | Description                    |
| ------------------------------ | ------------------------------ | ------------------------------ | ------------------------------ |
| `serverURL`                    | *String*                       | :heavy_minus_sign:             | An optional server URL to use. |

### Response

**[GetUserInfoResponse](../../models/operations/GetUserInfoResponse.md)**

### Errors

| Error Type                       | Status Code                      | Content Type                     |
| -------------------------------- | -------------------------------- | -------------------------------- |
| models/errors/OAuthErrorResponse | 400                              | application/json                 |
| models/errors/APIException       | 4XX, 5XX                         | \*/\*                            |