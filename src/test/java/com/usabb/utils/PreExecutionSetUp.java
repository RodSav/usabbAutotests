package com.usabb.utils;

public class PreExecutionSetUp {

    private final static String BASE_URL = System.getProperty("webdriver.base.url");
    private final static String HYBRIS_BASE_URL = getHybrisUrls(BASE_URL);

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getHybrisBaseUrl() {
        return HYBRIS_BASE_URL;
    }

    private static String getHybrisUrls(String url) {
        if (url.contains("hybris")) {
            if (url.contains("dev")) return "https://hybris-admin-dev.usabb.com";
            else return "https://hybris-admin-stg.usabb.com";
        } else return BASE_URL;
    }
}
