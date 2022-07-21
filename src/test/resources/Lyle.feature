@regrestion

Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

  @smoke
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