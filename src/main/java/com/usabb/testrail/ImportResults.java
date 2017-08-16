package com.virco.testrail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virco.testrail.models.Result;

import java.util.List;

/**
 * Created by ${Timonov_Viacheslav} on 6/19/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportResults {
    private Result result;
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
