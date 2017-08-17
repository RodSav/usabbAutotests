package com.usabb.locators;

public interface ProductManagementLocators {

    String PIM_PAGE_SIGN = "//td[contains(text(),'Product')]";
    String USABB_PRODUCT_CATALOG = "//div[@class='catalog_section_container']//div[contains(text(),'UsaBlueBook Product Catalog $1')]";
    String BUTTON_ADVANCED_SEARCH = "//a[@title='Advanced search']";
    String COMBOBOX_TYPE = "(//div[@class='advanceSearchTopArea']//img)[1]";
    String TD_DROP_DOWN_VARIANT_THAT_CONTAINS_TEXT = "//td[text()='$1']";
    String ADVANCED_SEARCH_GLOBAL_BUTTON = "(//div[@class='advSearchBottomToolbar']//img)[3]";
    String PRODUCT_FROM_GRID_BY_NUMBER = "(//div[@class='gridImageDiv'])[$1]";
    String INPUT_FIELD_BY_LABEL = "(//span[contains(text(),'$1')]/../../..//input | //label[contains(text(),'$1')]/following-sibling::input)";
    String SYNCHRONIZATION_BUTTON = "//img[@title='Start synchronization']";
    String SPINNER = "//div[@id='zk_loading']/div";
}
