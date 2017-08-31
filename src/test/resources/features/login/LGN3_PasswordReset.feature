Feature: LGN-3 - Password Reset
  As a customer on the site I would like to reset my password if I forgot it

  @Login
  Scenario: Create new user in the Backoffice
    Given open "BackOffice" page
    When login as "admin"
    When click on "B2B Commerce" in backoffice
    When click on "B2B Customer" in backoffice
    When click on create button in backoffice
    When enter "test.usabb@gmail.com" in "ID:" field in backoffice
    When enter "test.usabb@gmail.com" in "Customer ID:" field in backoffice
    When enter "test.usabb@gmail.com" in "Name:" field in backoffice
    When enter "test.usabb@gmail.com" in "Description:" field in backoffice
    When enter "test.usabb@gmail.com" in "Email:" field in backoffice
    When click on "Next" modal button
    When click on "Next" modal button
    When enter "Rustic" in "Groups:" field in backoffice
    When select "Rustic" in "Groups:" dropdown in backoffice
    When click on "Done" modal button
    When click on "Logout" link in backoffice
    When login as "admin"
    When click on "B2B Commerce" in backoffice
    When click on "B2B Customer" in backoffice
    Then the "test.usabb@gmail.com" is presented in the table backoffice

  @Login
  Scenario: Verify that the shopper is able to open change password modal window by clicking in the corresponding link
    Given open the site
    When click on "Forgot your password?" button
    Then the reset password modal is shown

  @Login
  Scenario: Verify that the email is sent to the shopper on changing password with the reset link
    Given open the site
    When click on "Forgot your password?" button
    When enter "test.usabb@gmail.com" in the "Email Address" field in modal
    When click on "Reset Password" modal button
    Then the reset password email is sent

  @Login
  Scenario: Verify that the shopper can enter new password on the reset link
    Given open the site
    When click on "Forgot your password?" button
    When enter "test.usabb@gmail.com" in the "Email Address" field in modal
    When click on "Reset Password" modal button
    When open the reset link in email
    When enter "qWer%QQq" in the "New Password" field
    When enter "qWer%QQq" in the "Confirm Password" field
    When click on "Update" modal button
    Then alert with text "Success! You can now login using your new password." is shown

  @Login
  Scenario: Verify that the shopper can login to the system with the new password
    Given open "storefront" page
    When enter "test.usabb@gmail.com" in the "Email Address" field
    When enter "qWer%QQq" in the "Password" field
    When click on login button
    Then home page is opened