package com.usabb.locators;

public interface LoginLocators {
    String ACTION_BUTTON_BACKOFFICE = "//img[contains(@src,'createAction')]";
    String INPUT_FIELD_BY_LABEL_BACKOFFICE = "//span[text()='$1']/following-sibling::div//input";
    String SPAN_DROP_DOWN = "//span[text()='$1']";
}
