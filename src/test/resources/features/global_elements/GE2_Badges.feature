Feature: GE-2 - Badges
  As a user navigating the site the system
  should display the applicable site specific badges
  as determined by the business in the main global navigation

  @Regression
  Scenario: VIR-116.01 Verify that the badges (logo) is shown for the customer at the header
    Given open the site and login
    Then the logo is shown for the customer at the header

  @Regression
  Scenario: VIR-116.02 Verify that the clicking on badges the system opens the Home page
    Given open the site and login
    When search for "table"
    When click on logo
    Then home page is opened