Feature: PLD - Global Elements - Footer
  Common elements for footer

  @Regression
  Scenario: VIR-302.01 Verify Shop with confidence at Virco Mfg. Corporation title
    Given open the site and login
    Then "Shop with confidence at Virco Inc." title is shown in footer

  @Regression
  Scenario: VIR-302.02 Verify We accept the following payment types title
    Given open the site and login
    Then "We accept the following payment types:" title is shown in footer

  @Regression
  Scenario: VIR-302.03 Verify NEED HELP? 1 800 448 4726 title
    Given open the site and login
    Then contact information "NEED HELP? 1 800 448 4726" is shown in footer

  @Regression
  Scenario: VIR-302.04 Verify Follow Us title
    Given open the site and login
    Then the Follow Us title is shown