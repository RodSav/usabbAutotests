Feature: ACT-17 - My Account View Options
  As a shopper, I require the ability to
  hover over My Account in the header to view the Account Management
  options available to me

  @Regression
  Scenario: VIR-242.01 Verify that the following sub menu My Account menu has following options
    Given open the site and login
    When click on "My Account" link in header
    Then My account menu has following items:
      | Personal Details            |
      | Password                    |
      | Email Address               |
      | Order History               |
      | Payment Details             |
      | Quotes Submitted For Review |
      | Saved Carts                 |
#      | Orders Awaiting approval    |
      | Sign Out                    |

  @Regression
  Scenario Outline: VIR-242.02 Verify that the shopper is moved to the appropriate page after clicking on the sub-menu option
    Given open the site and login
    When click on "My Account" link in header
    When click on "<link>" in My Account drop-down
    Then the "<link>" my account page is opened
    Examples:
      | link                        |
      | Personal Details            |
      | Password                    |
      | Email Address               |
      | Order History               |
      | Payment Details             |
      | Quotes Submitted for Review |
      | Saved Carts                 |
#      | Orders Awaiting approval    |