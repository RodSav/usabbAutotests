package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/login/LGN2_SiteLogin.feature",
        "src/test/resources/features/login/LGN3_PasswordReset.feature"
})
public class LoginTestSuite {
}