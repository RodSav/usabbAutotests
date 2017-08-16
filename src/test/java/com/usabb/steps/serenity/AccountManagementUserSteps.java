package com.usabb.steps.serenity;

import com.usabb.models.Product;
import com.usabb.pages.AccountManagementPage;
import com.usabb.pages.ContentManagementPage;
import com.usabb.pages.GlobalElements;
import com.usabb.utils.CommonUtils;
import com.usabb.utils.SoftAssert;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccountManagementUserSteps extends ScenarioSteps {
    AccountManagementPage managementPage;
    GlobalElements globalElements;
    ContentManagementPage contentManagementPage;

    @Step
    public void clickOnLoginButton() {
        managementPage.clickOnLoginPage();
    }

    @Step
    public void verifyThatBackOfficeIsOpened() {
        Assert.assertTrue("The backoffice is not opened", managementPage.getAdminDropDownDisplayStatus());
    }

    @Step
    public void clickOnMenuInBackOffice(String arg0) {
        managementPage.clickOnMenuByName(arg0);
    }

    @Step
    public void verifyThatCreatedOrderIsPresentedInTheList() {
        String createdOrderNumber = Serenity.getCurrentSession().get("CreatedOrderNumber") != null ?
                Serenity.getCurrentSession().get("CreatedOrderNumber").toString() : "order Is Not Created";
        Assert.assertTrue("Can't find the created order in the list", managementPage.checkCreatedOrderInTheList(createdOrderNumber));
    }

    @Step
    public void verifyThatTheSavedCartsPageIsOpened() {
        String pageName = "Saved Carts";
        SoftAssert.assertTrue("Wrong page title. Expected: Saved Carts, but found: " + globalElements.getPageTitle(), globalElements.getPageTitle().contains(pageName));
        SoftAssert.assertTrue("Wrong last breadcrumb. Expected: Saved Carts, but found: " + globalElements.getLastBreadcrumb(), pageName.equals(globalElements.getLastBreadcrumb()));
        SoftAssert.assertTrue("Wrong page Saved Carts body name", pageName.equals(managementPage.getPageBodyName()));
        SoftAssert.assertAll();
    }

    @Step
    public void verifyThatSavedCartIsShownOnThePage(String arg0, String arg1) {
        Assert.assertTrue("The saved cart - " + arg0 + " is not shown on the Saved Cart page", managementPage.getSavedCartPresentStatus(arg0));
        String currentDate = CommonUtils.getCurrentDate();
        SoftAssert.assertTrue("Wrong saved cart date. Expected: " + currentDate + ", but Found: " + managementPage.getCreationDateOfCart(arg0),
                currentDate.equals(managementPage.getCreationDateOfCart(arg0)));
        SoftAssert.assertTrue("Wrong cart description, Expected: " + arg1 + ", Found: " + managementPage.getCartDescription(arg0),
                arg1.equals(managementPage.getCartDescription(arg0)));
        List<Product> products = (List<Product>) Serenity.getCurrentSession().get("ProductsOnCartPage");
        int qty = 0;
        Double totalPrice = 0.0;
        for (Product product : products) {
            qty += product.getQuantity();
            totalPrice += product.getTotalPrice();
        }
        SoftAssert.assertTrue("Wrong quantity of Cart. Expected: " + qty + ", but Found:" + managementPage.getQtyOfCart(arg0),
                qty == Integer.valueOf(managementPage.getQtyOfCart(arg0)));
        SoftAssert.assertTrue("The total price is wrong. Expected: " + totalPrice + ", but Found: " + managementPage.getTotalPrice(arg0),
                totalPrice.equals(managementPage.getTotalPrice(arg0)));
        SoftAssert.assertAll();
    }

    @Step
    public void removeAllSavedCarts() {
        managementPage.removeAllSavedCarts();
    }

    @Step
    public void clickOnSavedCart(String arg0) {
        managementPage.clickOnSavedCart(arg0);
    }

    @Step
    public void verifyProductsOnSavedCartPage() {
        ArrayList<String> results = managementPage.verifyProductsOnTheSavedCartPage();
        Assert.assertTrue("Wrong products on saved cart page:" + results, results.size() == 0);
    }

    @Step
    public void clickOnRestoreButtonInFooter() {
        managementPage.clickOnRestoreButtonInFooter();
    }

    @Step
    public void clickOnRestoreButtonInModal() {
        managementPage.clickOnRestoreButtonInModal();
    }

    @Step
    public void verifyMyAccountLinks(List<String> myAccountLinks) {
        List<String> results = managementPage.verifyMyAccountLinks(myAccountLinks);
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void verifyMyAccountPages(String pageName) {
        SoftAssert.clearOldResults();
        switch (pageName) {
            case "Personal Details": {
                String pageTitle = "Update Profile";
                String breadcrumb = "Profile";
                checkPageWithDifferentNames(pageName, pageTitle, breadcrumb);
                SoftAssert.assertAll();
                break;
            }
            case "Email Address": {
                String pageTitle = "View Email";
                String breadcrumb = "Profile";
                checkPageWithDifferentNames(pageName, pageTitle, breadcrumb);
                SoftAssert.assertAll();
                break;
            }
            case "Payment Details": {
                commonPagesCheck(pageName);
                SoftAssert.assertAll();
                break;
            }
            case "Order History": {
                commonPagesCheck(pageName);
                SoftAssert.assertAll();
                break;
            }
            case "Quotes Submitted for Review": {
                checkPageWithDifferentNames("Quotes Submitted For Review",pageName,pageName);
                SoftAssert.assertAll();
                break;
            }
            case "Saved Carts": {
                commonPagesCheck(pageName);
                SoftAssert.assertAll();
                break;
            }
            case "Password": {
                String pageTitle = "Update Forgotten Password";
                checkPageWithDifferentNames(pageName, pageTitle, pageName);
                SoftAssert.assertAll();
                break;
            }
            default:
                Assert.assertTrue("Wrong page name to check", false);
        }
    }

    @Step
    public void commonPagesCheck(String pageName) {
        SoftAssert.assertTrue("Wrong page title. Expected: " + pageName + ", but found: " + globalElements.getPageTitle(), globalElements.getPageTitle().contains(pageName));
        SoftAssert.assertTrue("Wrong last breadcrumb. Expected: " + pageName + ", but found: " + globalElements.getLastBreadcrumb(), pageName.equals(globalElements.getLastBreadcrumb()));
        SoftAssert.assertTrue("Wrong page " + pageName + " body name", managementPage.getPageBodyName().contains(pageName));
    }

    @Step
    public void checkPageWithDifferentNames(String pageName, String pageTitle, String breadcrumb) {
        SoftAssert.assertTrue("Wrong page title. Expected: " + pageTitle + ", but found: " + globalElements.getPageTitle(), globalElements.getPageTitle().contains(pageTitle));
        SoftAssert.assertTrue("Wrong last breadcrumb. Expected: " + breadcrumb + ", but found: " + globalElements.getLastBreadcrumb(), breadcrumb.equals(globalElements.getLastBreadcrumb()));
        SoftAssert.assertTrue("Wrong page " + pageName + " body name", pageName.equals(managementPage.getPageBodyName()));
    }

    @Step
    public void removeSavedCartByCartName(String arg0) {
        managementPage.removeSavedCartByCartName(arg0);
    }

    @Step
    public void verifyThatCartIsNotPresentedOnSavedCartPage(String arg0) {
        Assert.assertFalse("The cart " + arg0 + " is shown on Saved Cart page", managementPage.verifyThatSavedCartIsPresentedOnCartPage(arg0));
    }

    @Step
    public void verifyThatCartIsPresentedOnSavedCartPage(String arg0) {
        Assert.assertTrue("The cart " + arg0 + " is not shown on Saved Cart page", managementPage.verifyThatSavedCartIsPresentedOnCartPage(arg0));
    }

    @Step
    public void verifyCartDescription(String arg0, String arg1) {
        Assert.assertTrue("Wrong cart description.", arg1.equals(managementPage.getDescriptionOfSavedCartByCartName(arg0)));
    }

    @Step
    public void clickOnSaveButtonInEditCartModal() {
        managementPage.clickOnSaveButtonInEditCartModal();
    }

    @Step
    public void verifyThatTheServiceLevelDropDownIsShownInHeader() {
        Assert.assertTrue("The service drop-down is not presented in header", managementPage.getServiceLevelPresenceStatus());
    }

    @Step
    public void verifyThatServiceLevelContainsOptions(List<String> options) {
        List<String> results = managementPage.verifyThatServiceLevelContainsOptions(options);
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void verifyThatTheOptionIsSelectedValueInServiceLevelDropDown(String arg0) {
        Assert.assertTrue("The option " + arg0 + " is not selected option", arg0.equals(managementPage.getSelectedOptionInServiceLevelDropDown()));
    }

    @Step
    public void selectOptionInServiceLevelDropDown(String arg0) {
        managementPage.selectOptionInServiceLevelDropDown(arg0);
    }

    @Step
    public void clickOnLinkWithTitle(String arg0) {
        managementPage.clickOnLinkWithTitle(arg0);
    }
}
