package com.virco.pages;

import com.virco.locators.CommonElementsLocators;
import com.virco.locators.ContentManagementPageLocators;
import com.virco.locators.GlobalElementsLocators;
import com.virco.utils.CockpitUtils;
import com.virco.utils.ContentUtils;
import com.virco.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public class ContentManagementPage extends PageObject {

    CockpitUtils cockpitUtils;

    public boolean getWCMSSignVisibilityStatus() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ContentManagementPageLocators.WCMS_PAGE_SIGN)));
        return $(ContentManagementPageLocators.WCMS_PAGE_SIGN).isCurrentlyVisible();
    }

    public void logout() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ContentManagementPageLocators.MENU_DROPDOWN)));
        $(ContentManagementPageLocators.MENU_DROPDOWN).click();
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ContentManagementPageLocators.LOGOUT_MENU_ITEM)));
        $(ContentManagementPageLocators.LOGOUT_MENU_ITEM).click();
    }

    public void openContentCatalog(String arg0) {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable((WebElement) $(ContentManagementPageLocators.USABB_CONTENT_CATALOG
                .replace("$1", arg0))));
        $(ContentManagementPageLocators.USABB_CONTENT_CATALOG.replace("$1", arg0)).click();
    }

    public void clickOnUsabbCatalog() {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.USABB_SITE_MENU_ITEM);
    }

    public void makeDoubleClickOnContentPageTemplate(String arg0) {
        cockpitUtils.doubleClickOnElement(ContentManagementPageLocators.PAGE_CONTENT_TEMPLATE.replace("$1", arg0));

    }

    public void waitForSpinner() {
        try {
            withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(ContentManagementPageLocators.SPINNER)));
        } catch (Exception e) {
            if ($(ContentManagementPageLocators.SPINNER).isVisible()) {
                withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath(ContentManagementPageLocators.SPINNER)));
            }
        }
    }

    public void clickOnActionButtonByName(String arg0) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.CMS_PAGE_ACTIONS_BUTTON.replace("$1", arg0));
    }

    public void clickOnButtonInEditSection(String arg0, String arg1) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.CMS_PAGE_EDIT_BUTTON_IN_SECTION.replace("$1", arg1).replace("$2", arg0));
    }

    public void enterValueInContentTextArea(String arg0) {
        if (arg0.equalsIgnoreCase("saved")) arg0 = Serenity.getCurrentSession().get("returnCMS").toString();
        cockpitUtils.waitForVisibilityWithCount(ContentManagementPageLocators.EDIT_AREA_NAME_TITLE);
        WebElementFacade bottomArea = $(ContentManagementPageLocators.BOTTOM_TEXT_AREA);
        String beforeText = bottomArea.getText();
        Serenity.getCurrentSession().put("returnCMS", beforeText);
        bottomArea.clear();
        bottomArea.sendKeys(arg0);
        String keysPressed = Keys.chord(Keys.CONTROL, Keys.RETURN);
        bottomArea.sendKeys(keysPressed);
    }

    public boolean getActionButtonTitle(String arg0) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until((ExpectedCondition<Boolean>) driver -> {
                WebElement button = $(ContentManagementPageLocators.CMS_SYNCH_BUTTON);
                String enabled = button.getAttribute("title");
                if (enabled.equals(arg0))
                    return true;
                else
                    return false;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnTopLinkByTitle(String arg0) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.TOP_FRAME_ICON_BY_TITLE.replace("$1", arg0));
    }

    public void clickOnSynchButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            String enabled = $(ContentManagementPageLocators.CMS_SYNCH_BUTTON).getAttribute("title");
            if (enabled.equals("Status: Not synchronized"))
                return true;
            else
                return false;
        });
        cockpitUtils.clickOnElement(ContentManagementPageLocators.CMS_SYNCH_BUTTON);
    }

    public void clickOnPaginationButton(String arg0) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.PAGINATION_BUTTON_WITH_NAME.replace("$1", arg0));
    }

    public ArrayList<String> compareContentOfPage(String arg0) {
        WebElement content = findAll(CommonElementsLocators.CONTENT_ON_A_PAGE).get(findAll(CommonElementsLocators.CONTENT_ON_A_PAGE).size() - 1);
        return ContentUtils.compareContent(arg0, content);
    }

    public void enterContentFromAFile(String arg0) {
        copyContentToClipBoard(arg0);
        cockpitUtils.waitForVisibilityWithCount(ContentManagementPageLocators.EDIT_AREA_NAME_TITLE);
        WebElementFacade bottomArea = $(ContentManagementPageLocators.BOTTOM_TEXT_AREA);
        bottomArea.clear();
        bottomArea.sendKeys(Keys.CONTROL + "v");
        String keysPressed = Keys.chord(Keys.CONTROL, Keys.RETURN);
        bottomArea.sendKeys(keysPressed);
    }

    private void copyContentToClipBoard(String fileName) {
        StringBuilder contentFromSource = new StringBuilder(ContentUtils.readContentFile("src/test/resources/content/" + fileName + ".html"));
        StringSelection stringSelection = new StringSelection(contentFromSource.toString());
        Clipboard clpBrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpBrd.setContents(stringSelection, null);
    }

    public void selectButtonInRemovePopUp(String arg0) {
        $(ContentManagementPageLocators.POP_UP_BUTTON.replace("$1", arg0)).click();
    }

    public boolean getMessageLabelVisibleStatus(String arg0, String arg1) {
        WebElementFacade message = $(ContentManagementPageLocators.DISPLAY_LABEL.replace("$1", arg1).replace("$2", arg0));
        return message.isCurrentlyVisible();
    }

    public void clickOnButtonInSectionHeader(String arg0, String arg1) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.BUTTON_ON_SECTION_HEADER.replace("$1", arg1).replace("$2", arg0));
    }

    public void selectTemplateFromModalWindow(String arg0) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.TEMPLATE_FROM_CREATE_MODAL.replace("$1", arg0));
    }

    public void clickOnButtonByName(String arg0) {
        $(ContentManagementPageLocators.POP_UP_BUTTON.replace("$1", arg0)).click();
    }

    public void enterValueInSearchField(String arg0) {
        WebElement searchField = $(ContentManagementPageLocators.WCMS_CONTENT_SEARCH_FIELD);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        //TODO remove after test
        waitABit(1000);
        searchField.sendKeys(arg0);
    }

    public void clickOnSearchButton() {
        WebElement searchButton = $(ContentManagementPageLocators.WCMS_TOP_HEADER_SEARCH_BUTTON);
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        waitForSpinner();
    }

    public boolean getRotatingCarouselPresenceStatus() {
        return $(GlobalElementsLocators.ROTATING_CAROUSEL_MAIN).isCurrentlyVisible();
    }

    public List<String> verifyRotatingCarouselComponents() {
        List<String> results = new ArrayList<>();
        int slotsSize = findAll(GlobalElementsLocators.ALL_CAROUSEL_SLOTS).size();
        int imgSize = findAll(GlobalElementsLocators.ALL_CAROUSEL_ELEMENTS.replace("$1", "img")).size();
        int headerTextSize = findAll(GlobalElementsLocators.ALL_CAROUSEL_ELEMENTS.replace("$1", "h2")).size();
        int textSize = findAll(GlobalElementsLocators.ALL_CAROUSEL_ELEMENTS.replace("$1", "p")).size();
        if (slotsSize != imgSize) results.add("The size of images is not equal the size of slots");
        if (slotsSize != headerTextSize) results.add("The size of header texts is not equal the size of slots");
        if (slotsSize != textSize) results.add("The size of texts is not equal the size of slots");
        return results;
    }

    public void clickOnBannerComponent(String arg0) {
        WebElementFacade component = findAll(ContentManagementPageLocators.CONTENT_EDIT_COMPONENT).get(Integer.valueOf(arg0) - 1);
        cockpitUtils.clickOn(component);
    }

    public void enterContentFromFileToComponentEditor(String arg0) {
        copyContentToClipBoard(arg0);
        cockpitUtils.waitForVisibilityWithCount(ContentManagementPageLocators.WCMS_CONTENT_FRAME);
        String frameId = new String();
        for (WebElementFacade element : findAll("//iframe")) {
            if (element.isCurrentlyVisible()) {
                frameId = element.getAttribute("id");
                break;
            }
        }
        getDriver().switchTo().frame(getDriver().findElement(By.id(frameId)));
        $(ContentManagementPageLocators.WCMS_CONTENT_SOURCE_BUTTON).click();
        WebElementFacade bottomArea = $(ContentManagementPageLocators.BOTTOM_TEXT_AREA);
        bottomArea.clear();
        bottomArea.sendKeys(Keys.CONTROL + "v");
        $(ContentManagementPageLocators.WCMS_CONTENT_SOURCE_BUTTON).click();
        getDriver().switchTo().defaultContent();
    }

    public List<String> compareContentOfBanner(String arg0, int arg1) {
        WebElement content = findAll(GlobalElementsLocators.CONTENT_OF_BANNER).get(arg1 - 1);
        return ContentUtils.compareContent(arg0, content);
    }

    public String getPageTitleOnHomePage() {
        return $(GlobalElementsLocators.PAGE_TITLE_ON_HOME_PAGE).getText();
    }

    public void clickOnSearchButtonInModal() {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.SEARCH_BUTTON_IN_MODAL);
    }

    public void clickOnValueInModalResults(String arg0) {
        cockpitUtils.clickOnElement(ContentManagementPageLocators.MODAL_RESULTS_TABLE_VALUE.replace("$1", arg0));
    }

    public boolean getPresenceStatusOfBannerComponent() {
        return $(ContentManagementPageLocators.BANNER_COMPONENT_GENERAL).isPresent();
    }

    public String getBannerHeaderText() {
        return $(GlobalElementsLocators.BANNER_HEADER_TEXT).getText();
    }

    public String getBannerText() {
        return $(GlobalElementsLocators.BANNER_TEXT).getText();
    }
}
