Feature: LGN-2 - Site login
  As a customer on the site I would like to login to my account

  @Regression
  Scenario: VIR-506.01 Verify that the shopper can login to the system by entering email and password
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    Then the user is logged in

  @Regression
  Scenario: VIR-506.02 Verify that the shopper is routed to the home page after successful login
    Given open "storefront" page
    When enter "anthony.lombardi@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    Then home page is opened

#  @Regression
#  Scenario: VIR-506.03 Verify that the shopper is routed to the Virco.com site after successful logout
#    Given open "storefront" page
#    When enter "ulf.becker@rustic-hw.com" in the "Email Address" field
#    When enter "12341234" in the "Password" field
#    When click on login button
#    When click on "My Account" link in header
#    When click on "Sign Out" in My Account drop-down
#    Then page with "http://virco.com/" is opened