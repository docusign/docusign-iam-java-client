<!-- Start SDK Example Usage [usage] -->
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
<!-- End SDK Example Usage [usage] -->