package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/content_management/CNT1_WCMSSiteMaintenance.feature",
        "src/test/resources/features/content_management/CNT2_ComponentMaintenance.feature",
        "src/test/resources/features/content_management/CNT3_Banners.feature",
        "src/test/resources/features/content_management/CNT4_SecurityCompliance.feature",
        "src/test/resources/features/content_management/CNT5_BrandManagement.feature",
        "src/test/resources/features/content_management/CNT6_ContentSlots.feature",
        "src/test/resources/features/content_management/CNT7_QuickLinks.feature",
        "src/test/resources/features/content_management/CNT8_OrderInformation.feature",
        "src/test/resources/features/content_management/CNT9_ContactInformation.feature"
})
public class ContentManagementTestSuite {
}