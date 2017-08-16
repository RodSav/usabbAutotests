package com.virco.steps.serenity;

import com.virco.pages.ContentManagementPage;
import com.virco.pages.ProductManagementPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.concurrent.TimeoutException;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public class ProductManagementUserSteps extends ScenarioSteps {
    ProductManagementPage productManagementPage;
    ContentManagementPage contentManagementPage;

    @Step
    public void verifyThatCmsManagerHasLoggedIn() {
        Assert.assertTrue("The CMS is not opened", productManagementPage.getProductSignVisibilityStatus());
    }

    @Step
    public void clickOnVircoProductCatalog(String argo) {
        contentManagementPage.waitForSpinner();
        productManagementPage.clickOnProductCatalog(argo);
    }

    @Step
    public void clickOnAdvancedSearchButton() {
        productManagementPage.clickOnAdvancedSearchButton();
    }

    @Step
    public void clickOnTypeComboBox() {
        contentManagementPage.waitForSpinner();
        productManagementPage.clickOnTypeComboBox();
    }

    @Step
    public void selectVariantInTypeComboBox(String arg0) {
        productManagementPage.selectVariantInTypeCombobox(arg0);
    }

    @Step
    public void clickOnGlobalSearchButton() throws TimeoutException {
        contentManagementPage.waitForSpinner();
        productManagementPage.clickOnGlobalSearchButton();
        contentManagementPage.waitForSpinner();
    }

    @Step
    public void selectProductByNumberFromTheList(String arg0) {
        productManagementPage.selectProductByNumberFromTheList(arg0);
    }

    @Step
    public void rememberValueInField(String arg0) {
        productManagementPage.rememberValueInField(arg0);
    }

    @Step
    public void enterTheValueInFieldByLabelName(String arg0, String arg1) {
        productManagementPage.enterValueInTheFieldByLabelName(arg0, arg1);
    }

    @Step
    public void synchronizeProductCatalog() {
        contentManagementPage.waitForSpinner();
        productManagementPage.synchronizeProductCatalog();
    }

    @Step
    public void verifyThatProductIsSynchronized() {
        Assert.assertTrue("The synch is not performed", productManagementPage.checkSynchSpinner());
    }

    @Step
    public void verifyThatDataInFieldIsSaved(String arg0, String arg1) {
        Assert.assertTrue("The data in input field is not saved",
                arg1.equals(productManagementPage.getDataFromFieldWithLabel(arg0)));
    }

    @Step
    public void verifyThatFieldWithLabelIsNotEditable(String arg0) {
        Assert.assertFalse("The field " + arg0 + " is editable",
                productManagementPage.getFieldEditableStatus(arg0));
    }

    @Step
    public void searchForProductSavedSku() {
        productManagementPage.searchForProductSavedSku();
        contentManagementPage.waitForSpinner();
    }
}
