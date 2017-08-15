package com.virco;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/product_details_page/PDP1_PDPPricing.feature",
        "src/test/resources/features/product_details_page/PDP2_ImageZoom.feature",
        "src/test/resources/features/product_details_page/PDP3_MouseOver.feature",
        "src/test/resources/features/product_details_page/PDP4_ProductSpecifications.feature",
        "src/test/resources/features/product_details_page/PDP5_Tier1and2Pricing.feature",
        "src/test/resources/features/product_details_page/PDP7_FamilySeries.feature",
        "src/test/resources/features/product_details_page/PDP8_GradeLevel.feature",
        "src/test/resources/features/product_details_page/PDP9_ViewSpecifications.feature",
        "src/test/resources/features/product_details_page/PDP10_Configurations.feature",
        "src/test/resources/features/product_details_page/PDP11_DescriptivePathSelection.feature",
        "src/test/resources/features/product_details_page/PDP12_AddRemovePDP.feature",
        "src/test/resources/features/product_details_page/PDP13_CrossSellProducts.feature",
        "src/test/resources/features/product_details_page/PDP14_UpSellProducts.feature",
        "src/test/resources/features/product_details_page/PDP15_NonStandardColors.feature",
        "src/test/resources/features/product_details_page/PDP16_ToolsAssemblyRequired.feature"
})
public class ProductDetailsPageTestSuite {
}