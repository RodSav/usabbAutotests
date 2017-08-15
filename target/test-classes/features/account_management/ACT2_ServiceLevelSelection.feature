Feature: ACT-2 - Service Level Selection
  As a shopper, I require the ability to view
  the service levels available to me.

  @Regression
  Scenario: VIR-227.01 Verify that the customer can view the service level field right of the contract drop down
    Given open the site and login
    Then the service level drop-down is presented


  @Regression
  Scenario: VIR-227.02 Verify that the shopper can view the following service level options in the dropdown field
    Given open the site and login
    Then the service level drop-down contains following options:
      | Tailgate        |
      | Inside Delivery |
      | Full Service    |

  @Regression
  Scenario: VIR-227.03 Verify that the Tailgate service level option is selected by default
    Given open the site and login
    Then the "Tailgate" option is selected value in service level drop-down

  @Regression
  Scenario: VIR-227.04 Verify that the customer can set any service level from the shown options
    Given open the site and login
    When select "Full Service" in service level drop-down
    Then the "Full Service" option is selected value in service level drop-down
    When select "Inside Delivery" in service level drop-down
    Then the "Inside Delivery" option is selected value in service level drop-down
    When select "Tailgate" in service level drop-down
    Then the "Tailgate" option is selected value in service level drop-down