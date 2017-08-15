Feature: ACT-22 - View Personal Details
  As a shopper, I require the ability to view my personal details within a section of my account

  @Regression
  Scenario: VIR-247.01 Verify that the shopper can see their personal details within My Account
    Given open the site and login
    When click on "My Account" link in header
    When click on "Personal Details" in My Account drop-down
    Then the "Personal Details" my account page is opened

  @Regression
  Scenario: VIR-247.02 Verify that the information is shown on Personal Details page
    Given open the site and login
    When click on "My Account" link in header
    When click on "Personal Details" in My Account drop-down
    Then the "First Name" field is present
    Then the "Last Name" field is present
    Then the "Phone Number" field is present
    Then the "Mobile Phone Number" field is present
    Then the "Organization" field is present
    Then the "Organization" field is present
    Then the "Type of Company" field is present
    Then  the "Title" drop-down is presented
    Then  the "Contact preference" drop-down is presented

  @Regression
  Scenario: VIR-247.03 Verify that the shopper can edit the following personal details
    Given open the site and login
    When click on "My Account" link in header
    When click on "Personal Details" in My Account drop-down
    When enter "Harry" in the "First Name" field
    When enter "Potter" in the "Last Name" field
    When enter "0123456789" in the "Phone Number" field
    When enter "9876543210" in the "Mobile Phone Number" field
    When select "Dr." in "Title" drop-down
    When select "Email" in "Contact preference" drop-down
    When click on "Update" modal button
    When open the site
    When click on "My Account" link in header
    When click on "Personal Details" in My Account drop-down
    Then the data in "First Name" field is "Harry"
    Then the data in "Last Name" field is "Potter"
    Then the data in "Phone Number" field is "0123456789"
    Then the data in "Mobile Phone Number" field is "9876543210"
    Then selected option in "Title" drop-down menu is "Dr."
    Then selected option in "Contact preference" drop-down menu is "Email"