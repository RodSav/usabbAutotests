Feature: CART-10 - Mini-Cart
  As a customer I would like to see the last 5 line items in the mini cart on hover
  that I've added to my cart and a short description, quantity, price, subtotal,
  total count of items and link to view cart or checkout

  @Regression
  Scenario: VIR-326.01 Verify that the last 5 line items from the cart is shown to the customer if they hover the cart icon
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Event Spaces" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Dining" in navigation menu
    When click on "5" product image in list
    When click on "Add to cart" button
    When click on "Dining" in navigation menu
    When click on "6" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When remember products information on checkout page
    When hover on mini cart
    Then the last 5 items are shown in mini cart

  @Regression
  Scenario: VIR-326.02 Verify that the Cart is shown if click Checkout
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Event Spaces" in navigation menu
    When hover on mini cart
    When click on "Checkout" button
    Then the Cart page is opened

  @Regression
  Scenario: VIR-326.03 Verify that the Cart Mini is closed if click Continue Shopping
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Event Spaces" in navigation menu
    When hover on mini cart
    When click on "Continue" button
    Then the mini cart is not shown

  @TBD @VIR-288
  Scenario: VIR-326.04 Verify that the following information is shown for the line items