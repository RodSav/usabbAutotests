package com.virco.steps.serenity;

import com.virco.pages.CategoryPage;
import com.virco.pages.GlobalElements;
import com.virco.utils.SoftAssert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.List;

public class CategoryPageUserSteps extends ScenarioSteps {

    CategoryPage categoryPage;
    GlobalElements globalElements;

    @Step
    public void verifyThatThePaginationIsShownAboveAndBelowTheListOfProducts() {
        Assert.assertTrue("The top category pagination is absent", categoryPage.getVisibilityOfPagination("2"));
        Assert.assertTrue("The bottom category pagination is absent", categoryPage.getVisibilityOfPagination("3"));
    }

    @Step
    public void verifyThatThePaginationIsSuppressedIfOnlyOnePageOfProductsExist() {
        Assert.assertFalse("The top category pagination is presented", categoryPage.getVisibilityOfPagination("1"));
        Assert.assertFalse("The bottom category pagination is presented", categoryPage.getVisibilityOfPagination("2"));
    }

    @Step
    public void enterValueInPaginationCustomPageNumberField(String arg0) {
        categoryPage.enterValueInCustomPaginationField(arg0);
    }

    @Step
    public void verifyThatTheLastPageIsShown() {
        Assert.assertTrue("The last pagination page is not shown", categoryPage.getLastPaginationNumber()
                .equals(categoryPage.calculateCountOfPaginationPages()));
    }

    @Step
    public void verifyThatTheFirstPageIsShown() {
        Assert.assertTrue("The first pagination page is not shown", categoryPage.getLastPaginationNumber()
                .equals("1"));
    }

    @Step
    public void clickOnPaginationButton(String arg0) {
        categoryPage.clickOnPaginationButton(arg0);
    }

    @Step
    public void checkValueInPaginationInputField(String arg0) {
        Assert.assertTrue("The value in pagination field is not correct",
                arg0.equalsIgnoreCase(categoryPage.getValueInPaginationInputField()));
    }

    @Step
    public void pasteValueInPaginationInputFieldUsingContextPaste(String arg0) {
        categoryPage.pasteValueInPaginationInputFieldUsingContextPaste(arg0);
    }

    @Step
    public void selectValueInSortingMenu(String arg0) {
        categoryPage.selectValueInSortingMenu(arg0);
    }

    @Step
    public void selectFacetInFilteringMenuByPosition(String arg0) {
        categoryPage.selectFacetInFilteringMenuByPosition(arg0);
    }

    @Step
    public void selectFacetInFilteringMenuWithTheCountOfProductsMoreThan(int arg0) {
        categoryPage.selectFacetInFilteringMenuWithTheCountOfProductsMoreThan(arg0);
    }

    @Step
    public void verifySelectedOptionInSortingDropDownMenu(String arg0) {
        Assert.assertTrue("The sorting drop-down doesn't contain selected option",
                arg0.equalsIgnoreCase(categoryPage.verifySelectedOptionInSortingDropDownMenu()));
    }

    @Step
    public void verifyThatSelectedFacetIsApplied() {
        Assert.assertTrue("The selected facet is missed or has wrong name",
                categoryPage.compareAppliedFacetWithSelected());
    }

    @Step
    public void verifyThatTheFirstLastNextPagesAreShownAboveAndBelowTheListOfProducts() {
        SoftAssert.clearOldResults();
        SoftAssert.assertTrue("The next page button is missed below", categoryPage.getNextPaginationButtonStatus("2"));
        SoftAssert.assertTrue("The last page button is missed below", categoryPage.getLastPaginationButtonStatus("2"));
        SoftAssert.assertTrue("The next page button is missed above", categoryPage.getNextPaginationButtonStatus("3"));
        SoftAssert.assertTrue("The last page button is missed above", categoryPage.getLastPaginationButtonStatus("3"));
        SoftAssert.assertAll();
    }

    @Step
    public void verifyThatThePreviousFirstPageButtonIsDisabled() {
        SoftAssert.assertFalse("The first page button is not disabled above", categoryPage.getFirstButtonStatus("3"));
        SoftAssert.assertFalse("The first page button is not disabled above", categoryPage.getFirstButtonStatus("2"));
        SoftAssert.assertFalse("The previous page button is not disabled above", categoryPage.getFirstButtonStatus("3"));
        SoftAssert.assertFalse("The previous page button is not disabled below", categoryPage.getFirstButtonStatus("2"));
        SoftAssert.assertAll();
    }

    @Step
    public void verifyThatTheNextLastPageButtonIsDisabled() {
        SoftAssert.assertFalse("The next page button is not disabled above", categoryPage.getNextPaginationButtonStatus("2"));
        SoftAssert.assertFalse("The next page button is not disabled below", categoryPage.getNextPaginationButtonStatus("3"));
        SoftAssert.assertFalse("The last page button is not disabled above", categoryPage.getLastPaginationButtonStatus("2"));
        SoftAssert.assertFalse("The last page button is not disabled below", categoryPage.getLastPaginationButtonStatus("3"));
        SoftAssert.assertAll();
    }

