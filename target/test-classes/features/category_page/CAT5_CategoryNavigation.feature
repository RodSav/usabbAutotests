Feature: CAT-5 - Category Navigation
  As a customer is scrolling down, show "Top" button
  for user to click and anchor the customer back to the top of the page

  @Regression
  Scenario: VIR-151.01 Verify that the "Top" button flows from the centered middle to the bottom on moving/scrolling the page
    Given open the site and login
    When open category with pagination
    When scroll "down" page for the "60" percent
    Then the Top button is centered middle to the bottom

  @Regression
  Scenario: VIR-151.02 Verify that the "Top" button is shown to the user when they scroll down and menu is not visible
    Given open the site and login
    When open any category
    When scroll "down" page until top button visible status will be changed
    Then the Top button is shown
    Then header is not visible

  @Regression
  Scenario: VIR-151.03 Verify that "Top" button moves user to the top of the page
    Given open the site and login
    When open category with pagination
    When scroll "down" page for the "50" percent
    When click on Top button
    Then the "top" of the page is displayed
    Then the Top button is not shown

  @Regression
  Scenario: VIR-151.04 Verify that the "Top" button is shown to the user on the Category page
    Given open the site and login
    When open category with pagination
    When scroll "down" page for the "70" percent
    Then the Top button is shown

  @Ignore
  Scenario: VIR-151.05 Verify that the "Top" button is shown to the user on the Search result page
    Given open the site and login
    When search for "table"
    When scroll "down" page for the "70" percent
    Then the Top button is shown