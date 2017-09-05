package com.usabb.testrail.types;

public enum StatusType {
    SUCCESS(1), ERROR(4), UNTESTED(3), RETEST(2), FAILURE(5);

    private int numVal;

    StatusType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
