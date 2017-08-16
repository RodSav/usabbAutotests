package com.usabb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/global_elements/GE1_Breadcrumbs.feature",
        "src/test/resources/features/global_elements/GE2_Badges.feature",
        "src/test/resources/features/global_elements/GE3_SocialLinks.feature",
        "src/test/resources/features/global_elements/GE4_Versign.feature",
        "src/test/resources/features/global_elements/GE5_BetterBusinessBureau.feature",
        "src/test/resources/features/global_elements/GE6_PaymentBadges.feature",
        "src/test/resources/features/global_elements/GE7_TopCategoryNavigation.feature",
        "src/test/resources/features/global_elements/GE9_ServiceLevelGlobalHeader.feature",
        "src/test/resources/features/global_elements/GE10_OrderTrackingPageLink.feature",
        "src/test/resources/features/global_elements/GE11_PrivacyTermsLink.feature",
        "src/test/resources/features/global_elements/GE12_Copyright.feature",
        "src/test/resources/features/global_elements/GE13_GlobalSearchContract.feature",
        "src/test/resources/features/global_elements/PLD_GlobalElements_Footer.feature"
})
public class GlobalElementsTestSuite {
}