Feature: PDP-12 - Add/Remove PDP
  As a customer I would like to configure my
  product purchase including the quantity, and have the ability to add my product to cart.

  @Regression
  Scenario: VIR-268.01 Verify that the customer can select the quantity of items before adding to the cart on the product details page
    Given open the site and login
    When open category with pagination
    And click on "1" product image in list
    Then quantity field is presented on pdp

  @Regression
  Scenario: VIR-268.02 Verify that the customer can add quantity by dropdown
    Given open the site and login
    When open category with pagination
    And click on "1" product image in list
    And select "10" in qty dropdown
    Then quantity on pdp is "10"

  @Regression
  Scenario: VIR-268.03 Verify that the customer can add the quantity manually
    Given open the site and login
    When open category with pagination
    And click on "1" product image in list
    And change product quantity to "5"
    Then quantity on pdp is "5"

  @Regression
  Scenario: VIR-268.04 Verify that the quantity is automatically moved to 1 if customer enters 0
    Given open the site and login
    When open category with pagination
    And click on "1" product image in list
    And change product quantity to "0"
    Then quantity on pdp is "1"

  @Regression
  Scenario: VIR-268.05 Verify that the customer is not able to add more items than 9,999 in one order
    Given open the site and login
    When open category with pagination
    And click on "1" product image in list
    And change product quantity to "99999"
    Then quantity on pdp is "9999"

