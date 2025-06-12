package com.docusign.iam.sdk.security.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.security.interfaces.RSAPrivateKey;

import org.junit.jupiter.api.Test;

import com.docusign.iam.sdk.utils.auth.PrivateKeyHelper;

public class PrivateKeyHelperTest {

    // DO NOT CHANGE - This is a test only key and only meant for testing purposes, and is safe to commit.
    private static final String PKCS1_PRIVATE_KEY =
        "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDK7P6gX1Td/F3h\n" +
            "+joJWHatIX7kXEaUPUCH/W19/1f+d8lnGTUSIg0ht9BMKmhCZLGo99dzRFzbIZBz\n" +
            "V4yu3JEWrojZ/TZGgQ9hsgjnbDNL1akbBM30RVCGH1hYWzdJUuoi5yGGiAHDZNjw\n" +
            "EzTQ6wy3PJOBkk88akhv20Aj9ingj6kCoGD7GFnxh9XKOiM2xEAZpN0oCCfCQdjR\n" +
            "nn+zswecgNkmsE85GmopGNVKJ9fWsaMpVW4e9Lej3nbs7gciqfZBS3LmMp8YSdtb\n" +
            "l/pr7615urJyBK8HWqT2/6qaoVjUt1EHEFDcmdadmRWLkYmhTqZHCHlCZNNBEj58\n" +
            "f5KQ5zSBAgMBAAECggEAAQoW4jLJvd/sNJtFVYrrqIUksO/o85KWhioFCmZxzlGE\n" +
            "ti2L5fSihH7leD2xrZjwIUTyTKMGvU/khb7QCOhH37/eRUWeoLTYcG9x88k99kng\n" +
            "8qq0H0WnLLE7QSXC6DOY1Y5ER0AWBtkrCSpwBOiCgkDJ72Oor7VsjCOjq/pq21cF\n" +
            "GaQZFl5g571wvnaqI3qF5mtZH++9VZu6SaWj35JOvcymhAdo7qlBnAwWW1JpBJRQ\n" +
            "HMeWqJeXZRh5E/wuOqYZwLsXnubmLuTqhbItjIf0uG9OUKRMwDMv0X87/zoPIdn8\n" +
            "9gDerywi4w+IrYuZxcGS6bdE1a9Uv7G0rRgtPM5xqQKBgQDyWdSiVUU20IJ94gV7\n" +
            "Bv5ch+L9f/4wJpXbJ152Pksaa8zxehjom5usI87nyv3TvNIR7JwZ/wBnC9HPKv2Z\n" +
            "aE5P04NvbQcPiwy5BovSfGvAai8dPkvv+2/E1uOeFZt8aNfqUNeQTLFRDgs0kRcD\n" +
            "F0YMfDCWbJxVAVDorwA6TFf4hwKBgQDWWr1k+043lAe4PR6+Ncaq9bUSD0xYVHbk\n" +
            "Cyx5IT7HLnR8j10mZmjPVEoGwe0e75wQyzRRLIIAN1l2OnRq0xYZRWEdcL2ptLNC\n" +
            "Ko2P7GbfpVX3mg2A4INiOxDX1fyA8Tze8IvgsfS2TWlWV9jUeiChLjeFcSlesQ31\n" +
            "NIc55RYUtwKBgQCz0alvBZwEjvOz2ae9YDQNjhoDhBujuI2KfYyeaZwqL4ByT+j5\n" +
            "drQsJqmX3Us29yxbdldhBo9S5jc34yslz3oDyuoEHD6X7tFy3AOVGxKMQ31P0nBf\n" +
            "0Q1eXR+opVmoFtbWGkPH4s/SV3xC9cDAX11vWBppEo9wlzhkXazqlMjVMwKBgQCX\n" +
            "QjS/m25YXccMxWR6SKxGW1hIxC7VbdTvmsrpNwJ7v1ZHx0quHDn9g7cxCYtv9xkj\n" +
            "6KCkX0nlKSmh+iHId+fyMTkUc0gDBxYvrKN0WhdF3f/J1xWMSeGsYY3DIKcrvg98\n" +
            "KjYqeqj6M6oPWbISTZPU6S4Ypf/RaBM3YrfBrNxmBQKBgD3C60TGvrSdQ/zURru8\n" +
            "FMbMu/ocaUCVxS1b77/t2nB+VDMLIcCKXztJoNG7cozwR7HZhtKLvV+aWmh6FGgG\n" +
            "d/w42IQvPDQbpq4jm2ofvpqqujsXvVl8J7pbDjQrLwXc6Nl/E6Zuvd+sPTVGA55e\n" +
            "rr0WGkP1HPMPrF9SxrEvX+VI\n" +
            "-----END PRIVATE KEY-----";

