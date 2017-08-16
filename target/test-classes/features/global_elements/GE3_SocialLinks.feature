Feature: GE-3 - Social Links
  As a user navigating the site the system will display the social icons for
  Facebook & Pinterest of the companies social media channels in the global footer
  so that the user can collaborate on social media.
  SocialLinks
  https://www.facebook.com/VircoInc
  https://twitter.com/vircoinc
  https://www.pinterest.com/vircoinc/
  https://www.linkedin.com/company/virco

  @Regression
  Scenario: VIR-117.01 Verify that the social links of the companies social media channels are shown in the footer
    Given open the site and login
    Then the social links is displayed in footer:
      | FACEBOOK  |
      | TWITTER   |
      | LINKEDIN  |
      | PINTEREST |

  @Regression
  Scenario Outline: VIR-117.02 Verify that the shopper is moved to the appropriate Virco's social media channels after clicking on the social link
    Given open the site and login
    When click on "<link>" in footer
    Then page with "<address>" is opened
    Examples:
      | link      | address                                |
      | Facebook  | https://www.facebook.com/VircoInc      |
      | Twitter   | https://twitter.com/vircoinc           |
      | Linked    | https://www.linkedin.com/company/virco |
      | Pinterest | https://www.pinterest.com/vircoinc/    |