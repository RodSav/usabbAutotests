Feature: Smoke Check List
  https://zaelab.atlassian.net/wiki/display/VIR/Smoke+Check+List

  @Smoke @Rail_105
  Scenario: SMOKE1.04 Verify that productmanager can login to the PIM
    Given open "PIM" page
    When login as "productmanager"
    Then productmanager has logged in

# To refactor after PDP will be implemented:

  @Smoke @Precondition
  Scenario: Preconditions for PIM tests
    Given open the site and login
    When click on "Screwdrivers" in navigation menu
    When click on "1" product image in list
    When remember product data on pdp
    Then remember page url

# To refactor after PDP will be implemented:

  @Smoke @Rail_106 @Rail_107
  Scenario: SMOKE1.05-06 Verify that productmanager can change product description
    Given open "PIM" page
    When login as "productmanager"
    When select "Staged" product catalog
    When search for saved code in cockpit
    When select "1" product from products list
    When click on "Open in Edit Area" top link
    When remember value in "Identifier:" field
    When enter "THEREISTHEPRODUCTFORTHESMOKECHECK" in "Identifier:" editor field
    When start product catalog synchronization
    Then product is synchronized

  @Smoke  @Rail_112
  Scenario: SMOKE1.11 Verify the changes of the product from step Scenario: SMOKE1.05
    Given open the site and login
    When open saved url
    Then product name is "THEREISTHEPRODUCTFORTHESMOKECHECK"

  @Smoke @Rail_108
  Scenario: SMOKE1.07 Verify that productmanager can logout from PIM
    Given open "PIM" page
    When login as "productmanager"
    When logout from CMS
    Then login page is opened

  @Smoke @Rail_102
  Scenario: SMOKE1.01 Verify that cmsmanager can login to the CMS
    Given open "CMS" page
    When login as "cmsmanager"
    Then cmsmanager has logged in

  @Smoke @Rail_103
  Scenario: SMOKE1.02 Verify that cmsmanager can change the page view
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "Empty" content
    When double click on "searchEmpty" content page
    When click on "Edit" button in "Middle" slot
    When enter "EmptySearchTest" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"

  @Smoke @Rail_104
  Scenario: SMOKE1.03 Verify that cmsmanager can logout from CMS
    Given open "CMS" page
    When login as "cmsmanager"
    When logout from CMS
    Then login page is opened

  @Smoke @Rail_109
  Scenario: SMOKE1.08 Verify that user can open storefront
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    Then home page is opened

  @Smoke @Rail_110
  Scenario: SMOKE1.09 Verify that user can login to the storefront
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    Then the user is logged in

  @Smoke @Rail_111
  Scenario: SMOKE1.10 Verify the changes at the page from step SMOKE1.02
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When search for "ITISTHECHECKFORCMS"
    Then "EmptySearchTest" content is opened

  @Smoke  @Rail_113
  Scenario: SMOKE1.12 Verify that product can be added to the cart
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When open category with pagination
    When click on "1" product image in list
    When click on "Add to cart" button
    Then "Cart PDP" modal window is opened

  @Smoke  @Rail_115
  Scenario: SMOKE1.13 Verify that customer can create the order
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When open any category
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Check Out" button
    When click on "Check Out" button
    When select "Card Payment" radio button
    When click on "Next" button
    When select "United States" in "Country" drop-down
    When select "Ms" in "Title" drop-down
    When enter "testName" in the "First Name" field
    When enter "testLastName" in the "Last Name" field
    When enter "testName" in the "First Name" field
    When enter "test address line 1" in the "Address Line 1" field
    When enter "test City" in the "City" field
    When select "Alabama" in "State / Province" drop-down
    When enter "01234" in the "Zip / Postal Code" field
    When enter "0123456789" in the "Phone number" field
    When click on "Next" button
    When click on "Next" button
    When select "Visa" in "Card type" drop-down
    When enter "4111111111111111" in the "Card number" field
    When select "09" in "Expiry date*" drop-down
    When select "2024" in "Expiry" drop-down
    When enter "032" in the "Card Verification Number" field
    When click on "Next" button
    When accept T&C on checkout
    When click on "Place Order" button
    Then the order is created

  @Smoke @Rail_1065
  Scenario: SMOKE1.14 Verify that shopper can logout from the storefront
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on sign out in header
    Then home page is opened

  @Smoke   @Rail_116
  Scenario: SMOKE1.15 Verify that admin can login to the Backoffice
    Given open "BackOffice" page
    When login as "admin"
    Then the user has logged in backoffice

  @Smoke  @Rail_117
  Scenario: SMOKE1.16 Verify the created order from step SMOKE1.13 in backoffice
    Given open "BackOffice" page
    When login as "admin"
    When click on "Order" in backoffice
    When click on "Orders" in backoffice
    Then created order is presented in the list

  @Smoke  @Rail_1066
  Scenario: SMOKE1.17 Verify that admin can logout from the backoffice
    Given open "BackOffice" page
    When login as "admin"
    When click on "Logout" link in backoffice
    Then login page is opened

  @Smoke  @Rail_118
  Scenario: SMOKE1.18 Delete test data/changes created on steps 2, 5, 15
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "Empty" content
    When double click on "searchEmpty" content page
    When click on "Edit" button in "Middle" slot
    When enter "EmptySearch" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"
    Given open "PIM" page
    When login as "productmanager"
    When select "Staged" product catalog
    When click on advanced search button
    When select "Product" in type combobox
    When perform products search
    When select "1" product from products list
    When enter "saved" in "Identifier:" editor field
    When start product catalog synchronization
    Then product is synchronized