@regression

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

  @parametrized
  Scenario: Registered user should be able apply with Co - Borrower's.
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button
    When I am on the personal information page
    When user want applying with a Co - Borrower’s
    And user enter "John" as a first name, "Je" as a middle name, "Roberts" as a last name
    And  12 as a month 5 as a day 1989 as a year  for a DOB ,random email address
    And write random marital status , random cell phone
    And random SSN  and random home phone
    And add all random information about Co - Borrower’s
    Then user should be able click on the next button.

  @parametrized
  Scenario: Registered user should be able click to the next button without home phone
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button
    When I am on the personal information page
    When user want applying with a Co - Borrower’s
    And user enter "John" as a first name, "Je" as a middle name, "Roberts" as a last name
    And  12 as a month 5 as a day 1989 as a year  for a DOB ,random email address
    And write random  marital status, random cell phone and random SSN
    And add all random information about Co - Borrower’s
    And Co - Borrower’s don’t want to write home phone information
    Then user should be able click on the next button.

  @smoke
  Scenario: Registered user should be able see error message
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button
    When I am on the personal information page
    When user write random first name, random middle name, random last name
    And write random email address, DOB , random marital status, random cell phone
    And user don’t want write SSN number and home phone
    Then System must show error message.

  @smoke
  Scenario: Registered user should be able see error message
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully
    When I should click on mortgage application
    Then I need to fill preapproval details
    And I should push next button
    When I am on the personal information page
    When user random write email address, random DOB
    And write random marital status , random cell phone
   And random SSN  and random home phone
    And user don’t want to write first name middle name, last name
    Then System must show error message.




