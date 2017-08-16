package com.virco.steps.serenity;

import com.virco.pages.AccountManagementPage;
import com.virco.pages.GlobalElements;
import com.virco.pages.LoginPage;
import com.virco.pages.ProductDetailsPage;
import com.virco.utils.SoftAssert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
public class LoginUserSteps extends ScenarioSteps {

    LoginPage loginPage;
    AccountManagementPage managementPage;
    GlobalElements globalElements;
    ProductDetailsPage productDetailsPage;

    @Step
    public void clickOnCreateButton() {
        loginPage.clickOnCreateButton();
    }

    @Step
    public void enterValueInFieldInBackoffice(String arg0, String arg1) {
        loginPage.enterValueInFieldInBackoffice(arg0, arg1);
    }

    @Step
    public void verifyPresenceOfValueInTheTableForFirstColumn(String arg0) {
        Assert.assertTrue("Can't find the " + arg0 + " in the list", managementPage.checkCreatedOrderInTheList(arg0));
    }

    @Step
    public void selectValueInBackOffice(String arg0, String arg1) {
        loginPage.selectValueInBackOffice(arg0, arg1);
    }

    @Step
    public void verifyThatTheResetPasswordModalIsShown() {
        SoftAssert.clearOldResults();
        Assert.assertTrue("The Reset password modal is not shown", "Reset Password".equals(loginPage.getModalWindowHeaderText()));
        SoftAssert.assertTrue("Missed input email field", globalElements.verifyFieldWithLabelPresenceStatus("Email Address"));
        SoftAssert.assertTrue("Reset password button is missed", globalElements.getPresenceOfTheButton("Reset Password"));
        SoftAssert.assertTrue("Reset password button is missed", productDetailsPage.getDisplayStatusOfCloseButton());
        SoftAssert.assertAll();
    }

    @Step
    public void verifyEmailOfResetPassword() {
        Assert.assertTrue("The email with the reset link ins not sent", loginPage.getResetPasswordEmailSentStatus());
    }

    @Step
    public void openResetLinkInEmail() {
        String url = loginPage.getResetPasswordLink();
        getDriver().get(url);
    }
}
