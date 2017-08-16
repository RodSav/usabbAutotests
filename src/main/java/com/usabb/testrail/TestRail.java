package com.virco.testrail;

import com.gurock.testrail.APIClient;
import com.virco.testrail.types.SiteType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * Created by ${Timonov_Viacheslav} on 6/20/17.
 */
public class TestRail extends TestRailIntegration {

    private static final Logger logger = LoggerFactory.getLogger(TestRail.class);
    TestRailSetUp setUp;

    @Override
    public APIClient client() {
        String url, user, apiKey;
        url = getProperties().getProperty("test.rail.url");
        user = getProperties().getProperty("username");
        apiKey = getProperties().getProperty("api.key");
        APIClient client = new APIClient(url);
        client.setUser(user);
        client.setPassword(apiKey);
        return client;
    }

    private Properties getProperties() {
        try {
            return setUp.getProperties();
        } catch (IOException e) {
            logger.error("Error read properties {}", (Object[]) e.getStackTrace());
        }
        return new Properties();
    }


    public void sendResults() {
        setUp = new TestRailSetUp();
        logger.info("Set properties.");
        int projectId = Integer.parseInt(getProperties().getProperty("project.id"));
        int suiteId = 1;
        if (getExecutionTag() != null && getExecutionTag().equalsIgnoreCase("@Smoke")) {
            suiteId = Integer.parseInt(getProperties().getProperty("test.run.smoke.id"));
        }
        String siteURL = System.getProperty("webdriver.base.url");
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateAsISOString = df.format(date);
        logger.info("Site url " + siteURL);
        logger.info(SiteType.getEnumByString(siteURL));
        String enumValue = SiteType.getEnumByString(siteURL);
        String runName = "[" + enumValue + "] " + (suiteId == 1 ? "Automated Regression testing" : "Automated Smoke check list ") + dateAsISOString;
        int assignedToId = Integer.parseInt(getProperties().getProperty("assigned.to.id"));
        boolean includeAll = true;
        int runId = Integer.valueOf(addRun(projectId, suiteId, runName, siteURL + "/vircostorefront", assignedToId, includeAll));
        logger.info("Run is created #" + runId);
        sendResults(runId, assignedToId);
        logger.info("Results are sent");
        closeTestRun(runId);
    }

    private String getExecutionTag() {
        String tags = System.getProperty("cucumber.options");
        return tags.substring(tags.indexOf('@'), tags.length());
    }

}
