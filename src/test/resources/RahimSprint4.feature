@regression

  Feature: User should be able to complete credit report and sign E-consent form

    Scenario: User should be able to order a credit report by clicking yes

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
    When I click yes to order credit report
    Then I should be able to click next button



    Scenario: User should not order a credit report by clicking no
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
      When I click No to order credit report
      Then I should be able to click next button

    @dt
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
      When I click yes to order credit report
      Then I should be able to click next button

      Given I am on the E-consent page
      When I input incorrect information as list of maps

        | firstName | lastName | e-mail             |
        | 1234      | 5678     | rahim123@gmail.com |

      Then I should be able to click Agree
      Then I should not be able to click next button


    @dt
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
      When I click yes to order credit report
      Then I should be able to click next button

      Given I am on the E-consent page
      When I input correct information as list of maps

        | firstName | lastName | e-mail             |
        | rahim     | rustamov | rahim123@gmail.com |

      Then I should be able to click Agree
      Then I should be able to click next button


