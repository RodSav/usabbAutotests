package com.usabb.pages;

import com.usabb.locators.CommonElementsLocators;
import com.usabb.locators.GlobalElementsLocators;
import com.usabb.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CommonElementsPage extends PageObject {

    public void login(String username, String password) {
        int attempts = 3;
        for (int i = 0; i < attempts; ++i) {
            WebElementFacade loginField = $(CommonElementsLocators.LOGIN_INPUT_FIELD);
            WebElementFacade passwordField = $(CommonElementsLocators.PASSWORD_INPUT_FIELD);
            loginField.clear();
            loginField.sendKeys(username);
            passwordField.clear();
            passwordField.sendKeys(password);
            if (username.equalsIgnoreCase("admin")) $(CommonElementsLocators.LOGIN_BUTTON).click();
            else passwordField.sendKeys(Keys.ENTER);
            try {
                waitABit(1500);
                if ($(CommonElementsLocators.LOGIN_BUTTON).isPresent()) continue;
                else return;
            } catch (Exception ex) {
                return;
            }
        }
    }

    public boolean getLoginFieldDisplayStatus() {
        withTimeoutOf(15, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(CommonElementsLocators.LOGIN_INPUT_FIELD)));
        return $(CommonElementsLocators.LOGIN_INPUT_FIELD).isPresent();
    }

    public boolean getPasswordFieldDisplayStatus() {
        withTimeoutOf(15, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(CommonElementsLocators.PASSWORD_INPUT_FIELD)));
        return $(CommonElementsLocators.PASSWORD_INPUT_FIELD).isPresent();
    }

    public void clickOnButtonWithName(String arg0) {
        $(CommonElementsLocators.BUTTON_WITH_NAME.replace("$1", arg0)).click();
    }

    public void enterTheValueInTheFieldWithLabel(String arg0, String arg1) {
        WebElementFacade field = $(CommonElementsLocators.FIELD_BY_LABEL.replace("$1", arg1));
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(field));
        field.clear();
        field.sendKeys(arg0);
    }

    public String getContentText() {
        return $(CommonElementsLocators.CONTENT_ON_A_PAGE).getText();
    }

    public String getAlertTextMessage() {
        String alertMessage = $(CommonElementsLocators.TEXT_OF_ALERT).getText();
        return alertMessage.substring(alertMessage.indexOf('\n') + 1);
    }

    public void enterTextInTheTextarea(String arg0, String arg1) {
        WebElementFacade textarea = $(CommonElementsLocators.TEXTAREA_BY_LABEL.replace("$1", arg1));
        textarea.clear();
        textarea.sendKeys(arg0);
    }

    public void clickOnButtonInModalWindow(String arg0) {
        WebElementFacade button = $(CommonElementsLocators.BUTTON_IN_MODAL_WITH_NAME.replace("$1", arg0));
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public void openAnyCategoryPage() {
        int countOfCategories = findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS).size();
        Random random = new Random();
        int category = random.nextInt(countOfCategories);
        findAll(GlobalElementsLocators.HEADER_NAVIGATION_MENU_ITEMS).get(category).click();
    }

    public void rememberPageUrl() {
        Serenity.getCurrentSession().put("PageUrl", getDriver().getCurrentUrl());
    }

    public void openSavedUrl() {
        getDriver().get(Serenity.getCurrentSession().get("PageUrl").toString());
    }

    public void enterTextInTheTextareaInModal(String arg0, String arg1) {
        WebElementFacade field = $(CommonElementsLocators.FIELD_BY_LABEL_MODAL.replace("$1", arg1));
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(field));
        field.clear();
        field.sendKeys(arg0);
    }

    public String getValidationMessageOfFieldWithLabel(String arg1) {
        return $(CommonElementsLocators.FIELD_ALERT_BY_LABEL.replace("$1", arg1)).getText();
    }
}
