package com.usabb.pages;

import com.usabb.locators.CheckoutPageLocators;
import com.usabb.utils.PageObject;;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ${Timonov_Viacheslav} on 5/12/17.
 */
public class CheckoutPage extends PageObject {

    public void clickOnInputOfCheckBoxWithLabel(String arg0) {
        WebElement radioButton = $(CheckoutPageLocators.CHECK_BOX_WITH_LABEL.replace("$1", arg0));
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();
    }

    public void selectValueFromDropDownByLabelName(String arg0, String arg1) {
        $(CheckoutPageLocators.NEW_DROP_DOWN_BY_LABEL.replace("$1", arg1)).click();
        WebElement dropDownItem = $(CheckoutPageLocators.NEW_DROP_DOWN_BY_LABEL_ITEMS.replace("$1", arg1).replace("$2", arg0));
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(CheckoutPageLocators.NEW_DROP_DOWN_BY_LABEL_ITEMS.replace("$1", arg1).replace("$2", arg0)))).$(dropDownItem).click();
    }

    public void acceptTermsAndConditions() {
        $(CheckoutPageLocators.TERMS_AND_CONDITIONS_CHECKBOX).click();
    }

    public boolean compareOrderConfirmationMessage(String s) {
        return s.equalsIgnoreCase($(CheckoutPageLocators.CONFIRMATION_MESSAGE).getText());
    }

    public Object getOrderNumber() {
        return $(CheckoutPageLocators.ORDER_NUMBER).getText();
    }

    public String getQtyOfProducts() {
        String qtyOfItems = $(CheckoutPageLocators.QTY_OF_ITEMS_IN_THE_CART).getText();
        return qtyOfItems.substring(0, qtyOfItems.indexOf(' '));
    }
}
