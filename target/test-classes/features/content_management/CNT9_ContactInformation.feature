Feature: CNT-9 - Contact Information
  As a content admin I would like to be able to manage my contact information pages including
  a) Phone
  b) Chat (R2)
  c) Submit an inquiry
  d) email

  @Regression
  Scenario: VIR-136.01 Verify that the Contact Us info is correct
    Given open the site and login
    When click on "Contact Us" link in header
    Then "ContactUs" content is opened

  @Regression @TBD
  Scenario: VIR-136.02 Verify that Content Admin can change the following Contact Us info
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "contactUs" content
    When double click on "contactUs" content page
    When click on "Edit" button in "Section2B" slot
    When enter "ContactUsTest" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"

  @Regression @TBD
  Scenario: VIR-136.03 Verify that the Contact Us info is updated accordingly on the site
    Given open the site and login
    When click on "Contact Us" link in header
    Then "ContactUsTest" content is opened

  @Regression @TBD
  Scenario: VIR-136.04 Return changes
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "contactUs" content
    When double click on "contactUs" content page
    When click on "Edit" button in "Section2B" slot
    When enter "ContactUs" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"