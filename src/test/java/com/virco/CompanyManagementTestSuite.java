package com.virco;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/company_management/CMP1_CustomerRoleSupport.feature",
        "src/test/resources/features/company_management/CMP2_AccountHierarchy.feature",
        "src/test/resources/features/company_management/CMP3_BuyingAuthorities.feature",
        "src/test/resources/features/company_management/CMP5_ManageSchoolCategories.feature",
        "src/test/resources/features/company_management/CMP6_ManageSchoolColors.feature",
        "src/test/resources/features/company_management/CMP7_SchoolConsistency.feature"
})
public class CompanyManagementTestSuite {
}