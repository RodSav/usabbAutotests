package com.usabb.testrail.serenity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usabb.testrail.models.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class ProcessResults {

    private static final Logger logger = LoggerFactory.getLogger(ProcessResults.class);

    public Result getResult(String resultJSON) {
        return deserializeBaseProduct(resultJSON);
    }

    private Result deserializeBaseProduct(String json) {
        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = null;
        Result result = new Result();
        try {
            node = objectMapper.readTree(json);
        } catch (IOException e) {
            logger.error("Error in reading JSON String. Returning empty result {}", (Object[]) e.getStackTrace());
            return result;
        }
        result.setName(node.get("name").asText());
        result.setId(node.get("id").asText());
        result.setDriver(node.get("driver").asText());
        result.setResult(node.get("result").asText());
        result.setManual(node.get("manual").asBoolean());
        if (result.getResult().equals("FAILURE") || result.getResult().equals("ERROR")) {
            result.setTestFailureClassname(node.get("testFailureClassname").asText());
            result.setTestFailureMessage(node.get("testFailureMessage").asText());
            result.setTestFailureSummary(node.get("testFailureSummary").asText());
        }
        Iterator<JsonNode> tagsIterator = node.get("tags").iterator();
        List<String> tags = new ArrayList<>();
        while (tagsIterator.hasNext()) {
            String tag = tagsIterator.next().get("name").toString();
            tags.add(tag.replaceAll("\"", ""));
        }
        result.setTags(tags);
        return result;
    }
}
