package com.virco.steps.serenity;

import com.virco.pages.ContentManagementPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public class ContentManagementUserSteps extends ScenarioSteps {
    ContentManagementPage contentManagementPage;

    @Step
    public void verifyThatCmsManagerHasLoggedIn() {
        Assert.assertTrue("The CMS is not opened", contentManagementPage.getWCMSSignVisibilityStatus());
    }

    @Step
    public void logout() {
        contentManagementPage.logout();
    }

    @Step
    public void clickOnUsabbCatalog() {
        contentManagementPage.clickOnUsabbCatalog();
    }

    @Step
    public void openContentCatalog(String arg0) {
        contentManagementPage.waitForSpinner();
        contentManagementPage.openContentCatalog(arg0);
    }

    @Step
    public void doubleClickOnContentPageTemplate(String arg0) {
        contentManagementPage.makeDoubleClickOnContentPageTemplate(arg0);
    }

    @Step
    public void clickOnActionButtonByTitle(String arg0) {
        contentManagementPage.clickOnActionButtonByName(arg0);
    }

    @Step
    public void clickOnButtonInEditSection(String arg0, String arg1) {
        contentManagementPage.clickOnButtonInEditSection(arg0, arg1);
    }

    @Step
    public void enterValueInContentTextArea(String arg0) {
        contentManagementPage.waitForSpinner();
        contentManagementPage.enterValueInContentTextArea(arg0);
    }

    @Step
    public void checkThatProductIsSynchronized(String arg0) {
        Assert.assertTrue("The content is not synchronized", contentManagementPage.getActionButtonTitle(arg0));
    }

    @Step
    public void clickOnTopEditorLink(String arg0) {
        contentManagementPage.clickOnTopLinkByTitle(arg0);
    }

    @Step
    public void clickOnSynchButton() {
        contentManagementPage.waitForSpinner();
        contentManagementPage.clickOnSynchButton();
    }

    @Step
    public void clickOnPaginationButton(String arg0) {
        contentManagementPage.clickOnPaginationButton(arg0);
        contentManagementPage.waitForSpinner();
    }

    @Step
    public void checkIsContentPageOpened(String arg0) {
        Assert.assertTrue("Content does not match with expected.\n" + contentManagementPage.compareContentOfPage(arg0),
                contentManagementPage.compareContentOfPage(arg0).get(0).equals("true"));
    }

    @Step
    public void enterContentFromFile(String arg0) {
        contentManagementPage.enterContentFromAFile(arg0);
    }

    @Step
    public void selectButtonInRemovePopUp(String arg0) {
        contentManagementPage.selectButtonInRemovePopUp(arg0);
    }

    @Step
    public void verifyThatContentIsPresentedInSection(String arg0, String arg1) {
        Assert.assertTrue("The content is not presented",
                contentManagementPage.getMessageLabelVisibleStatus(arg0, arg1));
    }

    @Step
    public void clickOnButtonInSectionHeader(String arg0, String arg1) {
        contentManagementPage.clickOnButtonInSectionHeader(arg0, arg1);
    }

    @Step
    public void selectTemplateFromModalWindow(String arg0) {
        contentManagementPage.waitForSpinner();
        contentManagementPage.selectTemplateFromModalWindow(arg0);
    }

    @Step
    public void clickOnButtonByName(String arg0) {
        contentManagementPage.clickOnButtonByName(arg0);
    }

    @Step
    public void searchForContent(String arg0) {
        contentManagementPage.enterValueInSearchField(arg0);
        contentManagementPage.clickOnSearchButton();
    }

    @Step
    public void verifyThatRotatingCarouselIsShown() {
        Assert.assertTrue("The rotating carousel is not shown on home page", contentManagementPage.getRotatingCarouselPresenceStatus());
    }

    @Step
    public void verifyRotatingCarouselComponents() {
        Assert.assertTrue("" + contentManagementPage.verifyRotatingCarouselComponents(), contentManagementPage.verifyRotatingCarouselComponents().size() == 0);
    }

    @Step
    public void clickOnBannerComponent(String arg0) {
        contentManagementPage.clickOnBannerComponent(arg0);
    }

    @Step
    public void enterValueInContentComponentEditor(String arg0) {
        contentManagementPage.enterContentFromFileToComponentEditor(arg0);
    }

    @Step
    public void verifyContentInCarousel(String arg0, int arg1) {
        Assert.assertTrue("Content does not match with expected.\n" + contentManagementPage.compareContentOfBanner(arg0, arg1),
                contentManagementPage.compareContentOfBanner(arg0, arg1).get(0).equals("true"));
    }

    @Step
    public void verifyThePageTitleOnHomePage(String arg0) {
        Assert.assertTrue("The page title is not " + arg0, arg0.equals(contentManagementPage.getPageTitleOnHomePage()));
    }

    @Step
    public void clickOnSearchButtonInModal() {
        contentManagementPage.clickOnSearchButtonInModal();
    }

    @Step
    public void clickOnValueInModalResults(String arg0) {
        contentManagementPage.clickOnValueInModalResults(arg0);
    }

    @Step
    public void verifyThatBannerComponentIsShownOnHomePage() {
        Assert.assertTrue("The banner component is not shown on home page", contentManagementPage.getPresenceStatusOfBannerComponent());
    }

    @Step
    public void verifyBannerHeader(String arg0) {
        Assert.assertTrue("The header text in banner is not " + arg0, arg0.equals(contentManagementPage.getBannerHeaderText()));
    }

    @Step
    public void verifyBannerContentText(String arg0) {
        Assert.assertTrue("The text in banner is not " + arg0, arg0.equals(contentManagementPage.getBannerText()));
    }
}
