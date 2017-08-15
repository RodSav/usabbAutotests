Feature: CNT-8 - Order Information
  As a content admin I would like to include ordering information
  similar to what can be found on http://www.bizchair.com/orderinginfo.html
  to guide users on how to order

  @Regression
  Scenario: VIR-135.01 Verify that the Ordering Information page is opened after click on its link in footer
    Given open the site and login
    When hover on "Resources" in navigation menu
    When click on "Ordering Information" button
    When switch to new tab
    Then "OrderingInformation" content is opened

  @Regression
  Scenario: VIR-135.02 Verify that the content admin can delete the content pages
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "orderingInfo" content
    When double click on "orderingInfo" content page
    When click on "Remove" button in "Section2B" slot
    When select "Yes" in remove pop-up
    Then message "Nothing to display" in "Section2B" is presented

  @Regression
  Scenario: VIR-135.03 Verify that the content admin can add content pages
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "orderingInfo" content
    When double click on "orderingInfo" content page
    When click on "Create an item" button in "Section2B" section header
    When select "Paragraph" template from modal window
    When select "Create a new item" template from modal window
    When click on "Done" button in modal
    Then message "CMSParagraphComponent" in "Section2B" is presented

  @Regression
  Scenario: VIR-135.04 Verify that the content admin can edit content pages
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "orderingInfo" content
    When double click on "orderingInfo" content page
    When click on "Edit" button in "Section2B" slot
    When enter "OrderingInformationTest" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"

  @Regression
  Scenario: VIR-135.05 Verify that the content admin can manage where the page is shown
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "orderingInfo" content
    When double click on "orderingInfo" content page
    When click on "Edit" action button
    When enter "/orderingInfoTest" in "Label:" editor field
    When synchronize the product
    When open the site and login
    When open "/orderingInfoTest" storefront page
    Then "OrderingInformationTest" content is opened

  @Regression
  Scenario: VIR-135.06 Return changes for Ordering Information
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "orderingInfo" content
    When double click on "orderingInfo" content page
    When click on "Edit" action button
    When enter "/orderingInfo" in "Label:" editor field
    When click on "Edit" button in "Section2B" slot
    When enter "OrderingInformation" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"
