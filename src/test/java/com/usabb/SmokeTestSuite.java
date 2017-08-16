package com.virco;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/smoke_test"
},
        tags = {
                "@Smoke"}
)
public class SmokeTestSuite {
}