Feature: User should be able to complete credit report and sign E-consent form

@smoke @regression
  Scenario: Verify the E-consent column names for mortgage table

    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully

    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button

    When I am on the personal information page
    And I need fill out the personal information
    Then I should click on next the button

    Given I am on the Expenses section
    When I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
#    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I send a request to retrieve colum names for mortgage table
    Then It should be the following E-consent columns


      | eConsent_declarer_FirstName |
      | eConsent_declarer_LastName  |
      | eConsent_declarer_Email     |


  @smoke @regression
  Scenario: User should be able to fill out E-consent form using correct information for all 3 fields
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully

    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button

    When I am on the personal information page
    And I need fill out the personal information
    Then I should click on next the button

    Given I am on the Expenses section
    When I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
#    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information as list of maps
      | firstName | lastName | e-mail              |
      | Roger     | Jacobs   | rjacobs23@gmail.com |
    Then I should be able to click Agree
    Then I should be able to click next button
      When I am on the Summary section
      And I click on the save button
      Then I should be able to apply successfully
      And The database should also have correctly mapped info for Econsent columns
        | firstName | lastName | e-mail              |
        | Roger     | Jacobs   | rjacobs23@gmail.com |



  @smoke @regression
  Scenario: User should be able to fill out E-consent form using incorrect information for all 3 fields
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully

    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button

    When I am on the personal information page
    And I need fill out the personal information
    Then I should click on next the button

    Given I am on the Expenses section
    When I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
#    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input incorrect information as list of maps
      | firstName | lastName | e-mail  |
      | 1234      | 5678     | 9101112 |
    Then I should be able to click Agree
    Then I should not be able to click next button
    And The database should not map info for Econsent columns
      | firstName | lastName | e-mail  |
      | 1234      | 5678     | 9101112 |

  @regression
  Scenario: User should be able to fill out E-consent form using incorrect information for all 3 fields version2
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully

    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button

    When I am on the personal information page
    And I need fill out the personal information
    Then I should click on next the button

    Given I am on the Expenses section
    When I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
#    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input incorrect information as list of maps
      | firstName | lastName | e-mail       |
      | jane      | robinson      | jane@az |
    Then I should be able to click Agree
    Then I should be able to click next button
    When I am on the Summary section
    And I click on the save button
    Then I should be able to apply successfully
    And The database should not map info for Econsent columns
      | firstName | lastName | e-mail        |
      | jane      | robinson      | jane@az |






