package com.virco.utils;

import com.virco.testrail.TestRail;
import org.junit.Test;

/**
 * Created by ${Timonov_Viacheslav} on 6/20/17.
 */
public class AggregateResults {

    @Test
    public void aggregateResults() {
        TestRail testRail = new TestRail();
        testRail.sendResults();
    }
}
