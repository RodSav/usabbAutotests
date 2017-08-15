Feature: GE-7 - Top Category Navigation
  As a user navigating the site in the main navigation the system should display the following categories from left to right. On hover the system will display dropdown displaying the sub categories
  Categories:
  Early Learning
  21st Century Classroom
  STEAM
  Higher Learning
  Dining,
  Event Spaces
  Office
  Traditional Classroom

  @Regression
  Scenario: VIR-121.01 Verify that the Main menu has the following categories
    Given open the site and login
    Then the header should contain:
      | Early Learning         |
      | 21st Century Classroom |
      | STEAM                  |
      | Higher Learning        |
      | Dining                 |
      | Event Spaces           |
      | Office                 |
      | Traditional Classroom  |

  @Regression
  Scenario Outline: VIR-121.02 Verify that appropriate category page is opened
    Given open the site and login
    When click on "<category>" in navigation menu
    Then appropriate "<category>" page is opened
    Examples:
      | category               |
      | Early Learning         |
      | 21st Century Classroom |
      | STEAM                  |
      | Higher Learning        |
      | Dining                 |
      | Event Spaces           |
      | Office                 |
      | Traditional Classroom  |