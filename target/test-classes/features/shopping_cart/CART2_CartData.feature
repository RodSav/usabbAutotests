Feature: CART-2 - Cart Data
  As a customer I would like to see the Delete button,
  Text #, Description of the configured color,
  (If applicable) assembly required. SKU, Price,
  Total price and estimated ship date

  @Regression
  Scenario: VIR-319.01 Verify that the items have the following information shown additionally at the shopping cart
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When click on "Add to cart" button
    When click on "Checkout" button
    Then cart page contains following information
#      | Delete button                       |
#      | Text #                              |
#      | Description of the configured color |
#      | Assembly required                   |
#      | SKU                                 |
#      | Price                               |
#      | Total price                         |
#      | Estimated ship date                 |

  @Regression
  Scenario: VIR-319.02 Verify that the shown data is valid
    Given open the site
    # When click on "Sign in" button
    When enter "marie.dubois@rustic-hw.com" in the "Email Address" field
    When enter "12341234" in the "Password" field
    When click on login button
    When click on "Event Spaces" in navigation menu
    When click on "1" product image in list
    When remember product data on pdp
    When click on "Add to cart" button
    When click on "Checkout" button
    Then product data on checkout page is correct


