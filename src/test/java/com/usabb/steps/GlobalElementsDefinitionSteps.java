package com.usabb.steps;

import com.usabb.steps.serenity.GlobalElementsUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class GlobalElementsDefinitionSteps {

    @Steps
    GlobalElementsUserSteps steps;

    @When("^click on \"([^\"]*)\" in navigation menu$")
    public void clickOnInNavigationMenu(String arg0) throws Throwable {
        steps.clickOnCategoryInNavigationMenu(arg0);
    }

    @When("^open category with pagination$")
    public void openCategoryWithPagination() throws Throwable {
        steps.openCategoryWithPagination();
    }

    @When("^open category without pagination$")
    public void openCategoryWithoutPagination() throws Throwable {
        steps.openCategoryWithOutPagination();
    }

    @Then("^header is not visible$")
    public void headerIsNotVisible() throws Throwable {
        steps.verifyThatHeaderIsNotVisible();
    }

    @Then("^the logo is shown for the customer at the header$")
    public void theLogoIsShownForTheCustomerAtTheHeader() throws Throwable {
        steps.verifyThatTheLogoIsShownForTheCustomerAtTheHeader();
    }

    @When("^click on logo$")
    public void clickOnLogo() throws Throwable {
        steps.clickOnLogoInHeader();
    }

    @Then("^home page is opened$")
    public void homePageIsOpened() throws Throwable {
        steps.verifyThatHomePageIsOpened();
    }

    @Then("^the social links is displayed in footer:$")
    public void theSocialLinksIsDisplayedInFooter(List<String> links) throws Throwable {
        steps.verifyThatTheSocialLinksIsDisplayedInFooter(links);
    }

    @When("^click on \"([^\"]*)\" in footer$")
    public void clickOnInFooter(String arg0) throws Throwable {
        steps.clickOnLinkInFooter(arg0);
    }

    @Then("^page with \"([^\"]*)\" is opened$")
    public void pageWithIsOpened(String arg0) throws Throwable {
        steps.verifyThatTheAppropriatePageIsOpened(arg0);
    }

    @Then("^the user is logged in$")
    public void theUserIsLoggedIn() throws Throwable {
        steps.verifyThatUserIsLoggedIn();
    }

    @Then("^badge \"([^\"]*)\" is shown in footer$")
    public void badgeIsShownInFooter(String arg0) throws Throwable {
        steps.verifyBadgesInFooter(arg0);
    }

    @Then("^the header should contain:$")
    public void theHeaderShouldContain(List<String> categories) throws Throwable {
        steps.verifyCategoriesInHeader(categories);
    }

    @When("^click on \"([^\"]*)\" icon in footer$")
    public void clickOnIconInFooter(String arg0) throws Throwable {
        steps.clickOnIconInFooter(arg0);
    }

    @When("^click on \"([^\"]*)\" link in header$")
    public void clickOnLinkInHeader(String arg0) throws Throwable {
        steps.clickOnLinkInHeader(arg0);
    }

    @When("click on sign out in header")
    public void clickOnLinkInHeader() throws Throwable {
        steps.clickOnSignoutInHeader();
    }

    @When("^click on \"([^\"]*)\" in My Account drop-down$")
    public void clickOnInMyAccountDropDown(String arg0) throws Throwable {
        steps.clickOnLinkInMyAccountDropDownMenu(arg0);
    }

    @Then("^copyright \"([^\"]*)\" is shown$")
    public void copyrightIsShown(String arg0) throws Throwable {
        steps.verifyThatCopyrightIsShownInFooter(arg0);
    }

    @Then("^the contract drop down is shown$")
    public void theContractDropDownIsShown() throws Throwable {
        steps.verifyThatContractDropDownIsShown();
    }

    @Then("^\"([^\"]*)\" title is shown in footer$")
    public void titleIsShownInFooter(String arg0) throws Throwable {
        steps.verifyTitleInFooter(arg0);
    }

    @Then("^contact information \"([^\"]*)\" is shown in footer$")
    public void contactInformationIsShownInFooter(String arg0) throws Throwable {
        steps.verifyContactInformationInFooter(arg0);
    }

    @Then("^the Follow Us title is shown$")
    public void theFollowUsTitleIsShown() throws Throwable {
        steps.verifyFollowUsTitle();
    }

    @Then("^breadcrumb is \"([^\"]*)\"$")
    public void breadcrumbIs(String arg0) throws Throwable {
        steps.verifyBreadcrumbPath(arg0);
    }

    @When("^click on the \"([^\"]*)\" breadcrumb$")
    public void clickOnTheBreadcrumb(String arg0) throws Throwable {
        steps.clickOnItemInBreadcrumb(arg0);
    }

    @Then("^the page \"([^\"]*)\" is shown in breadcrumb as text$")
    public void thePageIsShownInBreadcrumbAsText(String arg0) throws Throwable {
        steps.verifyThatLastBreadcrumbIsText(arg0);
    }

    @Then("^the \"([^\"]*)\" field is present$")
    public void theFieldIsPresent(String arg0) throws Throwable {
        steps.verifyPresenceOfFieldWithLabel(arg0);
    }

    @Then("^the \"([^\"]*)\" drop-down is presented$")
    public void theDropDownIsPresented(String arg0) throws Throwable {
        steps.verifyPresenceOfDropDownWithLabel(arg0);
    }

    @Then("^selected option in \"([^\"]*)\" drop-down menu is \"([^\"]*)\"$")
    public void selectedOptionInDropDownMenuIs(String arg0, String arg1) throws Throwable {
        steps.verifySelectedOptionInDropDown(arg0, arg1);
    }

    @When("^hover on \"([^\"]*)\" in navigation menu$")
    public void hoverOnInNavigationMenu(String arg0) throws Throwable {
        steps.hoverOnItemInHeader(arg0);
    }

    @Then("^the following categories are shown:$")
    public void theFollowingCategoriesAreShown(List<String> categories) throws Throwable {
        steps.verifyCategoriesOnHomePage(categories);
    }
}
