Feature: ACT-19 - Static Email Address
  As a shopper, I require the ability
  to view my email address as non editable

  @Regression
  Scenario: VIR-244.01 Verify that the shopper can see their email address within Email in My Account Menu
    Given open the site and login
    When click on "My Account" link in header
    When click on "Email Address" in My Account drop-down
    Then the data in "Email Address" field is "anthony.lombardi@rustic-hw.com"


  @Regression
  Scenario: VIR-244.02 Verify that the email address is not editable
    Given open the site and login
    When click on "My Account" link in header
    When click on "Email Address" in My Account drop-down
    Then the field "Email Address" is not editable

