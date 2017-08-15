package com.virco.pages;

import com.virco.locators.CategoryPageLocators;
import com.virco.locators.CommonElementsLocators;
import com.virco.locators.GlobalElementsLocators;
import com.virco.locators.SiteData;
import com.virco.utils.ImageUtils;
import com.virco.utils.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by ${Timonov_Viacheslav} on 4/19/17.
 */
public class GlobalElements extends PageObject {

    public void clickOnCategoryInNavigationMenu(String arg0) {
        for (WebElementFacade webElement : findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS)) {
            if (webElement.getText().equalsIgnoreCase(arg0)) {
                webElement.click();
                return;
            }
        }
    }

    public void openCategoryWithPagination() {
        int countOfCategories = findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS).size();
        for (int i = 0; i < countOfCategories; ++i) {
            findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS).get(i).click();
            if (withTimeoutOf(60000, TimeUnit.MILLISECONDS).elementIsPresent(
                    By.xpath(CategoryPageLocators.PAGINATION_BOT_AND_TOP.replace("$1", "1")))) return;
        }
    }

    public void openCategoryWithOutPagination() {
        int countOfCategories = findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS).size();
        for (int i = 0; i < countOfCategories; ++i) {
            findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS).get(i).click();
            if (!withTimeoutOf(60000, TimeUnit.MILLISECONDS).elementIsPresent(
                    By.xpath(CategoryPageLocators.PAGINATION_BOT_AND_TOP.replace("$1", "1")))) return;
        }
    }

    public boolean verifyThatHeaderIsNotVisible() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        int headerHeight = Integer.valueOf($(GlobalElementsLocators.HEADER_GLOBAL).getAttribute("clientHeight"));
        int yOffset = Math.toIntExact((Long) jse.executeScript("return window.pageYOffset;"));
        return headerHeight < yOffset + 100;
    }

    public boolean compareLogoFromSourceWithCurrent() {
        return ImageUtils.compareImages(new File("src/test/resources/images/logo.png"),
                new File("src/test/resources/images/logoFromSiteTmp.png"),
                $(GlobalElementsLocators.HEADER_LOGO).getAttribute("src"));
    }

    public boolean getHeaderLogoVisibleStatus() {
        return $(GlobalElementsLocators.HEADER_LOGO).isVisible();
    }

    public void clickOnLogoInHeader() {
        $(GlobalElementsLocators.HEADER_LOGO).click();
    }

    public String getPageTitle() {
        String pageTitle = getDriver().getTitle();
        return pageTitle.replace(SiteData.SITE_TITLE, "").replace("|", "");
    }

    public List<String> getSocialLinksNameFromFooter(List<String> links) {
        List<String> socialLinksNameFromFooter = findAll(GlobalElementsLocators.FOOTER_SOCIAL_LINKS)
                .stream().map(e -> e.getText()).collect(Collectors.toList());
        links = new ArrayList<>(links);
        socialLinksNameFromFooter.sort(String::compareTo);
        links.sort(String::compareTo);
        List<String> results = new ArrayList<>();
        for (int i = 0; i < (links.size() < socialLinksNameFromFooter.size() ? links.size() : socialLinksNameFromFooter.size()); ++i) {
            if (!links.get(i).equals(socialLinksNameFromFooter.get(i)))
                results.add("\n Expected: " + links.get(i) + " Found: " + socialLinksNameFromFooter.get(i));
        }
        return results;
    }

    public void clickInLinkInFooter(String arg0) {
        $(GlobalElementsLocators.FOOTER_LINK_BY_NAME.replace("$1", arg0)).click();
    }

    public String getPageUrl() {
        if (getDriver().getWindowHandles().size() > 1)
            getDriver().switchTo().window(new ArrayList<>(getDriver().getWindowHandles()).get(1));
        return getDriver().getCurrentUrl();
    }

    public boolean getHeaderDisplayStatus() {
        return $(GlobalElementsLocators.HEADER_GLOBAL).isCurrentlyVisible();
    }

    public boolean getWelcomeSignDisplayedStatus() {
        return $(GlobalElementsLocators.HEADER_WELCOME_SIGN).isCurrentlyVisible();
    }

    public boolean getMyAccountButtonDisplayedButton() {
        return $(GlobalElementsLocators.HEADER_MY_ACCOUNT_BUTTON).isCurrentlyVisible();
    }

    public boolean getSignOutButtonDisplayedStatus() {
        return $(GlobalElementsLocators.HEADER_SIGN_OUT_BUTTON).isCurrentlyVisible();
    }

    public boolean getBadgeLogoVisibleStatus(String arg0) {
        return $(GlobalElementsLocators.BADGE_BY_NAME.replace("$1", arg0)).isDisplayed();
    }

    public boolean compareBadgeFromSourceWithCurrent(String arg0) {
        String filePath = "src/test/resources/images/badges/";
        String fileNameWithExtension = ImageUtils.getFileNameWithExtension(arg0, filePath);
        return ImageUtils.compareImages(new File(filePath + fileNameWithExtension),
                new File(filePath + "tmp" + fileNameWithExtension),
                $(GlobalElementsLocators.BADGE_BY_NAME.replace("$1", fileNameWithExtension)).getAttribute("src"));
    }

    public List<String> getListOfCategoriesInHeader() {
        List<String> listOfCategoriesInHeader = findAll(GlobalElementsLocators.HEADER_CATEGORIES)
                .stream().map(e -> e.getAttribute("title")).collect(Collectors.toList());
        return listOfCategoriesInHeader;
    }

    public ArrayList<String> verifyCategoriesInHeaderWithCategoriesFromScenario(List<String> categories) {
        ArrayList<String> results = new ArrayList<>();
        List<String> categoriesFromHeader = getListOfCategoriesInHeader();
        int count = categories.size() > categoriesFromHeader.size() ? categoriesFromHeader.size() : categories.size();
        for (int i = 0; i < count; ++i) {
            if (!categories.get(i).equals(categoriesFromHeader.get(i))) {
                results.add("Wrong sorting or link name in header navigation. Expected: "
                        + categories.get(i) + ", but found: " + categoriesFromHeader.get(i) + "\n");
            }
        }
        return results;
    }

    public void clickOnIconInFooter(String arg0) {
        $(GlobalElementsLocators.BADGE_BY_NAME.replace("$1", arg0)).click();
    }

    public String getLastBreadcrumb() {
        return $(GlobalElementsLocators.LAST_BREADCRUMB).getAttribute("innerHTML");
    }

    public void clickOnLinkInHeader(String arg0) {
        $(GlobalElementsLocators.HEADER_LINK.replace("$1", arg0)).click();
    }

    public void clickOnSignoutInHeader() {
        $(GlobalElementsLocators.HEADER_SIGN_OUT_BUTTON).click();
    }

    public void clickOnLinkInMyAccountDropDownMenu(String arg0) {
        WebElement buttonMyAccount = $(GlobalElementsLocators.HEADER_MY_ACCOUNT_LINK.replace("$1", arg0));
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(buttonMyAccount));
        buttonMyAccount.click();
    }

    public String getCopyright() {
        return $(GlobalElementsLocators.COPYRIGHT).getText();
    }

    public boolean getContractDropDownPresenceStatus() {
        return $(GlobalElementsLocators.CONTRACT_DROP_DOWN).isCurrentlyVisible();
    }

    public boolean getVisibleStatusOfTextInFooter(String arg0) {
        return $(GlobalElementsLocators.TITLE_IN_FOOTER.replace("$1", arg0)).isCurrentlyVisible();
    }

    public String getTextOfContactInformationInFooter() {
        return $(GlobalElementsLocators.TELEPHONE_INFORMATION).getText();
    }

    public boolean getVisibleStatusOfFollowUsTitle() {
        return $(GlobalElementsLocators.FOLLOW_US_TITLE).isCurrentlyVisible();
    }

    public String getBreadcrumbPath() {
        StringBuilder breadcrumbPath = new StringBuilder();
        for (WebElementFacade elementFacade : findAll(GlobalElementsLocators.BREADCRUMB_ITEMS)) {
            breadcrumbPath.append(elementFacade.getText()).append(" ");
        }
        return breadcrumbPath.toString();
    }

    public void clickOnBreadcrumbItem(String arg0) {
        findAll(GlobalElementsLocators.BREADCRUMB_ITEMS).get(Integer.valueOf(arg0) - 1).click();
    }

    public boolean verifyFieldWithLabelPresenceStatus(String arg0) {
        try {
            return $(CommonElementsLocators.FIELD_BY_LABEL.replace("$1", arg0)).isPresent();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyDropDownWithLabelPresenceStatus(String arg0) {
        try {
            return $(CommonElementsLocators.SELECT_WITH_LABEL.replace("$1", arg0)).isPresent();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String verifySelectedOptionInDropDown(String name) {
        return $(CommonElementsLocators.SELECT_WITH_LABEL.replace("$1", name)).getText();
    }

    public boolean getPresenceOfTheButton(String arg0) {
        return $(CommonElementsLocators.BUTTON_IN_MODAL_WITH_NAME.replace("$1", arg0)).isPresent();
    }

    public void hoverOnItemInHeader(String arg0) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement($(GlobalElementsLocators.DROP_DOWN_IN_HEADER.replace("$1", arg0))).build().perform();
    }

    public List<String> verifyCategoriesOnHomePage(List<String> categories) {
        List<String> results = new ArrayList<>();
        List<String> categoriesOnThePage = findAll(GlobalElementsLocators.ALL_CATEGORIES_ON_HOME_PAGE).stream().map(WebElementFacade::getText).collect(Collectors.toList());
        for (int i = 0; i < Math.min(categories.size(), categoriesOnThePage.size()); ++i) {
            if (!categories.get(i).equals(categoriesOnThePage.get(i)))
                results.add("\nExpected: " + categories.get(i) + " Found: " + categoriesOnThePage.get(i));
        }
        return results;
    }
}
