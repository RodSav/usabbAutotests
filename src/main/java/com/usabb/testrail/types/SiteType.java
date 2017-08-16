package com.usabb.testrail.types;

public enum SiteType {
    ZLB_DEV("https://34.207.13.246"),
    SAP_DEV("https://hybris-dev.usabb.com"),
    SAP_STG("https://hybris-stg.usabb.com");

    private final String name;

    SiteType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    public static String getEnumByString(String code) {
        for (SiteType e : SiteType.values()) {
            if (code.equalsIgnoreCase(e.name)) return e.name();
        }
        return null;
    }
}
