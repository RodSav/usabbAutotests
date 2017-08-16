Feature: PDP-14 - Up-Sell Products
  As a customer I would like to be shown
  products that I can substitute for my current purchase

  @Regression
  Scenario: VIR-144.01 Verify that the similar products are shown to the customer
    Given open the site and login
    When open pdp with product that has "Similar products"
    Then "Up-Sell" products are shown

  @Regression
  Scenario: VIR-144.02 Verify that the customer can add the similar product to the cart
    Given open the site and login
    When open pdp with product that has "Similar products"
    When click on "1" product in "Recommended products" section
    When click on product link in pop-up
    Then pdp of clicked in pop-up product is opened

  @Regression
  Scenario: VIR-483 Missing product price in Up/Cross sell pop-up
    Given open the site and login
    When open pdp with product that has "Similar products"
    When click on "1" product in "Recommended products" section
    Then similar product information is shown in modal

