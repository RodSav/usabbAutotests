Feature: CNT-4 - Security Compliance
  As a content administrator I would like to create,
  update and manage the terms, security, compliance: i.e.: Verisign,

  @Regression @Bug
  Scenario: VIR-375.01 Unable to open the "Verisign terms and policy" page except through the Contact Us page
    Given open the site and login
    When click on "ssl" icon in footer
    Then "SecurityCompliance" content is opened

  @Regression
  Scenario: VIR-131.02 Verify that the content Admin can delete terms, security and compliance
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "VeriSign Security" content
    When double click on "veriSignSecurity" content page
    When click on "Remove" button in "Section2B" slot
    When select "Yes" in remove pop-up
    Then message "Nothing to display" in "Section2B" is presented

  @Regression
  Scenario: VIR-131.03 Verify that the content Admin can add terms, security and compliance
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "VeriSign Security" content
    When double click on "veriSignSecurity" content page
    When click on "Create an item" button in "Section2B" section header
    When select "Paragraph" template from modal window
    When select "Create a new item" template from modal window
    When click on "Done" button in modal
    Then message "CMSParagraphComponent" in "Section2B" is presented

  @Regression
  Scenario: VIR-131.04 Verify that the content Admin can edit terms, security and compliance
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "VeriSign Security" content
    When double click on "veriSignSecurity" content page
    When click on "Edit" button in "Section2B" slot
    When enter "SecurityComplianceTest" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"

  @Regression
  Scenario: VIR-131.05 Return changes
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "VeriSign Security" content
    When double click on "veriSignSecurity" content page
    When click on "Edit" button in "Section2B" slot
    When enter "SecurityCompliance" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"