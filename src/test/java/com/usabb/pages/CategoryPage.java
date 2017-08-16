package com.usabb.pages;

import com.usabb.locators.CategoryPageLocators;
import com.usabb.locators.GlobalElementsLocators;
import com.usabb.models.Product;
import com.usabb.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends PageObject {

    public boolean getVisibilityOfPagination(String s) {
        try {
            return $(CategoryPageLocators.PAGINATION_BOT_AND_TOP.replace("$1", s)).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterValueInCustomPaginationField(String arg0) {
        $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).clear();
        $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).sendKeys(arg0);
        $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).sendKeys(Keys.ENTER);
    }

    public String calculateCountOfPaginationPages() {
        String productsCountLabel = $(CategoryPageLocators.PAGINATION_PRODUCTS_RESULTS).getText();
        int productsCount = Integer.valueOf(productsCountLabel.substring(productsCountLabel.indexOf("of"))
                .replaceAll("[^0-9]", ""));
        int pageCount = productsCount % 20 == 0 ? productsCount / 20 : productsCount / 20 + 1;
        return String.valueOf(pageCount);
    }

    public String getLastPaginationNumber() {
        return $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).getValue();
    }

    public void clickOnPaginationButton(String arg0) {
        switch (arg0.toLowerCase()) {
            case "next":
                $(CategoryPageLocators.PAGINATION_NEXT_PAGE_TOP).click();
                break;
            case "previous":
                $(CategoryPageLocators.PAGINATION_PREV_PAGE_TOP).click();
                break;
            case "first":
                $(CategoryPageLocators.PAGINATION_PREV_FIRST_PAGE_TOP).click();
                break;
            case "last":
                $(CategoryPageLocators.PAGINATION_NEXT_LAST_PAGE_TOP).click();
                break;
            default:
                for (WebElement element : findAll(CategoryPageLocators.PAGINATION_ALL_VISIBLE_PAGE_NUMBERS)) {
                    if (element.getText().equalsIgnoreCase(arg0)) {
                        element.click();
                        return;
                    }
                }
                break;
        }
    }

    public String getValueInPaginationInputField() {
        return $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).getValue();
    }

    public void pasteValueInPaginationInputFieldUsingContextPaste(String arg0) {
        try {
            $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).clear();
            StringSelection stringSelection = new StringSelection(arg0);
            Clipboard clpBrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpBrd.setContents(stringSelection, null);
            Robot rb = new Robot();
            new Actions(getDriver()).contextClick($(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP)).build().perform();
            rb.keyPress(KeyEvent.VK_P);
            rb.keyRelease(KeyEvent.VK_P);
            $(CategoryPageLocators.PAGINATION_INPUT_FIELD_TOP).sendKeys(Keys.ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void selectValueInSortingMenu(String arg0) {
        $(CategoryPageLocators.SORTING_SORT_BY_DROP_DOWN_TOP).click();
        for (WebElementFacade option : findAll(CategoryPageLocators.SORTING_SORT_BY_DROP_DOWN_TOP_ITEMS)) {
            if (option.getText().equalsIgnoreCase(arg0)) {
                option.click();
                return;
            }
        }
    }

    public void selectFacetInFilteringMenuByPosition(String arg0) {
        Serenity.getCurrentSession().put("appliedFacet" + arg0,
                findAll((CategoryPageLocators.FILTER_BRAND_FACETS)).get(Integer.valueOf(arg0) - 1).getText());
        findAll((CategoryPageLocators.FILTER_BRAND_FACETS)).get(Integer.valueOf(arg0) - 1).click();
    }

    public void selectFacetInFilteringMenuWithTheCountOfProductsMoreThan(int arg0) {
        for (int i =0; i <findAll(CategoryPageLocators.FILTERING_BRAND_PRODUCT_COUNT).size();++i){
            WebElement element = findAll(CategoryPageLocators.FILTERING_BRAND_PRODUCT_COUNT+"//span[@class='facet__value__count']").get(i);
            String countText = element.getAttribute("innerText").substring(element.getAttribute("innerText").lastIndexOf("(") + 1, element.getAttribute("innerText").length() - 1)
                    .replaceAll("[^0-9]", "");
            int productsCount = Integer.valueOf(countText);
            if (productsCount > arg0) {
                WebElement facet = findAll(CategoryPageLocators.FILTERING_BRAND_PRODUCT_COUNT).get(i);
                Serenity.getCurrentSession().put("selectedFacet",
                        facet.getText().substring(0, facet.getText().lastIndexOf("\n")));
                facet.click();
                return;
            }
        }
    }

    public String verifySelectedOptionInSortingDropDownMenu() {
        return  $(CategoryPageLocators.SORTING_SORT_BY_DROP_DOWN_TOP).getText();
    }

    public boolean compareAppliedFacetWithSelected() {
        String selectedFacet = Serenity.getCurrentSession().get("selectedFacet").toString();
        for (WebElement element : findAll(CategoryPageLocators.FILTERING_APPLIED_FACETS)) {
            if (element.getText().contains(selectedFacet)) return true;
        }
        return false;
    }

    public boolean getFirstButtonStatus(String s) {
        return $(CategoryPageLocators.PAGINATION_PREV_FIRST_PAGE_TOP.replace("[2]", "[" + s + "]")).isPresent();
    }

    public boolean getPreviousPaginationButtonStatus(String s) {
        return $(CategoryPageLocators.PAGINATION_PREV_PAGE_TOP.replace("[2]", "[" + s + "]")).isPresent();
    }

    public boolean getNextPaginationButtonStatus(String s) {
        return $(CategoryPageLocators.PAGINATION_NEXT_PAGE_TOP.replace("[2]", "[" + s + "]")).isPresent();
    }

    public boolean getLastPaginationButtonStatus(String s) {
        return $(CategoryPageLocators.PAGINATION_NEXT_LAST_PAGE_TOP.replace("[2]", "[" + s + "]")).isPresent();
    }

    public void scrollPageForThePercent(String arg0, int arg1) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        int percent = (getWindowsYOffsetMax() * arg1) / 100;
        if (arg0.equalsIgnoreCase("down")) jse.executeScript("window.scrollBy(0, " + percent + ")", "");
        if (arg0.equalsIgnoreCase("up")) jse.executeScript("window.scrollBy(0, -" + percent + ")", "");
    }

    public int getWindowsYOffsetMax() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        int yOffset = Math.toIntExact((Long) jse.executeScript("return window.pageYOffset;"));
        jse.executeScript("window.scrollTo(0, 0)");
        return yOffset;
    }

    public boolean verifyThatTheBackToTopButtonIsShown() {
        return $(CategoryPageLocators.BACK_TO_TOP_BUTTON).isVisible();
    }

    public void clickOnTheTopButton() {
        $(CategoryPageLocators.BACK_TO_TOP_BUTTON).click();
    }

    public int getPagePositionByYOffset() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        return Math.toIntExact((Long) jse.executeScript("return window.pageYOffset;"));
    }

    public void scrollPageUntilTopButtonWillBeVisibleOrInvisible(String arg0) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        if (arg0.equalsIgnoreCase("down")) {
            while (!$(CategoryPageLocators.BACK_TO_TOP_BUTTON).isVisible()) {
                jse.executeScript("window.scrollBy(0, 5)", "");
                if (Math.toIntExact((Long) jse.executeScript("return window.pageYOffset;")) > 1400) return;
            }
        }
        if (arg0.equalsIgnoreCase("up")) {
            while ($(CategoryPageLocators.BACK_TO_TOP_BUTTON).isVisible()) {
                jse.executeScript("window.scrollBy(0, -5)", "");
                if (Math.toIntExact((Long) jse.executeScript("return window.pageYOffset;")) < 50) return;
            }
        }
    }

    public boolean verifyThatTopButtonIsCenteredMiddle() {
        int pageWidth = Integer.valueOf($(GlobalElementsLocators.BODY).getAttribute("clientWidth"));
        int buttonWidth = Integer.valueOf($(CategoryPageLocators.BACK_TO_TOP_BUTTON).getAttribute("clientWidth"));
        int offsetLeftPosition = (pageWidth - buttonWidth) / 2;
        int buttonOffsetLeft = Integer.valueOf($(CategoryPageLocators.BACK_TO_TOP_BUTTON).getAttribute("offsetLeft"));
        int allowedRange = 80;
        String buttonBottomPx = $(CategoryPageLocators.BACK_TO_TOP_BUTTON).getCssValue("bottom");
        return offsetLeftPosition + allowedRange > buttonOffsetLeft && offsetLeftPosition - allowedRange < buttonOffsetLeft
                && buttonBottomPx.equalsIgnoreCase("0px");
    }

    public boolean getListViewButtonStatus() {
        return $(CategoryPageLocators.VIEW_LIST_VIEW_BUTTON).isPresent();
    }

    public boolean getGridViewButtonStatus() {
        return $(CategoryPageLocators.VIEW_GRID_VIEW_BUTTON).isPresent();
    }

    public void clickOnProductImageOnProductListPageByNumber(String arg0) {
        $(CategoryPageLocators.LIST_OF_PRODUCTS_IMAGES.replace("$1", arg0)).click();
    }

    public void clickOnFacetByItName(String arg0) {
        $(CategoryPageLocators.FACET_WITH_NAME_AND_ITS_PRODUCT_COUNT.replace("$1", arg0)).click();
    }

    public String getAppliedFacetName() {
        String appliedFacet = $(CategoryPageLocators.APPLIED_FACET_LIST).getText();
        return appliedFacet.substring(0, appliedFacet.lastIndexOf(' '));
    }

    public void unselectFacet(String arg0) {
        java.util.List<WebElementFacade> facets = findAll(CategoryPageLocators.APPLIED_FACET_LIST);
        for (int i = 0; i < facets.size(); ++i) {
            if (facets.get(i).getText().contains(arg0)) {
                findAll(CategoryPageLocators.APPLIED_FACET_LIST + "/a").get(i).click();
                return;
            }
        }
    }

    public int getAppliedFacetsCount() {
        return findAll(CategoryPageLocators.APPLIED_FACET_LIST).size();
    }

    public boolean getToggleButtonVisibleStatus() {
        for (WebElement element : findAll(CategoryPageLocators.TOGGLE_BUTTONS)) {
            if (!element.isDisplayed()) return false;
        }
        return true;
    }

    public void clickOnToggleButton(String arg0) {
        if (arg0.equalsIgnoreCase("grid")) findAll(CategoryPageLocators.TOGGLE_BUTTONS).get(0).click();
        else findAll(CategoryPageLocators.TOGGLE_BUTTONS).get(1).click();
    }

    public boolean getPageView(String arg0) {
        return $(CategoryPageLocators.PAGE_VIEW.replace("$1", arg0)).isPresent();
    }

    public boolean getProductInfo(String arg0, String arg1) {
        return findAll(CategoryPageLocators.PRODUCT_INFORMATION.replace("$1", arg1.toLowerCase())).get(Integer.valueOf(arg0) - 1).isVisible();
    }

    public void rememberProductDataOnPlp() {
        Serenity.getCurrentSession().put("ProductsPLP", getDataOfProductsOnPlp());
    }

    private List<Product> getDataOfProductsOnPlp() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < findAll(CategoryPageLocators.PRODUCT_INFORMATION.replace("$1", "name".toLowerCase())).size(); ++i) {
            Product product = new Product();
            product.setName(findAll(CategoryPageLocators.PRODUCT_INFORMATION.replace("$1", "name".toLowerCase())).get(i).getText());
            productList.add(product);
            //TODO add price when it will be available
        }
        return productList;
    }

    public List<String> verifyProductsOnPlp() {
        List<String> results = new ArrayList<>();
        List<Product> productsSaved = (List<Product>) Serenity.getCurrentSession().get("ProductsPLP");
        List<Product> productsOnPlp = getDataOfProductsOnPlp();
        if (productsOnPlp.size() != productsSaved.size()) results.add("Products sizes are not the same");
        for (int i = 0; i < Math.min(productsOnPlp.size(), productsSaved.size()); ++i) {
            if (!productsOnPlp.get(i).getName().substring(0, 10).equalsIgnoreCase(productsSaved.get(i).getName().substring(0, 10)))
                results.add("\nExpected: " + productsOnPlp.get(i).getName() + " Found: " + productsSaved.get(i).getName());
        }
        return results;
    }
}
