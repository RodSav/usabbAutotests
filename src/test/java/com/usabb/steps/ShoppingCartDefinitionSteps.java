package com.virco.steps;

import com.virco.steps.serenity.ShoppingCartUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
public class ShoppingCartDefinitionSteps {

    @Steps
    ShoppingCartUserSteps steps;

    @When("^remember products information on checkout page$")
    public void rememberProductsInformationOnCheckoutPage() throws Throwable {
        steps.rememberInformationOffAllProductsOnCartPage();
    }

    @Then("^products on checkout page are correct$")
    public void productsOnCheckoutPageAreCorrect() throws Throwable {
        steps.verifyProductsOnCheckOutPage();
    }

    @Then("^the link of product is shown on Cart page$")
    public void theLinkOfProductIsShownOnCartPage() throws Throwable {
        steps.verifyThatProductLinkIsShownOnCartPage();
    }

    @When("^click on added product on Cart page$")
    public void clickOnAddedProductOnCartPage() throws Throwable {
        steps.clickOnAddedProductOnCartPage();
    }

    @Then("^added product page is shown$")
    public void addedProductPageIsShown() throws Throwable {
        steps.verifyThatAddedProduct();
    }

    @Then("^delete button is shown per each record$")
    public void deleteButtonIsShownPerEachRecord() throws Throwable {
        steps.verifyThatDeleteButtonIsShownPerEachRecord();
    }

    @When("^remove \"([^\"]*)\" product from cart$")
    public void removeProductFromCart(int arg0) throws Throwable {
        steps.removeRecordFromTheCart(arg0);
    }

    @Then("^deleted record is removed from the cart$")
    public void deletedRecordIsRemovedFromTheCart() throws Throwable {
        steps.verifyThatProductIsDeletedFromTheCart();
    }

    @Then("^total is recalculated appropriately$")
    public void totalIsRecalculatedAppropriately() throws Throwable {
        steps.verifyThatTotalIsRecalculated();
    }

    @Then("^the recalculated total is shown at the mini cart$")
    public void theRecalculatedTotalIsShownAtTheMiniCart() throws Throwable {
        steps.verifyThatRecalculatedTotalIsShownAtTheMiniCart();
    }

    @When("^hover on mini cart$")
    public void hoverOnMiniCart() throws Throwable {
        steps.hoverMouseOnMiniCart();
    }

    @Then("^the last (\\d+) items are shown in mini cart$")
    public void theLastItemsAreShownInMiniCart(int arg0) throws Throwable {
        steps.verifyItemsInTheMiniCart(arg0);
    }

    @Then("^the Cart page is opened$")
    public void theCartPageIsOpened() throws Throwable {
        steps.verifyThatCartPageIsOpened();
    }

    @Then("^the mini cart is not shown$")
    public void theMiniCartIsNotShown() throws Throwable {
        steps.verifyThatMiniCartIsNotShown();
    }

    @Then("^cart page contains following information$")
    public void cartPageContainsFollowingInformation() throws Throwable {
        steps.verifyInformationOnCartPage();
    }

    @Then("^product data on checkout page is correct$")
    public void productDataOnCheckoutPageIsCorrect() throws Throwable {
        steps.verifyProductDataOnCartPAge();
    }

    @Then("^the quantity in the mini cart is \"([^\"]*)\"$")
    public void theQuantityInTheMiniCartIs(String arg0) throws Throwable {
        steps.verifyTheQuantityInTheMiniCart(arg0);
    }
}
