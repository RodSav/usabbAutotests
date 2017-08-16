package com.usabb.utils;

import com.usabb.testrail.TestRail;
import org.junit.Test;

public class AggregateResults {

    @Test
    public void aggregateResults() {
        TestRail testRail = new TestRail();
        testRail.sendResults();
    }
}
