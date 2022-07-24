@regression
Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

  @smoke
  Scenario: Registered user singin positive
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully



