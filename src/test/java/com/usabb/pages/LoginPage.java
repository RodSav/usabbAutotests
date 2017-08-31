package com.usabb.pages;

import com.usabb.locators.CommonElementsLocators;
import com.usabb.locators.LoginLocators;
import com.usabb.utils.EmailUtils;
import com.usabb.utils.PageObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPage extends PageObject {

    public void clickOnCreateButton() {
        $(LoginLocators.ACTION_BUTTON_BACKOFFICE).click();
    }

    public void enterValueInFieldInBackoffice(String arg0, String arg1) {
        $(LoginLocators.INPUT_FIELD_BY_LABEL_BACKOFFICE.replace("$1", arg1)).clear();
        $(LoginLocators.INPUT_FIELD_BY_LABEL_BACKOFFICE.replace("$1", arg1)).sendKeys(arg0);
    }

    public void selectValueInBackOffice(String arg0, String arg1) {
        $(LoginLocators.SPAN_DROP_DOWN.replace("$1", arg0)).click();
    }

    public String getModalWindowHeaderText() {
        return $(CommonElementsLocators.HEADER_TEXT_OF_MODAL).getText();
    }

    public boolean getResetPasswordEmailSentStatus() {
        waitABit(10000);
        String subject = "Forgotten Password";
        Date emailDate = EmailUtils.getLastMessageDateBySubject(subject);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        Date date = new Date();
        return Objects.equals(dateFormat.format(date), dateFormat.format(emailDate));
    }

    public String getResetPasswordLink() {
        waitABit(10000);
        String link = new String();
        String regexp = "(p;<a)[^<>]*(>)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(EmailUtils.getLastMessageHtmlContentBySubject("Forgotten Password"));
        if (matcher.find()) link = matcher.group();
        return link.substring(11, link.length() - 2);
    }
}
