package com.virco.locators;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
public interface LoginLocators {
    String ACTION_BUTTON_BACKOFFICE = "//img[contains(@src,'createAction')]";
    String INPUT_FIELD_BY_LABEL_BACKOFFICE = "//span[text()='$1']/following-sibling::div//input";
    String SPAN_DROP_DOWN = "//span[text()='$1']";
}
