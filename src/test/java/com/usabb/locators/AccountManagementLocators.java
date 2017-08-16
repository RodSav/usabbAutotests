package com.usabb.locators;

public interface AccountManagementLocators {
    String LOGIN_BUTTON = "//*[@id='loginForm']//button";
    String CHANGE_ENV_DROP_DOWN = "//div[@title='Administration']";
    String BACKOFFICE_MENU_BY_NAME = "//span[text()='$1']";
    String BACKOFFICE_ALL_ORDERS_NUMBERS = "//div[@class='z-listbox-body']//tr//td[1]//span";

    String ACCOUNT_PAGES_PAGE_TITLE = "//div[@class='account-section']/div/div[1]";
    String SAVED_CART_ALL_NAMES = "//tr[@class='responsive-table-item']/td[contains(@class,'saved-cart-name')]/a";
    String SAVED_CARTS_DATE_SAVED_OF_CART = "//tr[@class='responsive-table-item']//a[contains(text(),'$1')]/../following-sibling::td/div";
    String SAVED_CARTS_DESCRIPTION_OF_CART = "//tr[@class='responsive-table-item']//a[contains(text(),'$1')]/../following-sibling::td/span[contains(@class,'description')]";
    String SAVED_CARTS_QTY_OF_CART = "//tr[@class='responsive-table-item']//a[contains(text(),'$1')]/../following-sibling::td/span[contains(@class,'number')]";
    String SAVED_CARTS_TOTAL_PRICE = "//tr[@class='responsive-table-item']//a[contains(text(),'$1')]/../following-sibling::td/strong/span";
    String SAVED_CARTS_REMOVE_BUTTON_OF_ALL_CARTS = "//a[@data-delete-popup-title='Delete Saved Cart']/span";
    String SAVED_CARTS_REMOVE_BUTTON_BY_CART_NAME = "//a[contains(text(),'$1')]/../following-sibling::td/a[@data-delete-popup-title='Delete Saved Cart']/span";
    String SAVED_CARTS_DESCRIPTION_OF_CART_BY_NAME = "//a[contains(text(),'$1')]/../following-sibling::td/span[contains(@class,'description')]";
    String SAVED_CART_QTY = "//div[contains(@class,'item__quantity')]/span";
    String SAVED_CART_TOTAL_PRICE = "//div[contains(@class,'item__quantity')]/following-sibling::div[1]";
    String SAVED_CART_RESTORE_BUTTON = "(//*[@id='restoreButton'])[1]";
    String SAVED_CART_SAVE_BUTTON_MODAL = "//*[@id='saveCartButton']";
    String MODAL_FORM = "//div[@id='colorbox']";
    String CONTENT_IS_EMPTY = "//div[contains(@class,'content-empty')]";
    String SERVICE_LEVEL_DROP_DOWN = "(//div[@class='selectric'])[2]";
    String SERVICE_LEVEL_DROP_DOWN_ITEMS = "(//div[@class='selectric-scroll'])[2]//li";
    String SERVICE_LEVEL_DEFAULT_OPTION = "(//div[@class='selectric'])[2]/span";
    String LINK_WITH_TITLE_NAME = "//a[@title='$1']";
}
