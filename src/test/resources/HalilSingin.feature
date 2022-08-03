@regression
Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

  @login
  Scenario: Registered user singin positive
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully



   @parallel
  Scenario: Registered user signin positive parametrized
    Given I am on the home page
    When  I enter "dykman2@gmail.com" as a username and "dykman2022" as password
    Then I should be able to sign in successfully



  @so
  Scenario Outline: Registered user signin positive
    Given I am on the home page
    When  I enter "<email>" as a username and "<password>" as password
    Then I should be able to sign in successfully  and the name should be "<name>"

    Examples: valid user credentials
      | email             | password    | name           |
      | dykman2@gmail.com | dykman2022  | Khalel Dykman  |
      | afa@gmail.com     | afa2022     | Afa Patron     |
      | vafa@gmail.com    | vafa2022    | Vafa Queen     |
      | dildora@gmail.com | dildora2022 | Dildora Hanim  |
      | lyle@gmail.com    | lyle2022    | Lyle Abla      |
      | asif@gmail.com    | asif2022    | Asif Hamzaev   |
      | rahim@gmail.com   | rahim2022   | Rahim Rustamov |


