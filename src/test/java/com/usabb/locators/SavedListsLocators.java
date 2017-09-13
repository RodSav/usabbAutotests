package com.usabb.locators;

public interface SavedListsLocators {

    String ALL_PRODUCTS_NAME = ".//div[@class='item__info']/a";
    String ALL_PRODUCTS_DESCRIPTION = "(//span[@class='item__name'])[1]";
    String ALL_PRODUCTS_CODE = "//div[@class='item__code']";
    String ALL_PRODUCTS_PRICE = "//div[@class='item__price']";
    String ALL_TOTAL_PRICE = "//div[@class='item__price']/following-sibling::div[2]";
    String ALL_QUANTITY_INPUT = "//input[@name='quantity']";
    String ALL_PRODUCTS_FOR_COUNT = "//li[@class='item__list--item']";
    String BUTTON_IN_MODAL_WITH_NAME = "(//button[contains(text(),'$1')])";
    String FIELD_BY_LABEL = "(//label[contains(text(),'$1')]/following-sibling::input)[2]";

}
