package com.usabb.steps;

import com.usabb.steps.serenity.ContentManagementUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ContentManagementDefinitionSteps {

    @Steps
    ContentManagementUserSteps steps;

    @Then("^cmsmanager has logged in$")
    public void cmsmanagerHasLoggedIn() throws Throwable {
        steps.verifyThatCmsManagerHasLoggedIn();
    }

    @When("^logout from CMS$")
    public void logoutFromCMS() throws Throwable {
        steps.logout();
    }

    @When("^select \"([^\"]*)\" content catalog$")
    public void selectContentCatalog(String arg0) throws Throwable {
        steps.clickOnUsabbCatalog();
        steps.openContentCatalog(arg0);
    }

    @When("^double click on \"([^\"]*)\" content page$")
    public void doubleClickOnContentPage(String arg0) throws Throwable {
        steps.doubleClickOnContentPageTemplate(arg0);
    }

    @When("^click on \"([^\"]*)\" action button$")
    public void clickOnActionButton(String arg0) throws Throwable {
        steps.clickOnActionButtonByTitle(arg0);
    }

    @When("^click on \"([^\"]*)\" button in \"([^\"]*)\" slot$")
    public void clickOnButtonInSlot(String arg0, String arg1) throws Throwable {
        steps.clickOnButtonInEditSection(arg0, arg1);
    }

    @When("^enter \"([^\"]*)\" in content text area$")
    public void enterInContentTextArea(String arg0) throws Throwable {
        steps.enterValueInContentTextArea(arg0);
    }

    @Then("^the action button title is \"([^\"]*)\"$")
    public void theActionButtonTitleIs(String arg0) throws Throwable {
        steps.checkThatProductIsSynchronized(arg0);
    }

    @When("^click on \"([^\"]*)\" top link$")
    public void clickOnTopLink(String arg0) throws Throwable {
        steps.clickOnTopEditorLink(arg0);
    }

    @When("^synchronize the product$")
    public void synchronizeTheProduct() throws Throwable {
        steps.clickOnSynchButton();
    }

    @When("^click on \"([^\"]*)\" button in content catalog$")
    public void clickOnButtonInContentCatalog(String arg0) throws Throwable {
        steps.clickOnPaginationButton(arg0);
    }

    @Then("^\"([^\"]*)\" content is opened$")
    public void contentIsOpened(String arg0) throws Throwable {
        steps.checkIsContentPageOpened(arg0);
    }

    @When("^enter \"([^\"]*)\" from file in content text area$")
    public void enterFromFileInContentTextArea(String arg0) throws Throwable {
        steps.enterContentFromFile(arg0);
    }

    @When("^select \"([^\"]*)\" in remove pop-up$")
    public void selectInRemovePopUp(String arg0) throws Throwable {
        steps.selectButtonInRemovePopUp(arg0);
    }

    @When("^click on \"([^\"]*)\" button in \"([^\"]*)\" section header$")
    public void clickOnButtonInSectionHeader(String arg0, String arg1) throws Throwable {
        steps.clickOnButtonInSectionHeader(arg0, arg1);
    }

    @When("^select \"([^\"]*)\" template from modal window$")
    public void selectTemplateFromModalWindow(String arg0) throws Throwable {
        steps.selectTemplateFromModalWindow(arg0);
    }

    @When("^click on \"([^\"]*)\" button in modal$")
    public void clickOnButtonInModal(String arg0) throws Throwable {
        steps.clickOnButtonByName(arg0);
    }

    @Then("^message \"([^\"]*)\" in \"([^\"]*)\" is presented$")
    public void messageInIsPresented(String arg0, String arg1) throws Throwable {
        steps.verifyThatContentIsPresentedInSection(arg0, arg1);
    }

    @When("^search for \"([^\"]*)\" content$")
    public void searchForContent(String arg0) throws Throwable {
        steps.searchForContent(arg0);
    }

    @Then("^the rotating carousel is shown$")
    public void theRotatingCarouselIsShown() throws Throwable {
        steps.verifyThatRotatingCarouselIsShown();
    }

    @Then("^each banner has image, message and installation slots$")
    public void eachBannerHasImageMessageAndInstallationSlots() throws Throwable {
        steps.verifyRotatingCarouselComponents();
    }

    @When("^click on the \"([^\"]*)\" banner component$")
    public void clickOnTheBannerComponent(String arg0) throws Throwable {
        steps.clickOnBannerComponent(arg0);
    }

    @When("^enter \"([^\"]*)\" in content component editor$")
    public void enterInContentComponentEditor(String arg0) throws Throwable {
        steps.enterValueInContentComponentEditor(arg0);
    }

    @Then("^content in carousel is \"([^\"]*)\" in (\\d+) banner$")
    public void contentInCarouselIsInBanner(String arg0, int arg1) throws Throwable {
        steps.verifyContentInCarousel(arg0, arg1);
    }

    @Then("^the page title \"([^\"]*)\" is shown$")
    public void thePageTitleIsShown(String arg0) throws Throwable {
        steps.verifyThePageTitleOnHomePage(arg0);
    }

    @When("^click on search button in modal$")
    public void clickOnSearchButtonInModal() throws Throwable {
        steps.clickOnSearchButtonInModal();
    }

    @When("^click on \"([^\"]*)\" in modal results$")
    public void clickOnInModalResults(String arg0) throws Throwable {
        steps.clickOnValueInModalResults(arg0);
    }

    @Then("^banner component is shown$")
    public void bannerComponentIsShown() throws Throwable {
        steps.verifyThatBannerComponentIsShownOnHomePage();
    }

    @Then("^banner header is \"([^\"]*)\"$")
    public void bannerHeaderIs(String arg0) throws Throwable {
        steps.verifyBannerHeader(arg0);
    }

    @Then("^banner content is \"([^\"]*)\"$")
    public void bannerContentIs(String arg0) throws Throwable {
        steps.verifyBannerContentText(arg0);
    }
}
