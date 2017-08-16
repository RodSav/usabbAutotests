Feature: CAT-3 - Pagination
  As a customer I would like to be able to see the pagination displayed
  and be able to navigate based on the numeration displayed or
  by entering the page number in a field.

  @Regression
  Scenario: VIR-138.01 Verify that the pagination is shown above and below the list of products
    Given open the site and login
    When open category with pagination
    Then the pagination is shown above and below the list of products

  @Regression
  Scenario: VIR-592.01 Verify that the pagination is shown above and below the list of products on search page
    Given open the site and login
    When search for "table"
    Then the pagination is shown above and below the list of products

  @Regression
  Scenario: VIR-138.02 Verify that the pagination is suppressed, if only one page of products exist
    Given open the site and login
    When search for "4002951"
    Then the pagination is suppressed

  @Regression
  Scenario: VIR-138.03 Verify that the last page is shown when customer enters the page number that is bigger than the existed one
    Given open the site and login
    When open category with pagination
    When enter "1000" in pagination page number field
    Then the last page is shown

  @Regression
  Scenario: VIR-138.04 Verity that the first page is shown when customer enters the 0
    Given open the site and login
    When open category with pagination
    When click on "next" pagination button
    When enter "0" in pagination page number field
    Then the first page is shown

  @Regression
  Scenario: VIR-138.05 Verify that any other data can't be entered except integer
    Given open the site and login
    When open category with pagination
    When enter "1" in pagination page number field
    When enter "test" in pagination page number field
    Then the value in pagination input field is "1"

  @Regression
  Scenario: VIR-138.06 Verify that any other data can't be entered except integer using context paste
    Given open the site and login
    When open category with pagination
    When enter "1" in pagination page number field
    When paste "test" using context menu in pagination page number field
    Then the value in pagination input field is "1"

  @Regression
  Scenario: VIR-138.07 Verify that the sorting/filtering is not cleared while navigating through the pages in the current way
    Given open the site and login
    When open category with pagination
    When select "Top Rated" in sorting drop-down
    When enter "2" in pagination page number field
    Then selected option in sorting drop-down menu is "Top Rated"

  @Regression
  Scenario: VIR-138.08 Verify that the customer is able to enter the page number to navigate into it on the Category page
    Given open the site and login
    When open category with pagination
    When click on "2" pagination button
    Then the value in pagination input field is "2"
    When enter "1" in pagination page number field
    Then the value in pagination input field is "1"

  @Regression
  Scenario: VIR-138.09 Verify that the customer is able to enter the page number to navigate into it on the Search result page
    Given open the site and login
    When search for "chair"
    When click on "2" pagination button
    Then the value in pagination input field is "2"
    When enter "1" in pagination page number field
    Then the value in pagination input field is "1"