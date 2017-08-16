Feature: ACT-21 - View Saved Carts
  As a shopper, I require the ability to view my saved carts within my account

  @Regression
  Scenario: VIR-246.01 Verify that the shopper can see the saved carts within My Account
    Given open the site and login
    When click on "My Account" link in header
    When click on "Saved Carts" in My Account drop-down
    Then the "Saved Carts" my account page is opened

  @Regression
  Scenario: VIR-246.02 Remove all from saved carts
    Given open the site and login
    When click on "My Account" link in header
    When click on "Saved Carts" in My Account drop-down
    Then delete all saved carts

  @Regression
  Scenario: VIR-246.03 Verify that the saved cart is shown on the saved carts page
    Given open the site and login
    When open category with pagination
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When remember products information on checkout page
    When click on "New Cart" button
    When enter "TestSaved" in the "Name" field
    When enter "TestDescription" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestSaved was successfully saved" is shown
    When click on "Saved Carts (" button
    Then the saved cart "TestSaved" with description "TestDescription" is shown on the page

  @Regression
  Scenario: VIR-246.04 Verify that the products and their selected quantities are shown at the saved cart page
    Given open the site and login
    When open category with pagination
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When remember products information on checkout page
    When click on "New Cart" button
    When enter "TestProducts" in the "Name" field
    When enter "TestProductsDescription" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestProducts was successfully saved" is shown
    When click on "Saved Carts (" button
    When click on "TestProducts" saved cart
    Then products on saved cart are correct

  @Regression
  Scenario: VIR-246.05 Verify that saved cart can be restored
    Given open the site and login
    When open category with pagination
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When remember products information on checkout page
    When click on "New Cart" button
    When enter "TestRestore" in the "Name" field
    When enter "TestRestoreDescription" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestRestore was successfully saved" is shown
    When click on "My Account" link in header
    When click on "Saved Carts" in My Account drop-down
    When click on "TestRestore" saved cart
    When restore the cart
    Then products on checkout page are correct

  @Regression
  Scenario: VIR-246.06 Verify that saved cart can be updated
    Given open the site and login
    When open category with pagination
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When click on "New Cart" button
    When enter "TestUpdate" in the "Name" field
    When enter "TestDescriptionUpdate" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestUpdate was successfully saved" is shown
    When click on "Saved Carts (" button
    When click on "TestUpdate" saved cart
    When click on "Edit" button
    When enter "TestUpdateTest" in the "Name" field
    When enter "TestDescriptionUpdateTest" in the "Description" textarea
    When save edited cart
    Then alert with text "Cart TestUpdateTest was successfully updated" is shown
    When click on "Back to Saved Carts" button
    Then the cart "TestUpdateTest" is presented on saved cart page
    Then the description of "TestUpdateTest" cart is "TestDescriptionUpdateTest"

  @Regression
  Scenario: VIR-246.07 Verify that saved cart can be removed
    Given open the site and login
    When open category with pagination
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    When click on "New Cart" button
    When enter "TestRemove" in the "Name" field
    When enter "TestDescriptionRemove" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestRemove was successfully saved" is shown
    When click on "Saved Carts (" button
    When remove "TestRemove" saved cart
    When remove saved cart
    Then the cart "TestRemove" is not presented on saved cart page


  @TBD
  Scenario: VIR-440.01 The cart q-ty is not based on the item level for the saved carts
