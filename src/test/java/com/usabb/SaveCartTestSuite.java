package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/shopping_cart/SaveCart.feature"
},
        tags = {
            "@SaveCart"}
)
public class SaveCartTestSuite {
}
