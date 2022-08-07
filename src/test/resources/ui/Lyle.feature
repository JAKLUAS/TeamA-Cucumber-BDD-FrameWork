Feature: Navigating to Expenses section and entering monthly rental amount in order to proceed to the next section
  & Navigating to Summary section to finish application process

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

  Scenario: User should be able to navigate to Expenses section and enter rental payment

    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button


  Scenario: User should be able to navigate to Summary section and apply successfully

    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on the save button
    Then I should be able to apply successfully


  Scenario: User should be able to navigate to Summary section and Edit Expenses

    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on edit Expenses and change to Own and amount
    Then I should be able to apply successfully

  Scenario: User should be able to navigate to Summary section and Edit eConsent

    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on edit eConsent and change to Disagree
    Then I should be able to apply successfully

#    //New_Sprint

  @dt @parallel
  Scenario: User should be able to navigate to Summary section and Edit PreApproval Details

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

    When I am on the Summary section
    And I click on edit PreApproval details

      | ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT |
      | 350000                   | 90000               |

    Then I should be able to apply successfully

 @dt
  Scenario: User should be able to navigate to Summary section and Edit eConsent content

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

    When I am on the Summary section
    And I click on edit eConsent and change the name, lastname and email

      | firstName | lastName | emailAddress |
      | Liliya    | Grant    | liliyagrant@gmail.com |

    Then I should be able to apply successfully

  @dt @crossBrowser
  Scenario: User should be able to navigate to Summary section and Edit Employment and Income

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

    When I am on the Summary section
    And I click on edit Employment & Income with some details

      | Gross Monthly Income | Monthly Overtime | Monthly Bonuses | Monthly Commissions | Monthly Dividents |
      | 15000                | 2000             | 1000            | 1500                | 500               |

    Then I should be able to apply successfully

  @so
  Scenario Outline: User should be able to navigate to Summary section and Edit Personal Information

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

    When I am on the Summary section
    And I click on edit Personal Details with necessary information

      | FirstName   | MiddleName   | LastName   |
      | <firstname> | <middlename> | <lastname> |

    Then I should be able to apply successfully

    Examples:

      | firstname | middlename | lastname |
      | Cathy     | Garcia     | Molina   |
      | Fatima    | Lopez      | Brate    |
      | Hannah    | Mejorada   | Donayre  |