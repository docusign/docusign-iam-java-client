package com.docusign.iam.sdk.utils.auth;

import com.docusign.iam.sdk.models.components.AuthScope;
import com.docusign.iam.sdk.models.components.OAuthBasePath;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.docusign.iam.sdk.utils.auth.PrivateKeyHelper.parsePrivateKey;

public class JwtAssertionHelper {

    /**
     * Generate a JWT assertion for the specified parameters.
     * @param privateKey
     * @param clientId
     * @param userId
     * @param oauthBasePath
     * @param scopes - if not provided, all scopes are used
     * @return
     * @throws Exception
     */
    public static String generateJwt(
        String privateKey,
        String clientId,
        String userId,
        OAuthBasePath oauthBasePath,
        List<AuthScope> scopes
    ) throws Exception {

        String basePath = oauthBasePath.getUrl();

        String scopesAsString = null;
        if (scopes == null || scopes.isEmpty()) {
            scopesAsString = AuthScope.getAllScopes().stream().map(AuthScope::getValue).collect(Collectors.joining(" "));
        }
        else {
            scopesAsString = scopes.stream().map(AuthScope::getValue).collect(Collectors.joining(" "));
        }

        Instant now = Instant.now();
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
            .issuer(clientId)
            .subject(userId)
            .audience(basePath)
            .issueTime(Date.from(now))
            .expirationTime(Date.from(now.plusSeconds(3600)))
            .notBeforeTime(Date.from(now))
            .claim("scope", scopesAsString)
            .build();

        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).type(JOSEObjectType.JWT).build();
        SignedJWT signedJWT = new SignedJWT(header, claims);
        signedJWT.sign(new RSASSASigner(parsePrivateKey(privateKey)));
        return signedJWT.serialize();
    }

    /**
     * Generate a JWT assertion for the specified parameters for demo environment only.
     * @param privateKey
     * @param clientId
     * @param userId
     * @param scopes
     * @return
     * @throws Exception
     */
    public static String generateJwt(
        String privateKey,
        String clientId,
        String userId,
        List<AuthScope> scopes
    ) throws Exception {
        return generateJwt(privateKey, clientId, userId, OAuthBasePath.DEMO, scopes);
    }
}
