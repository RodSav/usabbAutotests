package com.usabb.steps.serenity;

import com.usabb.pages.GlobalElements;
import com.usabb.utils.SoftAssert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class GlobalElementsUserSteps extends ScenarioSteps {

    GlobalElements globalElements;

    @Step
    public void clickOnCategoryInNavigationMenu(String arg0) {
        globalElements.clickOnCategoryInNavigationMenu(arg0);
    }

    @Step
    public void openCategoryWithPagination() {
        globalElements.openCategoryWithPagination();
    }

    @Step
    public void openCategoryWithOutPagination() {
        globalElements.openCategoryWithOutPagination();
    }

    @Step
    public void verifyThatHeaderIsNotVisible() {
        Assert.assertTrue("The header is visible", globalElements.verifyThatHeaderIsNotVisible());
    }

    @Step
    public void verifyThatTheLogoIsShownForTheCustomerAtTheHeader() {
        Assert.assertTrue("The logo in header isn't shown", globalElements.getHeaderLogoVisibleStatus());
        Assert.assertTrue("The logo on the site doesn't equal to logo from source", globalElements.compareLogoFromSourceWithCurrent());
    }

    @Step
    public void clickOnLogoInHeader() {
        globalElements.clickOnLogoInHeader();
    }

    @Step
    public void verifyThatHomePageIsOpened() {
        Assert.assertTrue("Wrong page title. It's not a homepage.", globalElements.getPageTitle().contains("Homepage"));
        Assert.assertTrue("The header is absent on home page", globalElements.getHeaderDisplayStatus());
    }

    @Step
    public void verifyThatTheSocialLinksIsDisplayedInFooter(List<String> links) {
        List<String> results = globalElements.getSocialLinksNameFromFooter(links);
        Assert.assertTrue("Wrong social link name" + results, results.size() == 0);
    }

    @Step
    public void clickOnLinkInFooter(String arg0) {
        globalElements.clickInLinkInFooter(arg0);
    }

    public void verifyThatTheAppropriatePageIsOpened(String arg0) {
        String pageUrl = globalElements.getPageUrl();
        Assert.assertTrue("Incorrect page is opened. \nExpected: " + arg0 + " , Found: " + pageUrl,
                arg0.equalsIgnoreCase(pageUrl));
        getDriver().close();
        getDriver().switchTo().window(new ArrayList<>(getDriver().getWindowHandles()).get(0));
    }

    @Step
    public void verifyThatUserIsLoggedIn() {
        Assert.assertTrue("The My Account button is missed", globalElements.getMyAccountButtonDisplayedButton());
    }

    @Step
    public void verifyBadgesInFooter(String arg0) {
        Assert.assertTrue("The " + arg0 + " in footer isn't shown", globalElements.getBadgeLogoVisibleStatus(arg0));
        Assert.assertTrue("The " + arg0 + " on the site doesn't equal to badge from source",
                globalElements.compareBadgeFromSourceWithCurrent(arg0));
    }

    @Step
    public void verifyCategoriesInHeader(List<String> categories) {
        SoftAssert.assertTrue("Actual amount of links in Mega Menu is different from expected", categories.size() == globalElements.getListOfCategoriesInHeader().size());
        ArrayList<String> results = globalElements.verifyCategoriesInHeaderWithCategoriesFromScenario(categories);
        SoftAssert.assertTrue("Wrong sorting or link name in header " + results, results.size() < 1);
        SoftAssert.assertAll();
    }

    @Step
    public void clickOnIconInFooter(String arg0) {
        globalElements.clickOnIconInFooter(arg0);
    }

    @Step
    public void clickOnLinkInHeader(String arg0) {
        globalElements.clickOnLinkInHeader(arg0);
    }

    @Step
    public void clickOnSignoutInHeader() {
        globalElements.clickOnSignoutInHeader();
    }

    @Step
    public void clickOnLinkInMyAccountDropDownMenu(String arg0) {
        globalElements.clickOnLinkInMyAccountDropDownMenu(arg0);
    }

    @Step
    public void verifyThatCopyrightIsShownInFooter(String arg0) {
        Assert.assertTrue("The copyright is not correct", arg0.equals(globalElements.getCopyright()));
    }

    @Step
    public void verifyThatContractDropDownIsShown() {
        Assert.assertTrue("The Contract drop-down is not shown", globalElements.getContractDropDownPresenceStatus());
    }

    @Step
    public void verifyTitleInFooter(String arg0) {
        Assert.assertTrue("The title " + arg0 + " is not visible", globalElements.getVisibleStatusOfTextInFooter(arg0));
    }

    @Step
    public void verifyContactInformationInFooter(String arg0) {
        Assert.assertTrue("The information " + arg0 + " is not shown in footer", arg0.equalsIgnoreCase(globalElements.getTextOfContactInformationInFooter()));
    }

    @Step
    public void verifyFollowUsTitle() {
        Assert.assertTrue("The Follow Us title is missed", globalElements.getVisibleStatusOfFollowUsTitle());
    }

    @Step
    public void verifyBreadcrumbPath(String arg0) {
        Assert.assertTrue("Wrong breadcrubm path. Expected: " + arg0 + " ,but Found: " + globalElements.getBreadcrumbPath(),
                globalElements.getBreadcrumbPath().contains(arg0));
    }

    @Step
    public void clickOnItemInBreadcrumb(String arg0) {
        globalElements.clickOnBreadcrumbItem(arg0);
    }

    @Step
    public void verifyThatLastBreadcrumbIsText(String arg0) {
        Assert.assertTrue("The last breadcrumb is not a text", globalElements.getLastBreadcrumb().equalsIgnoreCase(arg0));
    }

    @Step
    public void verifyPresenceOfFieldWithLabel(String arg0) {
        Assert.assertTrue("The field " + arg0 + " is missed", globalElements.verifyFieldWithLabelPresenceStatus(arg0));
    }

    @Step
    public void verifyPresenceOfDropDownWithLabel(String arg0) {
        Assert.assertTrue("The drop-down " + arg0 + " is missed", globalElements.verifyDropDownWithLabelPresenceStatus(arg0));
    }

    @Step
    public void verifySelectedOptionInDropDown(String arg0, String arg1) {
        Assert.assertTrue("The " + arg0 + " drop-down doesn't contain " + arg1 + " option",
                arg1.equalsIgnoreCase(globalElements.verifySelectedOptionInDropDown(arg0)));
    }

    @Step
    public void hoverOnItemInHeader(String arg0) {
        globalElements.hoverOnItemInHeader(arg0);
    }

    @Step
    public void verifyCategoriesOnHomePage(List<String> categories) {
        List<String> results = globalElements.verifyCategoriesOnHomePage(categories);
        Assert.assertTrue("" + results, results.size() == 0);
    }
}