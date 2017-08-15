Feature: CART-4 - Delete SKU
  As a customer I would like to be able to delete a record from my cart

  @Regression
  Scenario: VIR-321.01 Verify that the delete button is shown per each record from the cart
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "Dining" in navigation menu
    When click on "3" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    Then delete button is shown per each record


  @Regression
  Scenario: VIR-321.02 Verify that the deleted record is removed from the cart and total is recalculated appropriately
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "Dining" in navigation menu
    When click on "3" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When remember products information on checkout page
    When remove "1" product from cart
    Then deleted record is removed from the cart
    Then total is recalculated appropriately

  @Regression
  Scenario: VIR-321.03 Verify that the recalculated total is shown at the mini cart on the Cart badge
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "21st Century Classroom" in navigation menu
    When click on "2" product image in list
    When click on "Add to cart" button
    When click on "Dining" in navigation menu
    When click on "3" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When remember products information on checkout page
    When remove "1" product from cart
    Then the recalculated total is shown at the mini cart