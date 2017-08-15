Feature: PDP-16 - Tools & Assembly Required
  As a customer if i'm ordering a product that requires assembly
  I would like to see or "Tools and Assembly Required" or "assembly required" on the pdp

  @Regression
  Scenario: VIR-146.01 Verify that "Assembly Required" is shown to the customer, if the products requires assembly
    Given open the site and login
    When open pdp with product that has Assembly Required attribute "None"
    Then Tools assembly required text is "None"

  @Regression
  Scenario: VIR-146.02 Verify that "Assembly Required" is not shown to the customer, if the products does not require assembly
    Given open the site and login
    When open pdp with product that has Assembly Required attribute ""
    Then Tools assembly required text is not presented