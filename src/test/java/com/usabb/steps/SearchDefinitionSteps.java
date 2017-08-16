package com.usabb.steps;

import com.usabb.steps.serenity.SearchUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchDefinitionSteps {
    @Steps
    SearchUserSteps steps;

    @When("^search for \"([^\"]*)\"$")
    public void searchFor(String arg0) throws Throwable {
        steps.searchForProductUsingSearchBar(arg0);
    }

    @Then("^the \"([^\"]*)\" product has name \"([^\"]*)\"$")
    public void theProductHasName(String arg0, String arg1) throws Throwable {
        steps.checkTheNameOfTheProductByPosition(arg0, arg1);
    }

    @Then("^the search is not empty$")
    public void theSearchIsNotEmpty() throws Throwable {
        steps.verifyThatTheSearchResultIsNotEmpty();
    }
}
