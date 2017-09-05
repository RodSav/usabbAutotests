package com.usabb.testrail;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import com.usabb.testrail.types.StatusType;
import com.usabb.testrail.models.Result;
import com.usabb.testrail.serenity.ProcessResults;
import com.usabb.testrail.serenity.ReadResults;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TestRailIntegration {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestRailIntegration.class);

    /**
     * An instance of the api client is required
     *
     * @return
     */
    public abstract APIClient client();

    /**
     * Create new test run
     *
     * @param projectId      The ID of the project the test run should be added to
     * @param suiteId        The ID of the test suite for the test run (optional if the project is operating in single suite mode, required otherwise)
     * @param runName        The name of the test run
     * @param runDescription The description of the test run
     * @param assignedToId   The ID of the user the test run should be assigned to
     * @param includeAll     True for including all test cases of the test suite and false for a custom case selection (default: true)
     * @return test run id
     */
    public String addRun(int projectId, int suiteId, String runName, String runDescription, int assignedToId, boolean includeAll, ArrayList<Integer> caseIds) {
        Map data = new HashMap();
        // int milestone = 0;
        data.put("suite_id", suiteId);
        data.put("name", runName);
        data.put("description", runDescription);
        // data.put("milestone_id", milestone);
        data.put("assignedto_id", assignedToId);
        data.put("include_all", includeAll);
        data.put("case_ids", caseIds);
        JSONObject postResponse = null;
        try {
            postResponse = (JSONObject) client().sendPost("add_run/" + projectId, data);
        } catch (IOException | APIException e) {
            LOGGER.error("Cannot send post request for run create {}", (Object[]) e.getStackTrace());
        }
        return postResponse.get("id").toString();
    }

    /**
     * Update test run
     *
     * @param runId          The ID of the test run to update
     * @param runName        The name of the test run
     * @param runDescription The description of the test run
     * @param assignedToId   The ID of the user the test run should be assigned to
     * @param includeAll     True for including all test cases of the test suite and false for a custom case selection (default: true)
     * @return test run id
     */
    public String updateRun(int runId, String runName, String runDescription, int assignedToId, boolean includeAll) {
        Map data = new HashMap();
        // ArrayList<Integer> caseIds = new ArrayList<>();
        // int milestone = 0;
        // data.put("suite_id", suiteId);
        data.put("name", runName);
        data.put("description", runDescription);
        // data.put("milestone_id", milestone);
        data.put("assignedto_id", assignedToId);
        data.put("include_all", includeAll);
        //  data.put("case_ids", caseIds);
        JSONObject postResponse = null;
        try {
            postResponse = (JSONObject) client().sendPost("update_run/" + runId, data);
        } catch (IOException | APIException e) {
            LOGGER.error("Cannot send post request for run update {}", (Object[]) e.getStackTrace());
        }
        return postResponse.get("id").toString();
    }

    /**
     * Send results to test rail
     *
     * @param runId test run id to send results
     */
    public void sendResults(int runId, int assignedTo) {
        List<Result> results = getResults();
        for (Result r : results) {
            for (String testCaseId : getTestCaseId(r)) {
                int statusCode = StatusType.valueOf(r.getResult()).getNumVal();
                String commentText = "PASSED";
                if (statusCode != 1) {
                    commentText = "Error step: " + r.getFailedStep() + "\n\n" + r.getTestFailureSummary();
                }
                Map data = new HashMap();
                data.put("status_id", statusCode);
                data.put("assignedto_id", assignedTo);
                data.put("comment", commentText);
                try {
                    JSONObject response = (JSONObject) client().sendPost("add_result_for_case/" + runId + "/" + testCaseId, data);
                    LOGGER.info("Update TC# " + testCaseId + " " + response);
                } catch (IOException | APIException e) {
                    LOGGER.error("Cannot update TC# " + testCaseId + " {}", (Object[]) e.getStackTrace());
                }
            }
        }
    }

    /**
     * Get ids of executed tests
     *
     * @return
     */

    public ArrayList<Integer> getExecutedTestRailIds() {
        ArrayList<Integer> tags = new ArrayList<>();
        List<Result> results = getResults();
        for (Result result : results) {
            if (getRailId(result) != null) tags.add(getRailId(result));

        }
        return tags;
    }

    private Integer getRailId(Result result) {
        Integer id = null;
        for (String tag : result.getTags()) {
            if (tag.contains("Rail")) {
                id = Integer.valueOf(tag.substring(tag.lastIndexOf('_') + 1));
            }
        }
        return id;
    }

    /**
     * Get test case id from tags
     *
     * @param result
     * @return test case id
     */
    private List<String> getTestCaseId(Result result) {
        List<String> tcId = new ArrayList<>();
        for (String s : result.getTags()) {
            if (s.contains("Rail")) tcId.add(s.substring(s.indexOf('_') + 1, s.length()));
        }
        return tcId;
    }


    /**
     * Get results from target serenity folder 'target/site/serenity'
     *
     * @return
     */
    public List<Result> getResults() {
        String folderPath = "target/site/serenity";
        ReadResults readResults = new ReadResults();
        ProcessResults processResults = new ProcessResults();
        List<String> patches = readResults.getJSONFilesResults(folderPath);
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < patches.size(); ++i) {
            String json = readResults.getJSONContent(patches.get(i));
            if (processResults.getResult(json) != null) {
                results.add(processResults.getResult(json));
            }
        }
        return results;
    }

    public boolean closeTestRun(int runId) {
        Map data = new HashMap();
        try {
            JSONObject r = (JSONObject) client().sendPost("close_run/" + runId, data);
            LOGGER.info("Test run ID# " + runId + " is closed.");
            return true;
        } catch (IOException | APIException e) {
            LOGGER.error("Cannot close run # " + runId + " {}", (Object[]) e.getStackTrace());
        }
        return false;
    }


    /**
     * for future
     *
     * @throws IOException
     * @throws APIException
     */
    public void getTestRuns() throws IOException, APIException {
        JSONObject c = (JSONObject) client().sendGet("get_runs/1");
    }

    /**
     * for future
     *
     * @param runId
     * @throws IOException
     * @throws APIException
     */
    public void getTestRun(String runId) throws IOException, APIException {
        JSONObject c = (JSONObject) client().sendGet("get_run/" + runId);
    }

    public boolean isResultsArePresented() {
        return getResults().size() == 0;
    }
}
