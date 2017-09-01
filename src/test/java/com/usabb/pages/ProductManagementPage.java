package com.usabb.pages;

import com.usabb.locators.ContentManagementPageLocators;
import com.usabb.locators.ProductManagementLocators;
import com.usabb.utils.CockpitUtils;
import com.usabb.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ProductManagementPage extends PageObject {
    CockpitUtils cockpitUtils;

    public boolean getProductSignVisibilityStatus() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ProductManagementLocators.PIM_PAGE_SIGN)));
        return $(ProductManagementLocators.PIM_PAGE_SIGN).isCurrentlyVisible();
    }

    public void clickOnProductCatalog(String arg0) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable((WebElement) $(ProductManagementLocators.USABB_PRODUCT_CATALOG
                .replace("$1", arg0))));
        $(ProductManagementLocators.USABB_PRODUCT_CATALOG.replace("$1", arg0)).click();
    }

    public void clickOnAdvancedSearchButton() {
        try {
            withTimeoutOf(240, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable((WebElement) $(ProductManagementLocators.BUTTON_ADVANCED_SEARCH)));
            $(ProductManagementLocators.BUTTON_ADVANCED_SEARCH).click();
        } catch (Exception e) {
            withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(ContentManagementPageLocators.SPINNER)));
            withTimeoutOf(240, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable((WebElement) $(ProductManagementLocators.BUTTON_ADVANCED_SEARCH)));
            $(ProductManagementLocators.BUTTON_ADVANCED_SEARCH).click();
        }
    }

    public void clickOnTypeComboBox() {
        cockpitUtils.clickOnElement(ProductManagementLocators.COMBOBOX_TYPE);
    }

    public void selectVariantInTypeCombobox(String arg0) {
        cockpitUtils.clickOnElement(ProductManagementLocators.TD_DROP_DOWN_VARIANT_THAT_CONTAINS_TEXT
                .replace("$1", arg0));
    }

    public void clickOnGlobalSearchButton() {
        cockpitUtils.clickOnElement(ProductManagementLocators.ADVANCED_SEARCH_GLOBAL_BUTTON);
    }

    public void selectProductByNumberFromTheList(String arg0) {
        WebElement product = $(ProductManagementLocators.PRODUCT_FROM_GRID_BY_NUMBER.replace("$1", arg0));
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(product));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(product)
                .doubleClick().build().perform();
    }

    public void rememberValueInField(String arg0) {
        try {
            withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ProductManagementLocators.INPUT_FIELD_BY_LABEL
                    .replace("$1", arg0))));
        } catch (org.openqa.selenium.TimeoutException ex) {
            cockpitUtils.clickOnElement(ContentManagementPageLocators.TOP_FRAME_ICON_BY_TITLE.replace("Open in Edit Area", arg0));
        }
        Serenity.getCurrentSession().put(arg0, $(ProductManagementLocators.INPUT_FIELD_BY_LABEL.replace("$1", arg0)).getValue());
    }

    public void enterValueInTheFieldByLabelName(String arg0, String arg1) {
        if (arg0.equalsIgnoreCase("saved"))
            arg0 = Serenity.getCurrentSession().get(arg1) != null ? Serenity.getCurrentSession().get(arg1).toString() : "test";
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ProductManagementLocators.INPUT_FIELD_BY_LABEL
                .replace("$1", arg1))));
        WebElement inputField = $(ProductManagementLocators.INPUT_FIELD_BY_LABEL.replace("$1", arg1));
        inputField.clear();
        inputField.sendKeys(arg0);
        inputField.sendKeys(Keys.ENTER);
    }

    public void synchronizeProductCatalog() {
        WebElementFacade synchButton = $(ProductManagementLocators.SYNCHRONIZATION_BUTTON);
        withTimeoutOf(120, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(synchButton));
        synchButton.click();
    }

    public boolean checkSynchSpinner() {
        try {
            withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.textToBePresentInElementLocated(By.xpath(ProductManagementLocators.SPINNER), "Synchronizing ..."));
            withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProductManagementLocators.SPINNER)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getDataFromFieldWithLabel(String arg0) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ProductManagementLocators.INPUT_FIELD_BY_LABEL
                .replace("$1", arg0))));
        return $(ProductManagementLocators.INPUT_FIELD_BY_LABEL.replace("$1", arg0)).getValue();
    }

    public boolean getFieldEditableStatus(String arg0) {
        return $(ProductManagementLocators.INPUT_FIELD_BY_LABEL.replace("$1", arg0)).isEnabled();
    }

    public void searchForProductSavedSku() {
        HashMap<String, String> map = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
        String productSku = map.get("SKU");
        WebElement searchField = $(ContentManagementPageLocators.WCMS_CONTENT_SEARCH_FIELD);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys(productSku);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchForProductSavedCode() {
        HashMap<String, String> map = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
        String productCode = map.get("Code");
        WebElement searchField = $(ContentManagementPageLocators.WCMS_CONTENT_SEARCH_FIELD);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys(productCode);
        searchField.sendKeys(Keys.ENTER);
    }
}
