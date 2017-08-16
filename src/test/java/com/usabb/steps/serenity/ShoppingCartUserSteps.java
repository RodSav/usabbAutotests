package com.virco.steps.serenity;

import com.virco.pages.GlobalElements;
import com.virco.pages.ShoppingCartPage;
import com.virco.utils.SoftAssert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
public class ShoppingCartUserSteps extends ScenarioSteps {

    ShoppingCartPage shoppingCartPage;
    GlobalElements globalElements;

    @Step
    public void rememberInformationOffAllProductsOnCartPage() {
        shoppingCartPage.rememberInformationOffAllProductsOnCartPage();
    }

    @Step
    public void verifyProductsOnCheckOutPage() {
        ArrayList<String> results = shoppingCartPage.verifyProductsOnCartPage();
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void verifyThatProductLinkIsShownOnCartPage() {
        Assert.assertTrue("The product link is not shown on Cart page",
                shoppingCartPage.checkThatAddedProductIsPresentedInTheCart());
    }

    @Step
    public void clickOnAddedProductOnCartPage() {
        shoppingCartPage.clickOnAddedProductOnCartPage();
    }

    @Step
    public void verifyThatAddedProduct() {
        Assert.assertTrue("Incorrect page is opened for added product", shoppingCartPage.verifyThatAppropriatePageIsOpenedWithAddedProduct());
    }

    @Step
    public void verifyThatDeleteButtonIsShownPerEachRecord() {
        Assert.assertTrue("The remove button is not show per each record", shoppingCartPage.verifyThatRemoveButtonIsShownPerEachRecord());
    }

    @Step
    public void removeRecordFromTheCart(int arg0) {
        shoppingCartPage.removeRecordFromTheCart(arg0);
    }

    @Step
    public void verifyThatProductIsDeletedFromTheCart() {
        Assert.assertTrue("The product is not deleted from the cart", shoppingCartPage.verifyThatProductIsDeletedFromTheCart());
    }

    @Step
    public void verifyThatTotalIsRecalculated() {
        Assert.assertTrue("The total is not recalculated",
                shoppingCartPage.verifyThatTotalIsRecalculated(Double.valueOf(shoppingCartPage.getTotalPrice())));
    }

    @Step
    public void verifyThatRecalculatedTotalIsShownAtTheMiniCart() {
        Assert.assertTrue("The total in cart is not recalculated",
                shoppingCartPage.verifyThatTotalIsRecalculated(Double.valueOf(shoppingCartPage.getTotalPriceInMiniCart())));
    }

    @Step
    public void hoverMouseOnMiniCart() {
        shoppingCartPage.hoverMouseOnMiniCart();
    }

    @Step
    public void verifyItemsInTheMiniCart(int arg0) {
        List<String> results = shoppingCartPage.verifyTheItemsInTheMiniCart(arg0);
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void verifyThatCartPageIsOpened() {
        String pageName = "Cart";
        String pageTitle = "Your Shopping Cart";
        SoftAssert.assertTrue("Wrong page title. Expected: " + pageTitle + ", but found: " + globalElements.getPageTitle(), globalElements.getPageTitle().contains(pageTitle));
        SoftAssert.assertTrue("Wrong last breadcrumb. Expected: " + pageName + ", but found: " + globalElements.getLastBreadcrumb(), pageName.equals(globalElements.getLastBreadcrumb()));
        SoftAssert.assertTrue("Wrong page " + pageName + " body name", shoppingCartPage.getPageBodyHeader().contains(pageName));
        SoftAssert.assertAll();
    }

    @Step
    public void verifyThatMiniCartIsNotShown() {
        Assert.assertFalse("The mini cart is shown", shoppingCartPage.getVisibilityOfMiniCart());
    }

    @Step
    public void verifyInformationOnCartPage() {
        SoftAssert.assertTrue("Missing delete button", shoppingCartPage.getDeleteButtonPresenceStatus());
        SoftAssert.assertTrue("Missing Material Description", shoppingCartPage.getMaterialDescriptionPresenceStatus());
        SoftAssert.assertTrue("Missing SKU", shoppingCartPage.getSkuPresenceStatus());
        SoftAssert.assertTrue("Missing product description", shoppingCartPage.getDescriptionPresenceStatus());
        SoftAssert.assertTrue("Missing assembly required", shoppingCartPage.getAssemblyRequiredPresenceStatus());
        SoftAssert.assertTrue("Missing color", shoppingCartPage.getColorPresenceStatus());
        SoftAssert.assertTrue("Missing delivery", shoppingCartPage.getDeliveryPresenceStatus());
        SoftAssert.assertTrue("Missing price", shoppingCartPage.getPricePresenceStatus());
        SoftAssert.assertTrue("Missing total price", shoppingCartPage.getTotalPricePresenceStatus());
        SoftAssert.assertAll();
    }

    @Step
    public void verifyProductDataOnCartPAge() {
        List<String> results = shoppingCartPage.verifyProductData();
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void verifyTheQuantityInTheMiniCart(String arg0) {
        Assert.assertTrue("Wrong quantity in the mini cart, Expected: " + arg0 + " but Found " + shoppingCartPage.getQuantityInTheMiniCart(), arg0.equalsIgnoreCase(shoppingCartPage.getQuantityInTheMiniCart()));
    }
}
