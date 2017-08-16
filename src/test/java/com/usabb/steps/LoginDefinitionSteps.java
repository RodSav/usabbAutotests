package com.virco.steps;

import com.virco.steps.serenity.LoginUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
public class LoginDefinitionSteps {

    @Steps
    LoginUserSteps steps;

    @When("^click on create button in backoffice$")
    public void clickOnCreateButtonInBackoffice() throws Throwable {
        steps.clickOnCreateButton();
    }

    @When("^enter \"([^\"]*)\" in \"([^\"]*)\" field in backoffice$")
    public void enterInFieldInBackoffice(String arg0, String arg1) throws Throwable {
        steps.enterValueInFieldInBackoffice(arg0, arg1);
    }

    @Then("^the \"([^\"]*)\" is presented in the table backoffice$")
    public void theIsPresentedInTheTableBackoffice(String arg0) throws Throwable {
        steps.verifyPresenceOfValueInTheTableForFirstColumn(arg0);
    }

    @When("^select \"([^\"]*)\" in \"([^\"]*)\" dropdown in backoffice$")
    public void selectInDropdownInBackoffice(String arg0, String arg1) throws Throwable {
        steps.selectValueInBackOffice(arg0, arg1);
    }

    @Then("^the reset password modal is shown$")
    public void theResetPasswordModalIsShown() throws Throwable {
        steps.verifyThatTheResetPasswordModalIsShown();
    }

    @Then("^the reset password email is sent$")
    public void theResetPasswordEmailIsSent() throws Throwable {
        steps.verifyEmailOfResetPassword();
    }

    @When("^open the reset link in email$")
    public void openTheResetLinkInEmail() throws Throwable {
        steps.openResetLinkInEmail();
    }
}
