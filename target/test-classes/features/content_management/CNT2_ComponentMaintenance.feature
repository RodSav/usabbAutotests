Feature: CNT-2 - Component Maintenance
  As a content admin I would like the Home page to be configured as below:
  1st : Rotating Theme / promotional message / installation shot
  2nd left: Product Recommendation
  2nd right: Quick Ship
  3rd: Popular category / product images

  @pending
  Scenario: VIR-129.01 Verify that the content admin can add a rotating theme by using template

  @pending
  Scenario: VIR-129.02 Verify that the content admin can promo message by using template

  @pending
  Scenario: VIR-129.03 Verify that the content admin can add installation slot by using template

  @pending
  Scenario: VIR-129.04 Verify that the content admin can add a product recommendation component on the page template by using template

  @pending
  Scenario: VIR-129.05 Verify that the content admin can add a quick ship component on the template page

  @pending
  Scenario: VIR-129.06 Verify that the content admin can add a popular category on the template page

  @pending
  Scenario: VIR-129.07 Verify that the content admin can add a product images component on the template page

  @pending
  Scenario: VIR-129.08 Verify that the content admin can edit promo message/popular category.

  @pending
  Scenario: VIR-129.09 Verify that the content admin can delete promo message/popular category.

  @pending
  Scenario: VIR-129.10 Verify that the site has a look, configured by content admin

  @Regression
  Scenario: VIR-166.01 Verify the rotating carousel is added on the home page
    Given open the site and login
    Then  the rotating carousel is shown

  @Regression
  Scenario: VIR-166.02 Verify that the each Banner has Rotating Theme, promotional message and installation slots
    Given open the site and login
    Then each banner has image, message and installation slots
#    add install slot

  @Regression
  Scenario: VIR-166.03 Verify that the changes applied to the home page on the WCMS are shown on the site
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "home" content
    When double click on "homepage" content page
    When click on "Edit" button in "TopBodyContent" slot
    When click on the "1" banner component
    When enter "testCarousel" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"

  @Regression
  Scenario: VIR-166.04 Verify changes on the site
    Given open the site and login
    Then content in carousel is "testCarousel" in 1 banner

  @TBD
  Scenario: VIR-166.04 Verify installation slot

  @Regression
  Scenario: VIR-166.06 Return changes for carousel
    Given open "CMS" page
    When login as "cmsmanager"
    When select "Staged" content catalog
    When search for "home" content
    When double click on "homepage" content page
    When click on "Edit" button in "TopBodyContent" slot
    When click on the "1" banner component
    When enter "Carousel" in content component editor
    When synchronize the product
    Then the action button title is "Status: Synchronized"
