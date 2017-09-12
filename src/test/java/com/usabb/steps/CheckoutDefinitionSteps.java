package com.usabb.steps;

import com.usabb.steps.serenity.CheckoutUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CheckoutDefinitionSteps {

    @Steps
    CheckoutUserSteps steps;

    @When("^select \"([^\"]*)\" radio button$")
    public void selectRadioButton(String arg0) throws Throwable {
        steps.checkCheckBoxWithLabelName(arg0);
    }

    @When("^select \"([^\"]*)\" in \"([^\"]*)\" drop-down$")
    public void selectInDropDown(String arg0, String arg1) throws Throwable {
        steps.selectValueInDropDownByLabelName(arg0, arg1);
    }

    @When("^accept T&C on checkout$")
    public void acceptTCOnCheckout() throws Throwable {
        steps.checkTermsAndConditions();
    }

    @Then("^the order is created$")
    public void theOrderIsCreated() throws Throwable {
        steps.checkThatOrderIsCreated();
    }

    @Then("^the quantity on checkout page is \"([^\"]*)\"$")
    public void theQuantityOnCheckoutPageIs(String arg0) throws Throwable {
        steps.verifyProductsCountOnCheckOutPage(arg0);
    }
}
