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

