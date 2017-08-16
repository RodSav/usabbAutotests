Feature: PDP-13 - Cross-Sell Products
  As a customer I would like to be shown
  the recommended products that would compliment my current purchase

  @Regression
  Scenario: VIR-143.01 Verify that the recommended products are shown to the customer
    Given open the site and login
    When open pdp with product that has "This Product Goes Well With"
    Then "Cross-Sell" products are shown