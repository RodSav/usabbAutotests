package com.usabb.utils;

import com.usabb.testrail.TestRail;
import org.junit.Assert;
import org.junit.Test;

public class AggregateResults {

    @Test
    public void aggregateResults() throws Exception {
        TestRail testRail = new TestRail();
        Assert.assertFalse("The tests results are empty in /target/site/serenity", testRail.isResultsPresented());
        if (testRail.getExecutedTestRailIds().size() != 0) {
            testRail.sendResults();
        }
    }
}
