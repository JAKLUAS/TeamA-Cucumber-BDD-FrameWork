 @regression
Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

  @smoke
  Scenario: Non registered user singup positive
    Given I am on the home page
    When I navigate to singup page and enter valid credentials.
    Then I should be able to sing up successfully

  @smoke
  Scenario: Non-registered user signup negative
    Given I am on the home page
    When I navigate to signup page and enter invalid credentials
    Then I should not be able to sign up


  @smoke
  Scenario: Non-registered user signup no credentials
    Given I am on the home page
    When I navigate to signup page and enter no credentials
    Then I should not be able to sign up
