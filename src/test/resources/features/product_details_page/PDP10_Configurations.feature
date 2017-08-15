Feature: PDP-10 - Configurations
  As a customer IF a third row content slot is
  displayed I would like to see from top to bottom
  the base model number that will allow the user to
  select the table laminate top, edge branding, color,
  frame color, other options in the drop downs

  @Regression
  Scenario Outline: VIR-267.01 Verify that the following information is shown at the slot 3
    Given open the site and login
    When open pdp with product in the category "<categoryname>" that has "<configName>"
    Then the configuration is shown on PDP
    Examples:
      | categoryname | configName |
#      | Desk-Chair Desk            | Config 5  |
#      | Desk-Combo   | Config 9   |
      | Desk-Student               | Config 2   |
#      | Desk-Teacher               | Config 3   |
#      | Student and Guest Chairs   | Config 4   |
#      | Student Chairs             | Config 5   |
#      | Table-Café                 | Config 6   |
#      | Table-Cafeteria            | Config 7   |
#      | Table-Folding              | Config 8   |
#      | Table-Science/Multipurpose | Config 5   |
#      | Table-4000                 | Config 4   |
#      | Table-5000                 | Config 3   |
#      | Table-8700                 | Config 2   |
#      | Table-Computer             | Config 1   |
#      | Table-Folding              | Config 9   |
#      | Table-Plateau              | Config 8   |
#      | Table-Text                 | Config 7   |


  @pending
  Scenario: VIR-267.02 Verify that the proper data are shown for the product

  @pending
  Scenario: VIR-267.03 Verify that the third row content slot is shown for the product when the product has at least one of these attributes
  Examples:
  |attribute|
  |Table laminate top|
  |Edge branding|
  |Color|
  |Frame color|
  |Other options|