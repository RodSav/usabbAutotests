Feature: GE-12 - Copyright
  As customer on the site I would like to see the virco
  copyright text "c 2017 Vicro. All Right Reserved" in the global footer

  @Regression
    Scenario: VIR-255.01 Verify that the virco copyright text "c 2017 Vicro. All Right Reserved" is shown at the footer right bottom
    Given open the site and login
    Then copyright "© 2017 Virco. All Rights Reserved." is shown