Feature: GE-6 - Payment Badges
  As a user navigating the site the system
  should show the accepted payment types for the user in the global footer.

  @Regression
  Scenario Outline: VIR-120.01 Verify that the following accepted payment types are shown to the customer in the footer of the site
    Given open the site
    Then badge "<badge>" is shown in footer
    Examples:
      | badge           |
      | Amex-icon       |
      | Visa-icon       |
      | Mastercard-icon |
      | Discaver-icon   |
      | check           |
      | po              |