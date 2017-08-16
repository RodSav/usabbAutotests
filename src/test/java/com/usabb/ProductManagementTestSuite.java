package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/product_management/PRD1_ProductImport.feature",
        "src/test/resources/features/product_management/PRD2_ProductGroupings.feature",
        "src/test/resources/features/product_management/PRD3_AdvancedMarketing.feature",
        "src/test/resources/features/product_management/PRD4_ProductConfigurations.feature",
})
public class ProductManagementTestSuite {
}