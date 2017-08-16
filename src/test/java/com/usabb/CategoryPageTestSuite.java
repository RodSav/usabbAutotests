package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/category_page/CAT1_GridListViewToggle.feature",
        "src/test/resources/features/category_page/CAT2_NumerationDisplay.feature",
        "src/test/resources/features/category_page/CAT3_Pagination.feature",
        "src/test/resources/features/category_page/CAT4_PageNavigation.feature",
        "src/test/resources/features/category_page/CAT5_CategoryNavigation.feature"
})
public class CategoryPageTestSuite {
}