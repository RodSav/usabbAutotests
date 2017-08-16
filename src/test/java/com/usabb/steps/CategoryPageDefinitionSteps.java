package com.usabb.steps;

import com.usabb.steps.serenity.CategoryPageUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CategoryPageDefinitionSteps {

    @Steps
    CategoryPageUserSteps steps;

    @Then("^the pagination is shown above and below the list of products$")
    public void thePaginationIsShownAboveAndBelowTheListOfProducts() throws Throwable {
        steps.verifyThatThePaginationIsShownAboveAndBelowTheListOfProducts();
    }

    @Then("^the pagination is suppressed$")
    public void thePaginationIsSuppressed() throws Throwable {
        steps.verifyThatThePaginationIsSuppressedIfOnlyOnePageOfProductsExist();
    }

    @When("^enter \"([^\"]*)\" in pagination page number field$")
    public void enterInPaginationPageNumberField(String arg0) throws Throwable {
        steps.enterValueInPaginationCustomPageNumberField(arg0);
    }

    @Then("^the last page is shown$")
    public void theLastPageIsShown() throws Throwable {
        steps.verifyThatTheLastPageIsShown();
    }

    @Then("^the first page is shown$")
    public void theFirstPageIsShown() throws Throwable {
        steps.verifyThatTheFirstPageIsShown();
    }

    @When("^click on \"([^\"]*)\" pagination button$")
    public void clickOnPaginationButton(String arg0) throws Throwable {
        steps.clickOnPaginationButton(arg0);
    }

    @Then("^the value in pagination input field is \"([^\"]*)\"$")
    public void theValueInPaginationInputFieldIs(String arg0) throws Throwable {
        steps.checkValueInPaginationInputField(arg0);
    }

    @When("^paste \"([^\"]*)\" using context menu in pagination page number field$")
    public void pasteUsingContextMenuInPaginationPageNumberField(String arg0) throws Throwable {
        steps.pasteValueInPaginationInputFieldUsingContextPaste(arg0);
    }

    @When("^select \"([^\"]*)\" in sorting drop-down$")
    public void selectInSortingDropDown(String arg0) throws Throwable {
        steps.selectValueInSortingMenu(arg0);
    }

    @When("^select \"([^\"]*)\" facet in filtering menu$")
    public void selectFacetInFilteringMenu(String arg0) throws Throwable {
        steps.selectFacetInFilteringMenuByPosition(arg0);
    }

    @When("^select facet with count of products more than \"([^\"]*)\"$")
    public void selectFacetWithCountOfProductsMoreThan(int arg0) throws Throwable {
        steps.selectFacetInFilteringMenuWithTheCountOfProductsMoreThan(arg0);
    }

    @Then("^selected option in sorting drop-down menu is \"([^\"]*)\"$")
    public void selectedOptionInSortingDropDownMenuIs(String arg0) throws Throwable {
        steps.verifySelectedOptionInSortingDropDownMenu(arg0);
    }

    @Then("^selected facet is applied$")
    public void selectedFacetIsApplied() throws Throwable {
        steps.verifyThatSelectedFacetIsApplied();
    }

    @Then("^the previous/first page button is disabled$")
    public void thePreviousFirstPageButtonIsDisabled() throws Throwable {
        steps.verifyThatThePreviousFirstPageButtonIsDisabled();
    }

    @Then("^the next/last page button is disabled$")
    public void theNextLastPageButtonIsDisabled() throws Throwable {
        steps.verifyThatTheNextLastPageButtonIsDisabled();
    }

    @When("^scroll \"([^\"]*)\" page for the \"([^\"]*)\" percent$")
    public void scrollPageForThePercent(String arg0, int arg1) throws Throwable {
        steps.scrollPageForThePercent(arg0, arg1);
    }

    @Then("^the Top button is shown$")
    public void theTopButtonIsShown() throws Throwable {
        steps.verifyThatTheBackToTopButtonIsShown();
    }

    @When("^click on Top button$")
    public void clickOnTopButton() throws Throwable {
        steps.clickOnTheTopButton();
    }

    @Then("^the \"([^\"]*)\" of the page is displayed$")
    public void theOfThePageIsDisplayed(String arg0) throws Throwable {
        steps.verifyThatThePageScrollPositionIsDisplayed(arg0);
    }

    @When("^scroll \"([^\"]*)\" page until top button visible status will be changed$")
    public void scrollPageUntilTopButtonVisibleStatusWillBeChanged(String arg0) throws Throwable {
        steps.scrollPageUntilTopButtonWillBeVisibleOrInvisible(arg0);
    }

    @Then("^the Top button is not shown$")
    public void theTopButtonIsNotShown() throws Throwable {
        steps.verifyThatTheTopButtonIsNotShown();
    }

    @Then("^the Top button is centered middle to the bottom$")
    public void theTopButtonIsCenteredMiddleToTheBottom() throws Throwable {
        steps.verifyThatTheTopButtonIsCenteredMiddleToTheBottom();
    }

    @When("^click on \"([^\"]*)\" product image in list$")
    public void clickOnProductImageInList(String arg0) throws Throwable {
        steps.clickOnProductImageOnProductListPageByNumber(arg0);
    }

    @Then("^appropriate \"([^\"]*)\" page is opened$")
    public void appropriatePageIsOpened(String arg0) throws Throwable {
        steps.verifyThatAppropriatePageIsOpened(arg0);
    }

    @When("^select \"([^\"]*)\" facet$")
    public void selectFacet(String arg0) throws Throwable {
        steps.clickOnFacetByFacetName(arg0);
    }

    @Then("^the \"([^\"]*)\" facet is applied$")
    public void theFacetIsApplied(String arg0) throws Throwable {
        steps.verifyThatFacetIsApplied(arg0);
    }

    @When("^unselect \"([^\"]*)\" facet$")
    public void unselectFacet(String arg0) throws Throwable {
        steps.unselectFacet(arg0);
    }

    @Then("^selected facets are not presented$")
    public void selectedFacetsAreNotPresented() throws Throwable {
        steps.verifyThatSelectedFacetsAreAbsent();
    }

    @Then("^toggle button is shown above the products$")
    public void toggleButtonIsShownAboveTheProducts() throws Throwable {
        steps.verifyThatToggleButtonIsShownAboveTheProducts();
    }

    @When("^click on \"([^\"]*)\" toggle button$")
    public void clickOnToggleButton(String arg0) throws Throwable {
        steps.clickOnToggleButton(arg0);
    }

    @Then("^the page has \"([^\"]*)\" view$")
    public void thePageHasView(String arg0) throws Throwable {
        steps.verifyGridListViewOnThePage(arg0);
    }

    @Then("^the \"([^\"]*)\" product has \"([^\"]*)\"$")
    public void theProductHas(String arg0, String arg1) throws Throwable {
        steps.verifyProductInfoOnProductPage(arg0, arg1);
    }

    @When("^remember product data on plp$")
    public void rememberProductDataOnPlp() throws Throwable {
        steps.rememberProductDataOnPlp();
    }

    @Then("^product data on plp is correct$")
    public void productDataOnPlpIsCorrect() throws Throwable {
        steps.verifyProductsOnPlp();
    }

    @Then("^the last/next pages are shown above and below the list of products$")
    public void theLastNextPagesAreShownAboveAndBelowTheListOfProducts() throws Throwable {
        steps.verifyThatTheFirstLastNextPagesAreShownAboveAndBelowTheListOfProducts();
    }

    @Then("^the first/previous pages are shown above and below the list of products$")
    public void theFirstPreviousPagesAreShownAboveAndBelowTheListOfProducts() throws Throwable {
        steps.verifyThatTheFirstPreviousPagesAreShownAboveAndBelowTheListOfProducts();
    }
}
