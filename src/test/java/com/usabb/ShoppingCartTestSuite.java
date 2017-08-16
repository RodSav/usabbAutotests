package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ${Timonov_Viacheslav} on 5/24/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/shopping_cart/CART3_ProductLinks.feature",
        "src/test/resources/features/shopping_cart/CART4_DeleteSKU.feature",
        "src/test/resources/features/shopping_cart/CART10_MiniCart.feature",
        "src/test/resources/features/shopping_cart/CART2_CartData.feature",
        "src/test/resources/features/shopping_cart/CART9_CartQuantity.feature"
})
public class ShoppingCartTestSuite {
}
