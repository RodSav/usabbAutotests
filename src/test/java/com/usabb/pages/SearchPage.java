package com.usabb.pages;

import com.usabb.locators.CommonElementsLocators;
import com.usabb.locators.SearchLocators;
import com.usabb.utils.PageObject;;
import org.openqa.selenium.Keys;

public class SearchPage extends PageObject {

    public void searchForProductUsingSearchBar(String arg0) {
        $(SearchLocators.SEARCH_INPUT_FIELD).clear();
        $(SearchLocators.SEARCH_INPUT_FIELD).sendKeys(arg0);
        $(SearchLocators.SEARCH_INPUT_FIELD).sendKeys(Keys.ENTER);
    }

    public String getProductNameByPosition(String arg0) {
        return $(SearchLocators.A_PRODUCT_NAME_BY_POSITION.replace("$1", arg0)).getText();
    }

    public boolean getResultEmptyStatus() {
        return $(CommonElementsLocators.CONTENT_ON_A_PAGE).isPresent();
    }
}
