package com.usabb.locators;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public interface ProductDetailsPageLocators {
    String PRODUCT_MAIN_IMAGE = "(//div[@class='item']//img)[1]";
    String PRODUCT_IMAGE_ZOOMED = "//*[@id='zoomed-image-perspective']//img";
    String ZOOMED_IMAGE_MODAL_WINDOW = "//div[@id='zoomed-image-perspective']";
    String ZOOMED_MODAL_CLOSE_BUTTON = "//div[@class='zoomed-image-close']";
    String CART_HEADER_SIGN = "//div[@id='cboxContent']//div[@class='headline']/span";
    String CART_BUTTONS = "//*[contains(@class,'btn') and contains(text(),'$1')]";
    String CART_CLOSE_BUTTON = ".//*[@id='cboxClose']";
    String PRODUCT_NAME = "//div[@class='name']";
    String PRODUCT_PRICE = "//div[@class='total-price']/strong";
    String PRODUCT_QUANTITY = "//*[@id='pdpAddtoCartInput']";
    String PRODUCT_NAME_IN_MODAL = "//a[@class='name']";
    String PRODUCT_PRICE_ON_MODAL = "//div[@class='price']";
    String QUANTITY_FIELD = "//*[@id='pdpAddtoCartInput']";
    String QUANTITY_BUTTON = "//button[contains(@class,'$1')]";
    String SIMILAR_PRODUCTS_LINKS = "//div[text()='$1']/folTlowing-sibling::div//a";
    String SIMILAR_PRODUCTS_NAMES = "//div[text()='$1']/following-sibling::div//div[@class='item-name']";
    String SIMILAR_PRODUCTS_PRICES = "//div[text()='$1']/following-sibling::div//div[@class='priceContainer']";
    String SIMILAR_PRODUCT_LINK_IN_POP_UP = "//div[@id='cboxWrapper']//div[@class='name']/a";
    String TOOLS_ASSEMBLY_SIGN = "//div[@class='product-details page-title']/following-sibling::div[1]";
    String SIMILAR_PRODUCT_PRICE_IN_MODAL = "//*[@id='cboxLoadedContent']//div[@class='price']";
    String PRODUCT_SKU = "//div[@class='sku']/span";
    String MATERIAL_DESCRIPTION = "//div[@class='material-desc']/span";
    String TOOLS_ASSEMBLY = "//div[contains(@class,'page-details-variants-select')]/div/div";
    String LONG_DESCRIPTION = "//div[@class='tab-details']/p[1]";
    String VARIANT_PRODUCT_SELECTORS = "//div[@class='variant-selector']//div[contains(@class,'variant-name')]";
    String QTY_DROP_DOWN = "//button[@data-toggle='dropdown']";
    String QTY_DROP_DOWN_VALUES = "//button[@data-toggle='dropdown']/following-sibling::ul//a[text()='$1']";
}
