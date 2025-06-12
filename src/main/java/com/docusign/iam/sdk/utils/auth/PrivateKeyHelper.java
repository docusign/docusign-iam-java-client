package com.docusign.iam.sdk.utils.auth;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;

public class PrivateKeyHelper {

  public static RSAPrivateKey parsePrivateKey(String privateKeyPem) throws Exception {
    String cleanedKey =
        privateKeyPem
            .replaceAll("-----BEGIN (RSA )?PRIVATE KEY-----", "")
            .replaceAll("-----END (RSA )?PRIVATE KEY-----", "")
            .replaceAll("\\s+", "");

    byte[] keyBytes = Base64.getDecoder().decode(cleanedKey);

    if (privateKeyPem.contains("RSA PRIVATE KEY")) {
      // Handle PKCS#1 format -> convert to PKCS#8
      keyBytes = convertPkcs1ToPkcs8(keyBytes);
    }

    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
  }

  private static byte[] convertPkcs1ToPkcs8(byte[] pkcs1Bytes) throws IOException {
    RSAPrivateKeyStructure rsaPrivStruct =
        RSAPrivateKeyStructure.getInstance(ASN1Sequence.getInstance(pkcs1Bytes));
    PrivateKeyInfo privKeyInfo =
        new PrivateKeyInfo(
            new org.bouncycastle.asn1.x509.AlgorithmIdentifier(
                PKCSObjectIdentifiers.rsaEncryption, null),
            rsaPrivStruct);
    return privKeyInfo.getEncoded();
  }
}
