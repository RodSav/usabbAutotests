Feature: GE-13 - Global Search/Contract
  As a customer on the site I would like to be
  shown as global elements the Search bar/Contract throughout the site

  @Regression
  Scenario: VIR-256.01 Verify that the Search Bar is shown to the shopper from the right header
    Given open the site and login
    Then the contract drop down is shown

  @Manual @Regression
  Scenario: VIR-256.02 Verify that the contract is shown next after search bar on the header

  @Regression
  Scenario: VIR-256.03 Verify that the Search Bar/contract are shown on navigating through the site
    Given open the site and login
    When click on "Privacy Terms" in footer
    Then the contract drop down is shown