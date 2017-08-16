Feature: CNT-6 - Content Slots
  As a content admin I would like to have a banner overlaid with text.
  A page title displaying "Products by Category" and 4x3 rows of
  product categories which can be managed by Virco through the WCMS

  @Regression
  Scenario: VIR-133.01 Verify that the content admin can delete the banner, title and categories through the WCMS
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "Home" content
    When double click on "homepage" content page
    When click on "Remove" button in "TopBodyContent" slot
    When select "Yes" in remove pop-up
    Then message "Nothing to display" in "TopBodyContent" is presented

  @Regression
  Scenario: VIR-133.02 Verify that the content admin can add the banner, title and categories through the WCMS
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "Home" content
    When double click on "homepage" content page
    When click on "Create an item" button in "TopBodyContent" section header
    When select "Banner Component" template from modal window
    When select "Select an existing reference" template from modal window
    When click on search button in modal
    When click on "Banner Overlaid With Text Component" in modal results
    When click on "Done" button in modal
    Then message "Banner Overlaid With Text Component" in "TopBodyContent" is presented


  @Regression
  Scenario: VIR-133.03 Verify that the content admin can edit the banner, title and categories through the WCMS
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "Home" content
    When double click on "homepage" content page
    When click on "Edit" button in "TopBodyContent" slot
    When enter "Test banner component" in "Headline:" editor field
    When enter "BannerTest" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"

  @Regression
  Scenario: VIR-133.04 Verify that the Banner is shown to the shopper on the home page
    Given open the site and login
    Then banner component is shown

  @Regression
  Scenario: VIR-133.05 Verify that the text is overlaid on the banner
    Given open the site and login
    Then banner header is "Test banner component"
    Then banner content is "test content banner."

  @Regression
  Scenario: VIR-133.06 Verify that the Page title "Products by Category" is shown to the shopper
    Given open the site and login
    Then the page title "Products by Category" is shown

  @Regression
  Scenario: VIR-133.07 Verify that the following page categories are shown
    Given open the site and login
    Then the following categories are shown:
      | Chairs                         |
      | Computer and Technology        |
      | Desks                          |
      | Dining and Cafeteria           |
      | Early Childhood Learning       |
      | Event and Hospitality          |
      | Facility and Building Services |
      | Filing and Storage             |
      | Handling and Storage Equipment |
      | Library and Multimedia Spaces  |
      | Office and Adminstrative       |
      | Presentation, AV and Boards    |
      | Science & Art                  |
      | Tables                         |
      | Wheelchair and ADA Compliant   |
