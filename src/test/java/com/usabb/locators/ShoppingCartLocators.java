package com.virco.locators;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
public interface ShoppingCartLocators {

    String ALL_PRODUCTS_FOR_COUNT = "//li[@class='item__list--item']";
    String ALL_PRODUCTS_NAME = "//div[@class='item__code']/..//span";
    String ALL_PRODUCTS_DESCRIPTION = "(//span[@class='item__name'])[1]";
    String ALL_PRODUCTS_CODE = "//div[@class='item__code']";
    String ALL_PRODUCTS_PRICE = "//div[@class='item__price']";
    String ALL_QUANTITY_INPUT = "//input[@name='quantity' and contains(@id,'quantity_$1')]";
    String ALL_DELIVERY = "//span[@class='item__delivery--label']";
    String ALL_TOTAL_PRICE = "//div[@class='item__price']/following-sibling::div[1]";
    String ALL_REMOVE_BUTTON_POINT = "//div[@class='btn-group']/button";
    String ALL_REMOVE_BUTTON = "//li[contains(@id,'removeEntry')]";
    String ALL_ASSEMBLY_REQUIRED = "//div[@class='item__assemblyRequired']/div";
    String POP_UP_BUTTON = "//span[@class='ui-button-text' and text()='$1']";
    String GRAND_TOTAL_PRICE = "//div[text()='Order Total']/following-sibling::div[1]";
    String MINI_CART_TOTAL_PRICE = "//div[contains(@class,'mini-cart-price')]";
    String MINI_CART_ICON = "//div[@class='mini-cart-icon']";
    String MINI_CART_PRODUCT_LINK = "//div[@id='cboxContent']//div[@class='details']/a";
    String MINI_CART_PRODUCTS_PRICE = "//div[@id='cboxContent']//div[@class='price']";
    String MINI_CART_ITEMS = "//li[@class='mini-cart-item']";
    String PAGE_BODY_HEADER = "//h1";
    String MINI_CART_MODAL = ".//*[@id='cboxContent']";
    String ALL_COLOR = "//span[@class='item__stock']";
    String QTY_IN_MINI_CART = "//span[@class='nav-items-total']";
}
