
Feature: User sing up feature as an unregister user i should be able to sing up using singup page

  Background:
    Given I am on the home page


  Scenario: Non registered user singup positive

    When I navigate to singup page and enter valid credentials.
    Then I should be able to sing up successfully


  Scenario: Non-registered user signup negative

    When I navigate to signup page and enter invalid credentials
    Then I should not be able to sign up



  Scenario: Non-registered user signup no credentials

    When I navigate to signup page and enter no credentials
    Then I should not be able to sign up

 @dt @parallel
  Scenario: Non registered user singup positive as list of maps

    When I navigate to singup page and enter valid credentials as list of maps .

      | firstname | lastname | email             | password   |
      | Khalel    | Dykman   | dykman1902@gmail.com | dykman2022 |

    Then I should be able to sing up successfully



  Scenario Outline: Non-registered user signup positive datatable list of map scenario outline
    When I navigate to singup page and enter valid credentials as list of maps .

      | firstname   | lastname   | email   | password   |
      | <FIRSTNAME> | <LASTNAME> | <EMAIL> | <PASSWORD> |

    Then I should be able to sing up successfully
    Examples:
      | FIRSTNAME | LASTNAME | EMAIL              | PASSWORD    |
      | Khalel    | Dykman   | dykman00@gmail.com | dykman2022  |
      | Vafa      | Queen    | vafa00@gmail.com     | vafa2022    |
      | Dildora   | Hanim    | dildora00@gmail.com  | dildora2022 |
      | Lyle      | Abla     | lyle00@gmail.com     | lyle2022    |
      | Asif      | Hamzaev  | asif00@gmail.com     | asif2022    |
      | Rahim     | Rustamov | rahim00@gmail.com    | rahim2022   |

  @data_driven_csv
  Scenario: Non-registered user signup data-driven testing using csv file

    When I navigate to signup page
    Then  I read the signup information from csv file and enter the details and should be able to sign up successfully