    // DO NOT CHANGE - This is a test only key and only meant for testing purposes, and is safe to commit.
    private static final String PKCS8_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n" +
        "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDK7P6gX1Td/F3h\n" +
        "+joJWHatIX7kXEaUPUCH/W19/1f+d8lnGTUSIg0ht9BMKmhCZLGo99dzRFzbIZBz\n" +
        "V4yu3JEWrojZ/TZGgQ9hsgjnbDNL1akbBM30RVCGH1hYWzdJUuoi5yGGiAHDZNjw\n" +
        "EzTQ6wy3PJOBkk88akhv20Aj9ingj6kCoGD7GFnxh9XKOiM2xEAZpN0oCCfCQdjR\n" +
        "nn+zswecgNkmsE85GmopGNVKJ9fWsaMpVW4e9Lej3nbs7gciqfZBS3LmMp8YSdtb\n" +
        "l/pr7615urJyBK8HWqT2/6qaoVjUt1EHEFDcmdadmRWLkYmhTqZHCHlCZNNBEj58\n" +
        "f5KQ5zSBAgMBAAECggEAAQoW4jLJvd/sNJtFVYrrqIUksO/o85KWhioFCmZxzlGE\n" +
        "ti2L5fSihH7leD2xrZjwIUTyTKMGvU/khb7QCOhH37/eRUWeoLTYcG9x88k99kng\n" +
        "8qq0H0WnLLE7QSXC6DOY1Y5ER0AWBtkrCSpwBOiCgkDJ72Oor7VsjCOjq/pq21cF\n" +
        "GaQZFl5g571wvnaqI3qF5mtZH++9VZu6SaWj35JOvcymhAdo7qlBnAwWW1JpBJRQ\n" +
        "HMeWqJeXZRh5E/wuOqYZwLsXnubmLuTqhbItjIf0uG9OUKRMwDMv0X87/zoPIdn8\n" +
        "9gDerywi4w+IrYuZxcGS6bdE1a9Uv7G0rRgtPM5xqQKBgQDyWdSiVUU20IJ94gV7\n" +
        "Bv5ch+L9f/4wJpXbJ152Pksaa8zxehjom5usI87nyv3TvNIR7JwZ/wBnC9HPKv2Z\n" +
        "aE5P04NvbQcPiwy5BovSfGvAai8dPkvv+2/E1uOeFZt8aNfqUNeQTLFRDgs0kRcD\n" +
        "F0YMfDCWbJxVAVDorwA6TFf4hwKBgQDWWr1k+043lAe4PR6+Ncaq9bUSD0xYVHbk\n" +
        "Cyx5IT7HLnR8j10mZmjPVEoGwe0e75wQyzRRLIIAN1l2OnRq0xYZRWEdcL2ptLNC\n" +
        "Ko2P7GbfpVX3mg2A4INiOxDX1fyA8Tze8IvgsfS2TWlWV9jUeiChLjeFcSlesQ31\n" +
        "NIc55RYUtwKBgQCz0alvBZwEjvOz2ae9YDQNjhoDhBujuI2KfYyeaZwqL4ByT+j5\n" +
        "drQsJqmX3Us29yxbdldhBo9S5jc34yslz3oDyuoEHD6X7tFy3AOVGxKMQ31P0nBf\n" +
        "0Q1eXR+opVmoFtbWGkPH4s/SV3xC9cDAX11vWBppEo9wlzhkXazqlMjVMwKBgQCX\n" +
        "QjS/m25YXccMxWR6SKxGW1hIxC7VbdTvmsrpNwJ7v1ZHx0quHDn9g7cxCYtv9xkj\n" +
        "6KCkX0nlKSmh+iHId+fyMTkUc0gDBxYvrKN0WhdF3f/J1xWMSeGsYY3DIKcrvg98\n" +
        "KjYqeqj6M6oPWbISTZPU6S4Ypf/RaBM3YrfBrNxmBQKBgD3C60TGvrSdQ/zURru8\n" +
        "FMbMu/ocaUCVxS1b77/t2nB+VDMLIcCKXztJoNG7cozwR7HZhtKLvV+aWmh6FGgG\n" +
        "d/w42IQvPDQbpq4jm2ofvpqqujsXvVl8J7pbDjQrLwXc6Nl/E6Zuvd+sPTVGA55e\n" +
        "rr0WGkP1HPMPrF9SxrEvX+VI\n" +
        "-----END PRIVATE KEY-----\n";

    @Test
    public void testParsePKCS1PrivateKey() throws Exception {
        RSAPrivateKey privateKey = PrivateKeyHelper.parsePrivateKey(PKCS1_PRIVATE_KEY);
        assertNotNull(privateKey, "PKCS#1 key should be parsed successfully");
        assertEquals("RSA", privateKey.getAlgorithm());
        assertTrue( privateKey.getModulus().bitLength() >= 1024, "Key size should be at least 1024 bits");
    }

    @Test
    public void testParsePKCS8PrivateKey() throws Exception {
        RSAPrivateKey privateKey = PrivateKeyHelper.parsePrivateKey(PKCS8_PRIVATE_KEY);
        assertNotNull(privateKey, "PKCS#8 key should be parsed successfully");
        assertEquals("RSA", privateKey.getAlgorithm());
        assertTrue(privateKey.getModulus().bitLength() >= 1024, "Key size should be at least 1024 bits");
    }
}
