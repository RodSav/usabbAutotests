Feature: PDP-2 - Image Zoom
  As a customer browsing the site I would
  like to have rotating zoom for product images displayed on the pdp

  @Regression
  Scenario: VIR-140.01 Verify that the customer can use rotating zoom on the product images
    Given open the site and login
    When click on "Early Learning" in navigation menu
    When click on "1" product image in list
    When click on product image
    Then zoomed image is shown

  @Regression
  Scenario: VIR-140.02 Verify that the customer can close rotating zoom on the product images
    Given open the site and login
    When click on "Early Learning" in navigation menu
    When click on "1" product image in list
    When click on product image
    When click on close zoom button
    Then zoomed image is not shown
    When click on product image
    When click on zoomed image
    Then zoomed image is not shown