

 Feature: User should be able to fill in Employment and Income details feature


   Scenario: Registered user singin positive
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


   Scenario:  User should be able to fill in Employment and Income details feature with the second employer information

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
     When User enters another employer information
     Then the user should be able to click on next button


   Scenario:  User should be able to fill in Employment and Income details adding start date to current job

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
     When User should be able to include start date for current job
     And User enters all the necessary information
     Then the user should be able to click on next button


   Scenario:  User should be able to fill in Employment and Income details adding Additional Gross Monthly Income

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
     And User include additional gross monthly income
     Then the user should be able to click on next button


#     SPRINT 5

   @dt
  Scenario: Registered user singin positive
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
    When User enters the following credentials
      | EMPLOYER NAME | POSITION | CITY  | START DATE | GROSS MONTHLY INCOME |
      | John Doe      | Director | Homer | 12242022   | 7600                 |
    Then the user should be able to click on next button


   @dt
   Scenario:  User should be able to fill in Employment and Income feature with SECOND EMPLOYER INFORMATION AND START DATE

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
     When user_enters_another_employer_information_with_the_following_credentials
       | Employer Name2 | Employer Position2 | City2  | Start Date2 | Gross Monthly Income2 |
       | Ben Stiller    | COO                | Boston | 12.01.1995  | 9876                  |
     Then the user should be able to click on next button



   @so
   Scenario Outline:  User should be able to fill in Employment and Income feature with MONTHLY OVERTIME, BONUSES, COMMISSIONS & DIVIDENDS
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
     When User enters another employer information with the following credentials including the following Gross Monthly Employment Income
       | Employer Name2  | Employer Position2  | City2  | Start Date2  | Gross Monthly Income2 | Monthly Overtime | Monthly Bonuses | Monthly Commissions | Monthly Dividends |
       | <Employer Name> | <Employer Position> | <City> | <Start Date> | <Gross Income>        | <Overtime>       | <Bonuses>       | <Commissions>       | <Dividends>       |
     Then the user should be able to click on next button

     Examples:
       | Employer Name  | Employer Position  | City   | Start Date | Gross Income | Overtime | Bonuses | Commissions | Dividends |
       | Adam Smith     | President          | NYC    | 01.01.2020 | 5500         | 1500     | 500     | 5240        | 0         |
       | John Doe       | Director           | Homes  | 12.30.2018 | 2200         | 350      | 240     | 2450        | 1235      |
       | Julia Roberts  | CEO                | LA     | 05.31.2008 | 19853        | 9101     | 56788   | 6700        | 1000000   |
       | Samantha Smith | Executive Director | NYC    | 09.01.2005 | 5432         | 5678     | 12345   | 3000000     | 100400    |
       | Ben Stiller    | COO                | Boston | 12.01.1995 | 9876         | 1234     | 30400   | 1500000     | 150000    |


   @so @crossBrowser
   Scenario Outline:  User should be able to fill in Employment and Income feature with 3 ADDITIONAL INCOME SOURCES
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
     When User enters another employer information with THREE ADDITIONAL INCOME SOURCES
       | Employer Name2  | Employer Position2  | City2  | Start Date2  | Gross Monthly Income2 |  | Additional Gross Monthly Income |
       | <Employer Name> | <Employer Position> | <City> | <Start Date> | <Gross Income>        |  | <Additional income>             |
     Then the user should be able to click on next button

     Examples:
       | Employer Name  | Employer Position  | City  | Start Date | Gross Income | Additional income |
       | Julia Roberts  | CEO                | LA    | 05.31.2008 | 19853        | 45000             |
       | Samantha Smith | Executive Director | NYC   | 09.01.2005 | 5432         | 50000             |
       | John Doe       | Director           | Homes | 12.30.2018 | 2200         | 15000             |


