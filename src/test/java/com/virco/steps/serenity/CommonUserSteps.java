package com.virco.steps.serenity;

import com.virco.locators.SiteData;
import com.virco.pages.AccountManagementPage;
import com.virco.pages.CommonElementsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.ArrayList;

public class CommonUserSteps extends ScenarioSteps {

    CommonElementsPage commonElementsPage;
    AccountManagementPage managementPage;

    @Step
    public void openTheSite() {
        getDriver().get(SiteData.DEV_STOREFRONT_URL);
    }

    @Step
    public void openManagementPage(String arg0) {
        switch (arg0) {
            case "CMS":
                getDriver().get(SiteData.DEV_CMS_URL);
                break;
            case "PIM":
                getDriver().get(SiteData.DEV_PIM_URL);
                break;
            case "BackOffice":
                getDriver().get(SiteData.DEV_BACKOFFICE_URL);
                break;
            case "storefront":
                getDriver().get(SiteData.DEV_STOREFRONT_URL);
                break;
            default:
                getDriver().get(SiteData.DEV_STOREFRONT_URL);
                break;
        }
    }

    @Step
    public void loginAsSpecialUser(String arg0) {
        String username;
        String password;
        switch (arg0) {
            case "cmsmanager":
                username = SiteData.CMSMANAGER_LOGIN;
                password = SiteData.CMSMANAGER_PASSWORD;
                break;
            case "productmanager":
                username = SiteData.PRODUCTMANAGER_LOGIN;
                password = SiteData.PRODUCTMANAGER_PASSWORD;
                break;
            case "admin":
                username = SiteData.ADMIN_LOGIN;
                password = SiteData.ADMIN_PASSWORD;
                break;
            default:
                username = "admin";
                password = "nimda";
        }
        commonElementsPage.login(username, password);
    }

    @Step
    public void verifyThatLoginPageIsOpened() {
        Assert.assertTrue("The login field is not shown", commonElementsPage.getLoginFieldDisplayStatus());
        Assert.assertTrue("The password field is not shown", commonElementsPage.getPasswordFieldDisplayStatus());
    }

    @Step
    public void clickOnButtonWithName(String arg0) {
        commonElementsPage.clickOnButtonWithName(arg0);
    }

    @Step
    public void enterTheValueInTheFieldWithLabel(String arg0, String arg1) {
        commonElementsPage.enterTheValueInTheFieldWithLabel(arg0, arg1);
    }

    @Step
    public void checkContentOnThePage(String arg0) {
        Assert.assertTrue("The content is not equal to expected", arg0.equals(commonElementsPage.getContentText()));
    }

    @Step
    public void openPageAddress(String arg0) {
        getDriver().get(SiteData.DEV_STOREFRONT_URL + arg0);
    }

    @Step
    public void verifyTextInAlert(String arg0) {
        Assert.assertTrue("The text in alert is not correct. Expected: " + arg0 + ", but Found: " + commonElementsPage.getAlertTextMessage(),
                arg0.equals(commonElementsPage.getAlertTextMessage()));
    }

    @Step
    public void enterTextInTextareaByLabel(String arg0, String arg1) {
        commonElementsPage.enterTextInTheTextarea(arg0, arg1);
    }

    @Step
    public void clickOnButtonInModal(String arg0) {
        commonElementsPage.clickOnButtonInModalWindow(arg0);
    }

    @Step
    public void clickOnLoginButton() {
        managementPage.clickOnLoginPage();
    }

    @Step
    public void openAnyCategoryPage() {
        commonElementsPage.openAnyCategoryPage();
    }

    @Step
    public void rememberPageUrl() {
        commonElementsPage.rememberPageUrl();
    }

    @Step
    public void openSavedUrl() {
        commonElementsPage.openSavedUrl();
    }

    @Step
    public void switchToTheNewTab() {
        ArrayList<String> tabs2 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
//      getDriver().close();
//      getDriver().switchTo().window(tabs2.get(0));
    }

    @Step
    public void enterTextInTextareaByLabelInModal(String arg0, String arg1) {
        commonElementsPage.enterTextInTheTextareaInModal(arg0, arg1);
    }

    @Step
    public void verifyValidationMessageForField(String arg0, String arg1) {
        Assert.assertTrue("Validation message is not correct for field" + arg1, arg0.equals(commonElementsPage.getValidationMessageOfFieldWithLabel(arg1)));
    }
}