Feature: GE-11 - Privacy Terms Link
  As a customer on the site I would like to be shown
  a links that opens the privacy terms in the global footer

  @Regression
  Scenario: VIR-254.01 Verify that the page with terms and conditions is opened after clicking on the privacy terms link at the footer
    Given open the site and login
    When click on "Privacy Terms" in footer
    Then "TermsAndConditions" content is opened
