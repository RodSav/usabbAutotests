Feature: CAT-4 - Page Navigation
  As a customer I would like to be shown the first page,
  previous page, next page, last page as a navigation option

  @Regression
  Scenario: VIR-139.01 Verify that the first/last/next pages are shown above and below the list of products
    Given open the site and login
    When open category with pagination
    Then the last/next pages are shown above and below the list of products
    When click on "next" pagination button
    Then the first/previous pages are shown above and below the list of products

  @Regression
  Scenario: VIR-139.02 Verify that the customer is able to navigate through the previous, next, last pages on Category page
    Given open the site and login
    When open category with pagination
    When click on "next" pagination button
    Then the value in pagination input field is "2"
    When click on "previous" pagination button
    Then the value in pagination input field is "1"
    When click on "last" pagination button
    Then the last page is shown
    When click on "first" pagination button
    Then the first page is shown

  @Regression
  Scenario: VIR-139.03 Verify that the customer is able to navigate through the previous, next, last pages on Search result page
    Given open the site and login
    When search for "chair"
    When click on "next" pagination button
    Then the value in pagination input field is "2"
    When click on "previous" pagination button
    Then the value in pagination input field is "1"
    When click on "last" pagination button
    Then the last page is shown
    When click on "first" pagination button
    Then the first page is shown

  @Regression
  Scenario: VIR-139.04 Verify that the previous/ first page is disabled, when customer is on the first pages for Category page
    Given open the site and login
    When open category with pagination
    Then the value in pagination input field is "1"
    Then the previous/first page button is disabled

  @Regression
  Scenario: VIR-139.05 Verify that the previous/ first page is disabled, when customer is on the first pages for Search result page
    Given open the site and login
    When search for "chair"
    Then the value in pagination input field is "1"
    Then the previous/first page button is disabled

  @Regression
  Scenario: VIR-139.06 Verify that the next/last page button is disabled, when customer is on the last pages for Category page
    Given open the site and login
    When open category with pagination
    When click on "last" pagination button
    Then the next/last page button is disabled

  @Regression
  Scenario: VIR-139.07 Verify that the next/last page button is disabled when customer is on the last page for Search result page
    Given open the site and login
    When search for "chair"
    When click on "last" pagination button
    Then the next/last page button is disabled


