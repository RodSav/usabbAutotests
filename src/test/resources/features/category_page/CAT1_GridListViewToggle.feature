Feature: CAT-1 - Grid/List View Toggle
  As a customer browsing the site
  I shall be a able to toggle between grid and list views
  for the category landing page

  @Regression
  Scenario: VIR-137.01 Verify that the toggle button is shown above the products
    Given open the site and login
    When open any category
    Then toggle button is shown above the products

  @Regression
  Scenario: VIR-137.02 Verify that the customer can switch the view of products into grid, list
    Given open the site and login
    When open any category
    When click on "grid" toggle button
    Then the page has "grid" view
    When click on "list" toggle button
    Then the page has "list" view

  @Regression
  Scenario: VIR-790.01 Verify that the customer can switch the view of products into grid, list on search page
    Given open the site and login
    When search for "table"
    When click on "grid" toggle button
    Then the page has "grid" view
    When click on "list" toggle button
    Then the page has "list" view

  @Regression
  Scenario: VIR-137.03 Verify that in the grid view the following product info is shown
    Given open the site and login
    When open any category
    When click on "grid" toggle button
    Then the "1" product has "price"
    Then the "1" product has "name"

  @Regression
  Scenario: VIR-137.04 Verify that in the List view the following info is shown
    Given open the site and login
    When open any category
    When click on "list" toggle button
    Then the "1" product has "price"
    Then the "1" product has "name"

  @Regression
  Scenario: VIR-137.05 Verify that the list of products is the same in both views
    Given open the site and login
    When open category with pagination
    When click on "list" toggle button
    When remember product data on plp
    When click on "grid" toggle button
    Then product data on plp is correct