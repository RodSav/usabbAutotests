package com.usabb.pages;

import com.usabb.locators.AccountManagementLocators;
import com.usabb.locators.CommonElementsLocators;
import com.usabb.locators.GlobalElementsLocators;
import com.usabb.locators.ShoppingCartLocators;
import com.usabb.models.Product;
import com.usabb.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by ${Timonov_Viacheslav} on 4/20/17.
 */
public class AccountManagementPage extends PageObject {
    public void clickOnLoginPage() {
        $(AccountManagementLocators.LOGIN_BUTTON).click();
        fixContract();
    }

    //TODO remove in feature when contracts import will be done on init/update step
    public void fixContract() {
        try {
            withTimeoutOf(5, TimeUnit.SECONDS).waitFor(CommonElementsLocators.CBOX_CONTRACT_EXPIRED_CLOSE_BUTTON);
            $(CommonElementsLocators.CBOX_CONTRACT_EXPIRED_CLOSE_BUTTON).click();
            withTimeoutOf(5, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CommonElementsLocators.CBOX_CONTRACT_EXPIRED_CLOSE_BUTTON)));
        } catch (Exception e) {
        }
    }

    public boolean getAdminDropDownDisplayStatus() {
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(AccountManagementLocators.CHANGE_ENV_DROP_DOWN)));
        return $(AccountManagementLocators.CHANGE_ENV_DROP_DOWN).isPresent();
    }

    public void clickOnMenuByName(String arg0) {
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(AccountManagementLocators.BACKOFFICE_MENU_BY_NAME.replace("$1", arg0))));
        $(AccountManagementLocators.BACKOFFICE_MENU_BY_NAME.replace("$1", arg0)).click();
    }

    public boolean checkCreatedOrderInTheList(String createdOrderNumber) {
        withTimeoutOf(60, TimeUnit.SECONDS)
                .waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(AccountManagementLocators.BACKOFFICE_ALL_ORDERS_NUMBERS)));
        List<WebElementFacade> ordersInList = findAll(AccountManagementLocators.BACKOFFICE_ALL_ORDERS_NUMBERS);
        for (WebElementFacade orderNumber : ordersInList) {
            if (orderNumber.getText().equalsIgnoreCase(createdOrderNumber)) return true;
        }
        return false;
    }

    public String getPageBodyName() {
        return $(AccountManagementLocators.ACCOUNT_PAGES_PAGE_TITLE).getText();
    }

    public boolean getSavedCartPresentStatus(String arg0) {
        for (WebElement element : findAll(AccountManagementLocators.SAVED_CART_ALL_NAMES)) {
            if (element.getText().equals(arg0)) return true;
        }
        return false;
    }

    public String getCreationDateOfCart(String arg0) {
        String dateFromSite = $(AccountManagementLocators.SAVED_CARTS_DATE_SAVED_OF_CART.replace("$1", arg0)).getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDate localDate = LocalDate.now();
        return dateFromSite.substring(0, dateFromSite.lastIndexOf(dtf.format(localDate)) + 4);
    }

    public String getCartDescription(String arg0) {
        return $(AccountManagementLocators.SAVED_CARTS_DESCRIPTION_OF_CART.replace("$1", arg0)).getText();
    }

    public void removeAllSavedCarts() {
        while (!$(AccountManagementLocators.CONTENT_IS_EMPTY).isPresent()) {
            WebElement removeButton = findAll(AccountManagementLocators.SAVED_CARTS_REMOVE_BUTTON_OF_ALL_CARTS).get(0);
            removeButton.click();
            WebElementFacade deleteButton = $(CommonElementsLocators.DELETE_BUTTON_IN_MODAL);
            deleteButton.click();
            withTimeoutOf(60000, TimeUnit.MILLISECONDS).waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(AccountManagementLocators.MODAL_FORM)));
        }
    }

    public String getQtyOfCart(String arg0) {
        return $(AccountManagementLocators.SAVED_CARTS_QTY_OF_CART.replace("$1", arg0)).getText();
    }

    public Double getTotalPrice(String arg0) {
        String price = $(AccountManagementLocators.SAVED_CARTS_TOTAL_PRICE.replace("$1", arg0)).getText();
        return Double.valueOf(price.replaceAll("[^.0-9]", ""));
    }

    public void clickOnSavedCart(String arg0) {
        for (WebElement element : findAll(AccountManagementLocators.SAVED_CART_ALL_NAMES)) {
            if (element.getText().equals(arg0)) {
                element.click();
                return;
            }
        }
    }

    public ArrayList<String> verifyProductsOnTheSavedCartPage() {
        ArrayList<String> results = new ArrayList<>();
        List<Product> productsFromCartPage = (List<Product>) Serenity.getCurrentSession().get("ProductsOnCartPage");
        List<Product> productsFromPage = getProductsFromPage();
        for (int i = 0; i < Math.max(productsFromCartPage.size(), productsFromPage.size()); ++i) {
            if (!productsFromCartPage.get(i).getCode().equalsIgnoreCase(productsFromPage.get(i).getCode()))
                results.add("\nWrong SKU of product. Expected: "
                        + productsFromCartPage.get(i).getCode()
                        + " Found: " + productsFromPage.get(i).getCode());
        }
        return results;
    }

    private List<Product> getProductsFromPage() {
        int productCount = findAll(ShoppingCartLocators.ALL_PRODUCTS_FOR_COUNT).size();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productCount; ++i) {
            Product product = new Product();
            product.setName(findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME).get(i).getText());
            product.setCode(findAll(ShoppingCartLocators.ALL_PRODUCTS_CODE).get(i).getText());
            product.setPrice(findAll(ShoppingCartLocators.ALL_PRODUCTS_PRICE).get(i).getText());
            product.setQuantity(findAll(AccountManagementLocators.SAVED_CART_QTY).get(i).getText());
            product.setTotalPrice(findAll(AccountManagementLocators.SAVED_CART_TOTAL_PRICE).get(i).getText());
            products.add(product);
        }
        return products;
    }

    public void clickOnRestoreButtonInFooter() {
        $(AccountManagementLocators.SAVED_CART_RESTORE_BUTTON).click();
    }

    public void clickOnRestoreButtonInModal() {
        $(CommonElementsLocators.DELETE_BUTTON_IN_MODAL).click();
    }

    public List<String> verifyMyAccountLinks(List<String> list) {
        withTimeoutOf(15, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(GlobalElementsLocators.MY_ACCOUNT_NAV_LINKS)));
        List<String> navLinksSite = findAll(GlobalElementsLocators.MY_ACCOUNT_NAV_LINKS)
                .stream().map(e -> e.getText()).collect(Collectors.toList());
        List<String> results = new ArrayList<>();
        list = list.stream().sorted().collect(Collectors.toList());
        navLinksSite = navLinksSite.stream().sorted().collect(Collectors.toList());
        int linksSizeSource = list.size();
        int linksSizeSite = navLinksSite.size();
        if (linksSizeSite != linksSizeSource)
            results.add("Missing some links. Expected: " + linksSizeSource + ", Found: " + linksSizeSite);
        for (int i = 0; i < Math.min(linksSizeSite, linksSizeSource); ++i) {
            String linkNameSite = navLinksSite.get(i);
            String linkNameSource = list.get(i);
            if (!linkNameSite.equals(linkNameSource))
                results.add("\nExpected: " + linkNameSource + ", Found: " + linkNameSite);
        }
        return results;
    }

    public void removeSavedCartByCartName(String arg0) {
        $(AccountManagementLocators.SAVED_CARTS_REMOVE_BUTTON_BY_CART_NAME.replace("$1", arg0)).click();
    }

    public boolean verifyThatSavedCartIsPresentedOnCartPage(String arg0) {
        if ($(CommonElementsLocators.EMPTY_CONTENT_MESSAGE).isPresent()) return false;
        else {
            for (WebElement element : findAll(AccountManagementLocators.SAVED_CART_ALL_NAMES)) {
                if (element.getText().equalsIgnoreCase(arg0)) return true;
            }
        }
        return false;
    }

    public String getDescriptionOfSavedCartByCartName(String arg0) {
        return $(AccountManagementLocators.SAVED_CARTS_DESCRIPTION_OF_CART_BY_NAME.replace("$1", arg0)).getText();
    }

    public void clickOnSaveButtonInEditCartModal() {
        $(AccountManagementLocators.SAVED_CART_SAVE_BUTTON_MODAL).click();
    }

    public boolean getServiceLevelPresenceStatus() {
        return $(AccountManagementLocators.SERVICE_LEVEL_DROP_DOWN).isPresent();
    }

    public List<String> verifyThatServiceLevelContainsOptions(List<String> options) {
        List<String> results = new ArrayList<>();
        List<String> dropDownOptions = findAll(AccountManagementLocators.SERVICE_LEVEL_DROP_DOWN_ITEMS).stream().map(e -> e.getAttribute("innerText")).collect(Collectors.toList());
        for (int i = 0; i < Math.min(options.size(), dropDownOptions.size()); ++i) {
            if (!options.get(i).equals(dropDownOptions.get(i)))
                results.add("\nExpected: " + options.get(i) + " Found: " + dropDownOptions.get(i));
        }
        return results;
    }

    public String getSelectedOptionInServiceLevelDropDown() {
        return $(AccountManagementLocators.SERVICE_LEVEL_DEFAULT_OPTION).getText();
    }

    public void selectOptionInServiceLevelDropDown(String arg0) {
        $(AccountManagementLocators.SERVICE_LEVEL_DEFAULT_OPTION).click();
        for (WebElementFacade option : findAll(AccountManagementLocators.SERVICE_LEVEL_DROP_DOWN_ITEMS)) {
            if (option.getText().equalsIgnoreCase(arg0)) {
                option.click();
                return;
            }
        }
        waitABit(2000);
    }

    public void clickOnLinkWithTitle(String title) {
        $(AccountManagementLocators.LINK_WITH_TITLE_NAME.replace("$1", title)).click();
    }
}

