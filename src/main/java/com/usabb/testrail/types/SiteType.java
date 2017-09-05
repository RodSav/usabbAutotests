package com.usabb.testrail.types;

public enum SiteType {
    ZLB_DEV("https://usabb-dev.zaelab.com");

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
