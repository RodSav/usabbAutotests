Feature: CART-3 - Product Links
  As a customer I would like to see a product link that will
  direct me back to the product details page and the continue
  shopping button that will take me back to the last product I was viewing

  @Regression
  Scenario: VIR-320.01 Verify that the link to the added product to the cart is shown to the shopper on the cart page
    Given open "storefront" page
#    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When open category with pagination
    When click on "1" product image in list
    When remember product data on pdp
    When click on "Add to cart" button
    When click on "Checkout" button
    Then the link of product is shown on Cart page

  @Regression
  Scenario: VIR-320.02 Verify that clicking on the link the shopper is moved to the product page
    Given open "storefront" page
#    When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When open category with pagination
    When click on "1" product image in list
    When remember product data on pdp
    When click on "Add to cart" button
    When click on "Checkout" button
    When click on added product on Cart page
    Then added product page is shown

  @Regression
  Scenario: VIR-320.03 Verify that the shopper can continue the shopping by clicking on Continue Shopping page
    Given open "storefront" page
#    When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    And open "storefront" page
    When click on "Event Spaces" in navigation menu
    When open "cart" storefront page
    When click on "Continue" button
    Then appropriate "Event Spaces" page is opened

  @Regression
  Scenario: VIR-320.04 Verify that the shopper is moved to the last product page which was viewed
    Given open "storefront" page
#    When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When open category with pagination
    When click on "1" product image in list
    When remember product data on pdp
    When click on "Add to cart" button
    When click on "Checkout" button
    When click on "Continue" button
    Then added product page is shown
