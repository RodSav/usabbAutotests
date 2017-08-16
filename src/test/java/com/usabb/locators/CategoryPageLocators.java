package com.usabb.locators;

/**
 * Created by ${Timonov_Viacheslav} on 4/19/17.
 */
public interface CategoryPageLocators {
    String PAGINATION_BOT_AND_TOP = "(//ul[@class='pagination'])[$1]";
    String PAGINATION_INPUT_FIELD_TOP = "(//div[contains(@class,'number-page')]//input[@name='pageView'])[1]";
    String PAGINATION_ALL_VISIBLE_PAGE_NUMBERS = "(//ul[@class='pagination'])[2]/li[not(@id) and not(@class)]/a";
    String PAGINATION_PRODUCTS_RESULTS = "(//div[@class='pages-items'])[2]";
    String PAGINATION_PREV_FIRST_PAGE_TOP = "(//ul[@class='pagination']//a[contains(text(),'first')])[2]";
    String PAGINATION_PREV_PAGE_TOP = "(//ul[@class='pagination']//a[contains(text(),'previous')])[2]";
    String PAGINATION_NEXT_PAGE_TOP = "(//ul[@class='pagination']//a[contains(text(),'next')])[2]";
    String PAGINATION_NEXT_LAST_PAGE_TOP = "(//ul[@class='pagination']//a[contains(text(),'last')])[2]";
    String SORTING_SORT_BY_DROP_DOWN_TOP = "(//label[contains(text(),'Sort by:')]/following-sibling::form//div[@class='selectric']/span)[1]";
    String FILTER_BRAND_FACETS = "//*[@id='product-facet']//span/a";
    String FILTERING_BRAND_PRODUCT_COUNT = "//li/span[@class='facet__text']";
    String FILTERING_APPLIED_FACETS = "//ul[@class='facet__list']/li";
    String BACK_TO_TOP_BUTTON = "//button[@class='topBtn']";
    String VIEW_LIST_VIEW_BUTTON = "";
    String VIEW_GRID_VIEW_BUTTON = "";
    String LIST_OF_PRODUCTS_IMAGES = "(//*[@class='product-item' or @class='product__list--item']//img)[$1]";
    String APPLIED_FACET_LIST = "//ul[@class='facet__list']//li";
    String FACET_WITH_NAME_AND_ITS_PRODUCT_COUNT = "//ul[@style='display: block;']//a[contains(text(),'$1')]";
    String TOGGLE_BUTTONS = "//div[@class='pagination-bar top']//a/span";
    String PAGE_VIEW = "//div[contains(@class,'product__listing product__$1')]";
    String PRODUCT_INFORMATION = "//*[contains(@class,'item')]//*[contains(@class,'$1') and not(contains(@class,'panel'))]";
    String SORTING_SORT_BY_DROP_DOWN_TOP_ITEMS = "(//label[contains(text(),'Sort by:')]/following-sibling::form//div[@class='selectric-scroll'])[1]//li";
}
