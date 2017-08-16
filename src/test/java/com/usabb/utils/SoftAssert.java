package com.usabb.utils;

import org.junit.Assert;

import java.util.ArrayList;

/**
 * Created by ${Timonov_Viacheslav} on 2/3/17.
 */
public class SoftAssert extends Assert {

    private static ArrayList<AssertionError> m_errors = new ArrayList<>();

    public static void assertTrue(String message, boolean condition) {
        try {
            Assert.assertTrue(message, condition);
        } catch (AssertionError ex) {
            m_errors.add(ex);
        }
    }

    public static void assertTrue(boolean condition) {
        try {
            Assert.assertTrue((String) null, condition);
        } catch (AssertionError ex) {
            m_errors.add(ex);
        }
    }

    public static void assertFalse(String message, boolean condition) {
        try {
            Assert.assertFalse(message, condition);
        } catch (AssertionError ex) {
            m_errors.add(ex);
        }
    }

    public static void assertFalse(boolean condition) {
        try {
            Assert.assertFalse((String) null, condition);
        } catch (AssertionError ex) {
            m_errors.add(ex);
        }
    }

    public static void assertAll() {
        if (m_errors.size() != 0) {
            StringBuilder sb = new StringBuilder("The following asserts failed:\n");
            boolean first = true;
            for (AssertionError ae : m_errors) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", \n");
                }
                sb.append(ae.getMessage());
            }
            m_errors.clear();
            throw new AssertionError(sb.toString());
        }
    }

    public static void clearOldResults(){
        m_errors.clear();
    }

}
