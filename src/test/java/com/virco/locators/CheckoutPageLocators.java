package com.virco.locators;

/**
 * Created by ${Timonov_Viacheslav} on 5/12/17.
 */
public interface CheckoutPageLocators {
    String CHECK_BOX_WITH_LABEL = "//label[contains(text(),'$1')]/preceding-sibling::input";
    String DROPDOWN_INPUT_BY_LABEL = "//label[contains(text(),'$1') and not(@for='StartYear')]/following-sibling::div//select";
    String TERMS_AND_CONDITIONS_CHECKBOX = "//input[@name='termsCheck']";
    String CONFIRMATION_MESSAGE = "//div[@class='checkout-success__body']/div";
    String ORDER_NUMBER = "//span[text()='Order Number']/following-sibling::span";
    String QTY_OF_ITEMS_IN_THE_CART = "//div[contains(@class,'cart__top--totals')]";
    String NEW_DROP_DOWN_BY_LABEL = "//label[contains(text(),'$1')]/following-sibling::div";
    String NEW_DROP_DOWN_BY_LABEL_ITEMS = "//label[contains(text(),'$1')]/following-sibling::div//option[contains(text(),'$2')]";
}
