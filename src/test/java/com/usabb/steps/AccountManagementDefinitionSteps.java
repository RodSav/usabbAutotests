package com.usabb.steps;

import com.usabb.steps.serenity.AccountManagementUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class AccountManagementDefinitionSteps {

    @Steps
    AccountManagementUserSteps steps;

    @When("^click on login button$")
    public void clickOnLoginButton() throws Throwable {
        steps.clickOnLoginButton();
    }

    @Then("^the user has logged in backoffice$")
    public void theUserHasLoggedInBackoffice() throws Throwable {
        steps.verifyThatBackOfficeIsOpened();
    }

    @When("^click on \"([^\"]*)\" in backoffice$")
    public void clickOnInBackoffice(String arg0) throws Throwable {
        steps.clickOnMenuInBackOffice(arg0);
    }

    @Then("^created order is presented in the list$")
    public void createdOrderIsPresentedInTheList() throws Throwable {
        steps.verifyThatCreatedOrderIsPresentedInTheList();
    }

    @Then("^the saved cart \"([^\"]*)\" with description \"([^\"]*)\" is shown on the page$")
    public void theSavedCartWithDescriptionIsShownOnThePage(String arg0, String arg1) throws Throwable {
        steps.verifyThatSavedCartIsShownOnThePage(arg0, arg1);
    }

    @Then("^delete all saved carts$")
    public void deleteAllSavedCarts() throws Throwable {
        steps.removeAllSavedCarts();
    }

    @When("^click on \"([^\"]*)\" saved cart$")
    public void clickOnSavedCart(String arg0) throws Throwable {
        steps.clickOnSavedCart(arg0);
    }

    @Then("^products on saved cart are correct$")
    public void productsOnSavedCartAreCorrect() throws Throwable {
        steps.verifyProductsOnSavedCartPage();
    }

    @When("^restore the cart$")
    public void restoreTheCart() throws Throwable {
        steps.clickOnRestoreButtonInFooter();
        steps.clickOnRestoreButtonInModal();
    }

    @Then("^My account menu has following items:$")
    public void myAccountMenuHasFollowingItems(List<String> myAccountLinks) throws Throwable {
        steps.verifyMyAccountLinks(myAccountLinks);
    }

    @Then("^the \"([^\"]*)\" my account page is opened$")
    public void theMyAccountPageIsOpened(String arg0) throws Throwable {
        steps.verifyMyAccountPages(arg0);
    }

    @When("^remove \"([^\"]*)\" saved cart$")
    public void removeSavedCart(String arg0) throws Throwable {
        steps.removeSavedCartByCartName(arg0);
    }

    @Then("^the cart \"([^\"]*)\" is not presented on saved cart page$")
    public void theCartIsNotPresentedOnSavedCartPage(String arg0) throws Throwable {
        steps.verifyThatCartIsNotPresentedOnSavedCartPage(arg0);
    }

    @When("^remove saved cart$")
    public void removeSavedCart() throws Throwable {
        steps.clickOnRestoreButtonInModal();
    }

    @Then("^the cart \"([^\"]*)\" is presented on saved cart page$")
    public void theCartIsPresentedOnSavedCartPage(String arg0) throws Throwable {
        steps.verifyThatCartIsPresentedOnSavedCartPage(arg0);
    }

    @Then("^the description of \"([^\"]*)\" cart is \"([^\"]*)\"$")
    public void theDescriptionOfCartIs(String arg0, String arg1) throws Throwable {
        steps.verifyCartDescription(arg0, arg1);
    }

    @When("^save edited cart$")
    public void saveEditedCart() throws Throwable {
        steps.clickOnSaveButtonInEditCartModal();
    }

    @Then("^the service level drop-down is presented$")
    public void theServiceLevelDropDownIsPresented() throws Throwable {
        steps.verifyThatTheServiceLevelDropDownIsShownInHeader();
    }

    @Then("^the service level drop-down contains following options:$")
    public void theServiceLevelDropDownContainsFollowingOptions(List<String> options) throws Throwable {
        steps.verifyThatServiceLevelContainsOptions(options);
    }

    @Then("^the \"([^\"]*)\" option is selected value in service level drop-down$")
    public void theOptionIsSelectedValueInServiceLevelDropDown(String arg0) throws Throwable {
        steps.verifyThatTheOptionIsSelectedValueInServiceLevelDropDown(arg0);
    }

    @When("^select \"([^\"]*)\" in service level drop-down$")
    public void selectInServiceLevelDropDown(String arg0) throws Throwable {
        steps.selectOptionInServiceLevelDropDown(arg0);
    }

    @When("^click on \"([^\"]*)\" link in backoffice$")
    public void clickOnLinkInBackoffice(String arg0) throws Throwable {
        steps.clickOnLinkWithTitle(arg0);
    }
}
