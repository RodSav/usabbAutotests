Feature: Save To List
  As a contact on the site I would like to add products to wish lists, name saved lists and restore saved lists to cart

#  @SaveList
#  Scenario: Verify that the shopper can see the saved lists within My Account
#    Given open the site and login
#    When click on "My Account" link in header
#    When click on "Saved Lists" in My Account drop-down
#    Then the "Saved Lists" my account page is opened

#  @SaveCart
#  Scenario: Remove all from saved carts
#    Given open the site and login
#    When click on "My Account" link in header
#    When click on "Saved Carts" in My Account drop-down
#    Then delete all saved carts

  @SaveList
  Scenario: Verify that product can be added to new wishlist and list is shown on saved lists page
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When remember product data on pdp
    When click on "Add to Wishlist" button
    When select "Create a Wishlist" radio button
    When enter "WishListName1" in the "Create a Wishlist" field in modal
    When click on "Add to Wishlist" modal button
    When click on "View Wishlist" modal button
    Then saved product is present in list
    When click on "My Account" link in header
    When click on "Saved Lists" in My Account drop-down
    Then the saved list "WishListName1" is shown on the page

  @SaveList
  Scenario: Verify that saved list can be restored to cart
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When click on "Add to Wishlist" button
    When select "Create a Wishlist" radio button
    When enter "WishListName2" in the "Create a Wishlist" field in modal
    When click on "Add to Wishlist" modal button
    When click on "View Wishlist" modal button
    When remember products information on list page
    When click on "Convert to cart" button
    When click on "Restore" modal action button
    Then products on restored checkout page are correct

    ####

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

  @SaveCart @Rail_13126
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



