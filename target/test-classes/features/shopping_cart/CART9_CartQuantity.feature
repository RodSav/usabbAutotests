Feature: CART-9 - Cart Quantity
  As a customer I would like to be shown the quantity of items that I have in the cart

  @Regression
  Scenario: VIR-325.01 Verify that the total quantity of items are shown on the cart
    Given open the site
    # When click on "Sign in" button
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Event Spaces" in navigation menu
    When click on "2" product image in list
    When click on "plus" qty button
    When click on "plus" qty button
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "1" product image in list
    When click on "plus" qty button
    When click on "Add to cart" button
    When click on "Checkout" button
    Then the quantity in the mini cart is "7"

  @Regression
  Scenario: VIR-325.02 Verify that the quantity is based on the item level
    Given open the site
    # When click on "Sign in" button
    When enter "axel.krause@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Event Spaces" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    Then the quantity on checkout page is "2"