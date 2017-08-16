package com.usabb.steps.serenity;

import com.usabb.pages.CheckoutPage;
import com.usabb.utils.SoftAssert;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class CheckoutUserSteps extends ScenarioSteps {

    CheckoutPage checkoutPage;

    @Step
    public void checkCheckBoxWithLabelName(String arg0) {
        checkoutPage.clickOnInputOfCheckBoxWithLabel(arg0);
    }

    @Step
    public void selectValueInDropDownByLabelName(String arg0, String arg1) {
        checkoutPage.selectValueFromDropDownByLabelName(arg0, arg1);
    }

    @Step
    public void checkTermsAndConditions() {
        checkoutPage.acceptTermsAndConditions();
    }

    @Step
    public void checkThatOrderIsCreated() {
        SoftAssert.assertTrue("The message Thank you for your Order! is not shown",
                checkoutPage.compareOrderConfirmationMessage("Thank you for your Order!"));
        Serenity.getCurrentSession().put("CreatedOrderNumber", checkoutPage.getOrderNumber());
        SoftAssert.assertAll();
    }

    @Step
    public void verifyProductsCountOnCheckOutPage(String arg0) {
        Assert.assertTrue("Wrong quantity on checkout page, Expected: " + arg0 + " but Found " + checkoutPage.getQtyOfProducts(), arg0.equalsIgnoreCase(checkoutPage.getQtyOfProducts()));
    }
}
