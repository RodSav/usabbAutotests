package com.usabb.testrail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    private List<String> tags;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("manual")
    private boolean manual;
    @JsonProperty("result")
    private String result;
    @JsonProperty("testFailureClassname")
    private String testFailureClassname;
    @JsonProperty("testFailureMessage")
    private String testFailureMessage;
    @JsonProperty("testFailureSummary")
    private String testFailureSummary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTestFailureClassname() {
        return testFailureClassname;
    }

    public void setTestFailureClassname(String testFailureClassname) {
        this.testFailureClassname = testFailureClassname;
    }

    public String getTestFailureMessage() {
        return testFailureMessage;
    }

    public void setTestFailureMessage(String testFailureMessage) {
        this.testFailureMessage = testFailureMessage;
    }

    public String getTestFailureSummary() {
        return testFailureSummary;
    }

    public void setTestFailureSummary(String testFailureSummary) {
        this.testFailureSummary = testFailureSummary;
    }
}
