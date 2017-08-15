Feature: GE-5 - Better Business Bureau
  As a user navigating the site the system should
  display the better business bureau (BBB) rating
  to the user in the global footer navigation

  @Regression
  Scenario: VIR-119.01 Verify that the BBB rating is shown in the footer
    Given open the site and login
    Then badge "bbb" is shown in footer

  @Regression
  Scenario: VIR-119.02 Verify that the proper BBB rating is shown to the customer
    Given open the site and login
    Then badge "bbb" is shown in footer