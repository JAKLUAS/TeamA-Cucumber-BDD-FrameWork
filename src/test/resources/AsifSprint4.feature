@regression
Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page


#  Scenario: Registered user fill Preapproval application, without Realtor and Loan officer
#    Given I am on the home page
#    When I enter valid credentials.
#    Then I should be able to sing in successfully
#    When I should click on mortgage application
#    Then I need to fill preapproval details
#    And I should push next button
#
#
#
#  Scenario: Registered user fill Preapproval application, with by entering negative number in Estimated Purchase Price section.
#    Given I am on the home page
#    When I enter valid credentials.
#    Then I should be able to sing in successfully
#    When I should click on mortgage application
#    Then I need to fill preapproval details with negative price
#    And I should push next negative button
#
#
#  Scenario: Registered user fill Preapproval application, with Realtor, Loan officer and Other Type Payment
#    Given I am on the home page
#    When I enter valid credentials.
#    Then I should be able to sing in successfully
#    When I should click on mortgage application
#    Then I need to fill preapproval details with Realtor, Loan officer and Other Type Payment
#    And I should push next button
#
#  Scenario: Registered user fill Preapproval application, Additional Funds
#    Given I am on the home page
#    When I enter valid credentials.
#    Then I should be able to sing in successfully
#    When I should click on mortgage application
#    Then I need to fill preapproval details with Realtor and Loan officer, with Additional Funds
#    And I should push next button


    Background:
      Given I am on the home page
      When I enter valid credentials.
      Then I should be able to sing in successfully

 @parallel
  Scenario: Registered user fill Preapproval application, with Realtor, Loan officer and Other Type Payment
   When I should click on mortgage application
    Then I need to fill preapproval details with Realtor, Loan officer
      | name | phone      | estimatedPrice | downPayment |
      | john | 3475556677 | 300000         | 60000       |
    And Other Type Payment
    And I should push next button

 @so @crossBrowser
  Scenario Outline: Registered user fill Preapproval application, with by entering negative number or characters.


  When I should click on mortgage application
    Then I need to enter mortgage as a mortgage amount and downPayment as a down payment
      | mortgage   | downPayment   |
      | <mortgage> | <downPayment> |
    And I should push next negative button
    Examples:
      | mortgage | downPayment |
      | -300000  | 60000       |
      | -500000  | -20000      |
      | -300000  | 40000       |

  @dt
  Scenario: Registered user fill Preapproval application, Additional Funds
    When I should click on mortgage application
    Then I need to fill preapproval details with Realtor and Loan officer, with multiple Additional Funds
    |5000|
    |4000|
    |6000|
    |7000|
    And I should push next button


  @dt
  Scenario: Registered user checking Application Wizard list
    When I should click on mortgage application
    Then I need to check the Application Wizard list to be like following
      | PreApproval Details                            |
      | Personal Information                           |
      | Expenses                                       |
      | Employment and Income                          |
      | Credit Report Setup your account details here. |
      | eConsent                                       |
      | Summary                                        |












