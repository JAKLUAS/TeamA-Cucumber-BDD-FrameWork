

Feature: Navigating to Expenses section and entering monthly rental amount in order to proceed to the next section
            & Navigating to Summary section to finish application process

  Background:

    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully


  Scenario: User should be able to navigate to Expenses section and enter rental payment

    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button

    When I am on the personal information page
    And I need fill out the personal information
    Then I should click on next the button

    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button

  @smoke @regression
  Scenario: User should be able to navigate to Summary section and apply successfully

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
    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on the save button
    Then I should be able to apply successfully

  @smoke
  Scenario: User should be able to navigate to Summary section and Edit Expenses

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
    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on edit Expenses and change to Own and amount
    Then I should be able to apply successfully

  Scenario: User should be able to navigate to Summary section and Edit eConsent

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
    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on edit eConsent and change to Disagree
    Then I should be able to apply successfully