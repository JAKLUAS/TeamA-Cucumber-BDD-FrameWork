@regression

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