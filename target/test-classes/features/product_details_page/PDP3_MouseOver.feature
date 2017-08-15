Feature: PDP-3 - Mouse Over
  As a customer browsing the site
  I would like to have mouse over zoom for product images on the pdp

  @Regression
  Scenario: VIR-141.01 Verify that the customer can zoom the product image when hover it
    Given open the site and login
    When open category with pagination
    When click on "1" product image in list
    When click on product image
    Then image is moving according to the cursor position