    @Step
    public void scrollPageForThePercent(String arg0, int arg1) {
        categoryPage.scrollPageForThePercent(arg0, arg1);
    }

    @Step
    public void verifyThatTheBackToTopButtonIsShown() {
        Assert.assertTrue("The back to TOP button is not shown", categoryPage.verifyThatTheBackToTopButtonIsShown());
    }

    @Step
    public void clickOnTheTopButton() {
        categoryPage.clickOnTheTopButton();
    }

    @Step
    public void verifyThatThePageScrollPositionIsDisplayed(String arg0) {
        if (arg0.equalsIgnoreCase("top"))
            Assert.assertTrue("The postion of the page is not 0 by yOffset", categoryPage.getPagePositionByYOffset() == 0);
        if (arg0.equalsIgnoreCase("bottom"))
            Assert.assertTrue("The postion of the page is not max by yOffset", categoryPage.getPagePositionByYOffset() == categoryPage.getWindowsYOffsetMax());
    }

    @Step
    public void scrollPageUntilTopButtonWillBeVisibleOrInvisible(String arg0) {
        categoryPage.scrollPageUntilTopButtonWillBeVisibleOrInvisible(arg0);
    }

    @Step
    public void verifyThatTheTopButtonIsNotShown() {
        Assert.assertFalse("The Top button is shown", categoryPage.verifyThatTheBackToTopButtonIsShown());
    }

    @Step
    public void verifyThatTheTopButtonIsCenteredMiddleToTheBottom() {
        Assert.assertTrue("The top button is not centered middle",
                categoryPage.verifyThatTopButtonIsCenteredMiddle());
    }

    @Step
    public void clickOnProductImageOnProductListPageByNumber(String arg0) {
        categoryPage.clickOnProductImageOnProductListPageByNumber(arg0);
    }

    @Step
    public void verifyThatAppropriatePageIsOpened(String arg0) {
        SoftAssert.assertTrue("Wrong page title. Expected: " + arg0 + ", but found: " + globalElements.getPageTitle(), globalElements.getPageTitle().contains(arg0));
        SoftAssert.assertTrue("Wrong last breadcrumb. Expected: " + arg0 + ", but found: " + globalElements.getLastBreadcrumb(), arg0.equals(globalElements.getLastBreadcrumb()));
        SoftAssert.assertAll();
    }

    @Step
    public void clickOnFacetByFacetName(String arg0) {
        categoryPage.clickOnFacetByItName(arg0);
    }

    @Step
    public void verifyThatFacetIsApplied(String arg0) {
        Assert.assertTrue("The facet is not applied", arg0.equalsIgnoreCase(categoryPage.getAppliedFacetName()));
    }

    @Step
    public void unselectFacet(String arg0) {
        categoryPage.unselectFacet(arg0);
    }

    @Step
    public void verifyThatSelectedFacetsAreAbsent() {
        Assert.assertTrue("There are some applied facets", categoryPage.getAppliedFacetsCount() == 0);
    }

    @Step
    public void verifyThatToggleButtonIsShownAboveTheProducts() {
        Assert.assertTrue("The toggle button is missed", categoryPage.getToggleButtonVisibleStatus());
    }

    @Step
    public void clickOnToggleButton(String arg0) {
        categoryPage.clickOnToggleButton(arg0);
    }

    @Step
    public void verifyGridListViewOnThePage(String arg0) {
        Assert.assertTrue("The page doesn't have " + arg0 + " view.", categoryPage.getPageView(arg0));
    }

    @Step
    public void verifyProductInfoOnProductPage(String arg0, String arg1) {
        Assert.assertTrue("The " + arg0 + " doesn't have " + arg1 + " information.", categoryPage.getProductInfo(arg0, arg1));
    }

    @Step
    public void rememberProductDataOnPlp() {
        categoryPage.rememberProductDataOnPlp();
    }

    @Step
    public void verifyProductsOnPlp() {
        List<String> results = categoryPage.verifyProductsOnPlp();
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void verifyThatTheFirstPreviousPagesAreShownAboveAndBelowTheListOfProducts() {
        SoftAssert.clearOldResults();
        SoftAssert.assertTrue("The first page button is missed below", categoryPage.getFirstButtonStatus("2"));
        SoftAssert.assertTrue("The previous page button is missed below", categoryPage.getPreviousPaginationButtonStatus("2"));
        SoftAssert.assertTrue("The first page button is missed above", categoryPage.getFirstButtonStatus("3"));
        SoftAssert.assertTrue("The previous page button is missed above", categoryPage.getPreviousPaginationButtonStatus("3"));
        SoftAssert.assertAll();
    }
}