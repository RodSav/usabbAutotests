Feature: GE-4 - Versign
  As a user navigating the site the system should
  show the Verisign credentials in the global footer navigation

  @Regression
  Scenario: VIR-118.01 Verify that the Verisign credentials are shown in the footer of the site
    Given open the site and login
    Then badge "ssl" is shown in footer
