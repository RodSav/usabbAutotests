package com.virco;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ${Timonov_Viacheslav} on 4/20/17.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/account_management/ACT1_DefaultContract.feature",
        "src/test/resources/features/account_management/ACT2_ServiceLevelSelection.feature",
        "src/test/resources/features/account_management/ACT3_ServiceLevelPricing.feature",
        "src/test/resources/features/account_management/ACT4_VircoRep.feature",
        "src/test/resources/features/account_management/ACT5_ContractAvailable.feature",
        "src/test/resources/features/account_management/ACT6_ContractExpired.feature",
        "src/test/resources/features/account_management/ACT7_ChiefContractDetailsView.feature",
        "src/test/resources/features/account_management/ACT8_SupportTickets.feature",
        "src/test/resources/features/account_management/ACT9_ContractPricing.feature",
        "src/test/resources/features/account_management/ACT10_OrderHistoryDateRange.feature",
        "src/test/resources/features/account_management/ACT11_ViewOrdersShopperECC.feature",
        "src/test/resources/features/account_management/ACT12_ViewOrdersAdmin.feature",
        "src/test/resources/features/account_management/ACT13_PurchaseHistory.feature",
        "src/test/resources/features/account_management/ACT14_Reorder.feature",
        "src/test/resources/features/account_management/ACT15_CustomerManagement.feature",
        "src/test/resources/features/account_management/ACT16_CSRMassSetUp.feature",
        "src/test/resources/features/account_management/ACT17_MyAccountViewOptions.feature",
        "src/test/resources/features/account_management/ACT18_TrackingInformation.feature",
        "src/test/resources/features/account_management/ACT19_StaticEmailAddress.feature",
        "src/test/resources/features/account_management/ACT21_ViewSavedCarts.feature",
        "src/test/resources/features/account_management/ACT22_ViewPersonalDetails.feature"
})
public class AccountManagementTestSuite {
}