Feature: Save Shopping Cart
  As a contact on the site I would like to save shopping carts, name saved carts and restore saved carts

  @SaveCart
  Scenario: Verify that the shopper can see the saved carts within My Account
    Given open the site and login
    When click on "My Account" link in header
    When click on "Saved Carts" in My Account drop-down
    Then the "Saved Carts" my account page is opened

  @SaveCart
  Scenario: Remove all from saved carts
    Given open the site and login
    When click on "My Account" link in header
    When click on "Saved Carts" in My Account drop-down
    Then delete all saved carts

  @SaveCart @Rail_9819
  Scenario: Verify that cart can be saved and shown on saved carts page
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Check Out" button
    When remember products information on checkout page
    When click on "New Cart" link
    When enter "TestCart1" in the "Name" field
    When enter "TestDescription" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestCart1 was successfully saved" is shown
    When click on "Saved Carts" link
    Then the saved cart "TestCart1" with description "TestDescription" is shown on the page

  @SaveCart @Rail_9821
  Scenario: Verify that saved cart can be restored
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Check Out" button
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

  @SaveCart @Rail_9820
  Scenario: Verify that saved cart can be updated
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Check Out" button
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

  @SaveCart
  Scenario: Verify that saved cart can be removed
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Check Out" button
    When click on "New Cart" button
    When enter "TestRemove" in the "Name" field
    When enter "TestDescriptionRemove" in the "Description" textarea
    When click on "Save" modal button
    Then alert with text "Cart TestRemove was successfully saved" is shown
    When click on "Saved Carts (" button
    When remove "TestRemove" saved cart
    When remove saved cart
    Then the cart "TestRemove" is not presented on saved cart page



