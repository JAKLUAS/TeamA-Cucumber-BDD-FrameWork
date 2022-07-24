@regression

Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

  @smoke
  Scenario: Registered user fill Preapproval application, without Realtor and Loan officer
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button


@smoke
  Scenario: Registered user fill Preapproval application, with by entering negative number in Estimated Purchase Price section.
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details with negative price
    And I should push next negative button


  Scenario: Registered user fill Preapproval application, with Realtor, Loan officer and Other Type Payment
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details with Realtor, Loan officer and Other Type Payment
    And I should push next button

  Scenario: Registered user fill Preapproval application, Additional Funds
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details with Realtor and Loan officer, with Additional Funds
    And I should push next button







