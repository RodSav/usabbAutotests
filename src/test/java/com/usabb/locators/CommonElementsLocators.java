package com.usabb.locators;

public interface CommonElementsLocators {

    String LOGIN_INPUT_FIELD = "//input[contains(@name,'username')]";
    String PASSWORD_INPUT_FIELD = "//input[contains(@name,'password')]";
    String LOGIN_BUTTON = "(//form[@id='loginForm']//*[contains(text(),'Login')])[1]";
    String BUTTON_WITH_NAME = "(//*[contains(text(),'$1')])[1]";
    String FIELD_BY_LABEL = "//label[contains(text(),'$1')]/following-sibling::input";
    String FIELD_ALERT_BY_LABEL = "//label[contains(text(),'$1')]/following-sibling::div[@class='help-block']/span";
    String FIELD_BY_LABEL_MODAL = "//div[@id='cboxContent']//label[contains(text(),'$1')]/following-sibling::input";
    String SELECT_WITH_LABEL = "//label[contains(text(),'$1')]/following-sibling::div//span";
    String TEXTAREA_BY_LABEL = "//label[contains(text(),'$1')]/following-sibling::textarea";
    String CONTENT_ON_A_PAGE = "//div[@class='content']";
    String WRONG_LOGIN_ERROR_MESSAGE = "//span[contains(@class,'loginErrorLabel')]";
    String TEXT_OF_ALERT = "//button[@data-dismiss='alert']/..";
    String BUTTON_IN_MODAL_WITH_NAME = "(//button[contains(text(),'$1')])";
    String DELETE_BUTTON_IN_MODAL = "(//div[@id='cboxLoadedContent']//button)[1]";
    String EMPTY_CONTENT_MESSAGE = "//div[contains(@class,'content-empty')]";
    String HEADER_TEXT_OF_MODAL = "//span[@class='headline-text']";
    String CBOX_CONTRACT_EXPIRED_CLOSE_BUTTON = "//*[@id='cboxClose']";
}
