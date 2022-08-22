Feature: Summary Section Data Mapping

  Background:

    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully

    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button

    When I am on the personal information page
    And I need fill out the personal information
    Then I should click on next the button

    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

   @regression
  Scenario: Editing Preapproval Information from UI-DB

    Given I am on the Summary section
    And I click on edit PreApproval details

        | ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT |
        | 350000                   | 90000               |

    Then I should be able to apply successfully
    And database should also have the same mapped info

        | ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT |
        | 350000                   | 90000               |

    @regression
  Scenario: Editing Econsent information from DB-UI

    Given I am on the Summary section
    When I modify Database Econsent by changing the name, lastname and email

        | firstName | lastName | emailAddress          |
        | Liliya    | Grant    | liliyagrant@gmail.com |

    And I should be able to edit eConsent using same info from UI
    Then I should be able to apply successfully
    And all the information that i edited should be correct

  @regression
  Scenario: Null values should not be allowed for the Primary Key column
    When I send a request to retrieve null values for Primary Key Column
    Then the result should return empty




