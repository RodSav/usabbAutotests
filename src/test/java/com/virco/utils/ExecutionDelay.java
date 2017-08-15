package com.virco.utils;

import com.virco.locators.SiteData;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ${Timonov_Viacheslav} on 5/17/17.
 */
public class ExecutionDelay {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionDelay.class);

    @Test
    public void waitForSiteUp() throws InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        final String url = SiteData.DEV_STOREFRONT_URL;
        logger.info("Started connection test: URL - " + url);
        long timeout = 10000;
        logger.info("Timeout (ms) - " + timeout);
        long delay = 1800000;
        logger.info("Delay (min) - " + delay / 60000);
        boolean condition = false;
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, new TrustManager[]{new TrustAllX509TrustManager()}, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String string, SSLSession ssls) {
                return true;
            }
        });
        logger.info("SSL is disabled");
        int countWait = 0;
        synchronized (this) {
            long now = System.currentTimeMillis();
            long deadline = now + delay;
            while (!condition && now < deadline) {
                logger.info("Wait count (sec) = " + (countWait += 10));
                wait(timeout);
                now = System.currentTimeMillis();
                condition = getResponseCode(url).equalsIgnoreCase("200");
            }
            Assert.assertTrue("The site is not deployed", condition);
            logger.info("Site is deployed. Success.");
        }
    }

    private String getResponseCode(final String url) {
        RestTemplate restTemplate = new RestTemplate();
        String code = "";
        try {
            code = restTemplate.getForEntity(url, String.class).getStatusCode().toString();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return code;
    }
}
