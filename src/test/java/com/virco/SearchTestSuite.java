package com.virco;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/search/SRC1_FreeTextSearch.feature"
})
public class SearchTestSuite {
}
