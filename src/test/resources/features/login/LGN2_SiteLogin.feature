Feature: LGN-2 - Site login
  As a customer on the site I would like to login to my account

  @Login
  Scenario: Verify that the shopper can login to the system by entering email and password
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    Then the user is logged in

  @Login
  Scenario: Verify that the shopper is routed to the home page after successful login
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    Then home page is opened