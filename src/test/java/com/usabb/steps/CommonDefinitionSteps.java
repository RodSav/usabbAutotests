package com.usabb.steps;

import com.usabb.locators.SiteData;
import com.usabb.steps.serenity.CommonUserSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonDefinitionSteps {

    @Steps
    CommonUserSteps steps;

    @Given("^open the site$")
    public void openTheSite() throws Throwable {
        steps.openTheSite();
    }

    @Given("^open \"([^\"]*)\" page$")
    public void openPage(String arg0) throws Throwable {
        steps.openManagementPage(arg0);
    }

    @When("^login as \"([^\"]*)\"$")
    public void loginAs(String arg0) throws Throwable {
        steps.loginAsSpecialUser(arg0);
    }

    @Then("^login page is opened$")
    public void loginPageIsOpened() throws Throwable {
        steps.verifyThatLoginPageIsOpened();
    }

    @When("^click on \"([^\"]*)\" button$")
    public void clickOnButton(String arg0) throws Throwable {
        steps.clickOnButtonWithName(arg0);
    }

    @When("^enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    public void enterInTheField(String arg0, String arg1) throws Throwable {
        steps.enterTheValueInTheFieldWithLabel(arg0, arg1);
    }

    @Then("^the content is \"([^\"]*)\"$")
    public void theContentIs(String arg0) throws Throwable {
        steps.checkContentOnThePage(arg0);
    }

    @When("^open \"([^\"]*)\" storefront page$")
    public void openStorefrontPage(String arg0) throws Throwable {
        steps.openPageAddress(arg0);
    }

    @Then("^alert with text \"([^\"]*)\" is shown$")
    public void alertWithTextIsShown(String arg0) throws Throwable {
        steps.verifyTextInAlert(arg0);
    }

    @When("^enter \"([^\"]*)\" in the \"([^\"]*)\" textarea$")
    public void enterInTheTextarea(String arg0, String arg1) throws Throwable {
        steps.enterTextInTextareaByLabel(arg0, arg1);
    }

    @When("^click on \"([^\"]*)\" modal button$")
    public void clickOnModalButton(String arg0) throws Throwable {
        steps.clickOnButtonInModal(arg0);
    }

    @Given("^open the site and login$")
    public void openTheSiteAndLogin() throws Throwable {
        steps.openTheSite();
        steps.enterTheValueInTheFieldWithLabel(SiteData.SHOPPER_NAME, "Email Address");
        steps.enterTheValueInTheFieldWithLabel(SiteData.SHOPPER_PASSWORD, "Password");
        steps.clickOnLoginButton();
    }

    @When("^open any category$")
    public void openAnyCategory() throws Throwable {
        steps.openAnyCategoryPage();
    }

    @Then("^remember page url$")
    public void rememberPageUrl() throws Throwable {
        steps.rememberPageUrl();
    }

    @When("^open saved url$")
    public void openSavedUrl() throws Throwable {
        steps.openSavedUrl();
    }

    @When("^enter \"([^\"]*)\" in the \"([^\"]*)\" field in modal$")
    public void enterInTheFieldInModal(String arg0, String arg1) throws Throwable {
        steps.enterTextInTextareaByLabelInModal(arg0, arg1);
    }

    @When("^switch to new tab$")
    public void switchToNewTab() throws Throwable {
        steps.switchToTheNewTab();
    }

    @Then("^validation message \"([^\"]*)\" is shown for \"([^\"]*)\" field$")
    public void validationMessageIsShownForField(String arg0, String arg1) throws Throwable {
        steps.verifyValidationMessageForField(arg0, arg1);
    }

    @When("^click on \"([^\"]*)\" modal action button$")
    public void clickOnModalActionButton(String arg0) throws Throwable {
        steps.clickOnButtonInModalAction(arg0);
    }
}
