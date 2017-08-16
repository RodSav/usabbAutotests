Feature: GE-1 - Breadcrumbs
  As a user the navigating the site the system will
  display the breadcrumb path to me based off of
  the current site taxonomy and my current navigation.

  @Regression
  Scenario: VIR-115.01 Verify that the breadcrumb path shows the navigation from the root to the child nodes
    Given open the site and login
    When click on "My Account" link in header
    When click on "Password" in My Account drop-down
    Then breadcrumb is "Home Password"

  @Regression
  Scenario: VIR-115.02 Verify that the shopper is moved to the appropriate page after clicking on the breadcrumb node
    Given open the site and login
    When click on "My Account" link in header
    When click on "Email Address" in My Account drop-down
    When click on the "1" breadcrumb
    Then home page is opened

  @Regression
  Scenario: VIR-115.05 Verify that the opened page's name in breadcrumb is shown as a text
    Given open the site and login
    When click on "My Account" link in header
    When click on "Email Address" in My Account drop-down
    Then the page "Profile" is shown in breadcrumb as text

  @Manual
  Scenario: VIR-115.03 Verify that the breadcrumb conventions are determined by site taxonomy

  @Manual
  Scenario: VIR-115.04 Verify that the breadcrumb is shown below main menu

  @Manual
  Scenario: VIR-115.06 Verify that the breadcrumb nodes are separated by "/"