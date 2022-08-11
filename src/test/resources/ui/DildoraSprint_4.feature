

Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

   Background:
     Given I am on the home page
     When I enter valid credentials.
     Then I should be able to sing in successfully
     When I should click on mortgage application
     Then I need to fill preapproval details
     And I should push next button
     When I am on the personal information page


  Scenario: Registered user singin positive
    And I need fill out the personal information
    Then I should click on next the button


  Scenario: Registered user should be able apply with Co - Borrower's.
    When user want applying with a Co - Borrower’s
    And user enter "John" as a first name, "Je" as a middle name, "Roberts" as a last name
    And  12 as a month 5 as a day 1989 as a year  for a DOB ,random email address
    And write random marital status , random cell phone
    And random SSN  and random home phone
    And add all random information about Co - Borrower’s
    Then user should be able click on the next button.


  Scenario: Registered user should be able click to the next button without home phone
    When user want applying with a Co - Borrower’s
    And user enter "John" as a first name, "Je" as a middle name, "Roberts" as a last name
    And  12 as a month 5 as a day 1989 as a year  for a DOB ,random email address
    And write random  marital status, random cell phone and random SSN
    And add all random information about Co - Borrower’s
    And Co - Borrower’s don’t want to write home phone information
    Then user should be able click on the next button.


  Scenario: Registered user should be able see error message
    When user write random first name, random middle name, random last name
    And write random email address, DOB , random marital status, random cell phone
    And user don’t want write SSN number and home phone
    Then System must show error message.


  Scenario: Registered user should be able see error message
    When user random write email address, random DOB
    And write random marital status , random cell phone
   And random SSN  and random home phone
    And user don’t want to write first name middle name, last name
    Then System must show error message.



 @dt @crossBrowser
   Scenario: Registered user should be able to click on the next button
     When  I pass this information as a list of maps

      | firstName | middleName | lastName | email                | dateOfBirth | SSN       | maritalStatus | cellPhone  | homePhone  |
      | Dominica  | Linet      | Hefferan | lhefferan0@state.com | 10.05.1989  | 541292226 | married       | 9073546524 | 5763643476 |


   Then user should be able click on the next button.



  @dt
   Scenario: Registered user should be able see error message
     Then  a pass this information as a map

       | firstName     | Shepperd                 |
       | middleName    | Thornton                 |
       | lastName      | Hourston                 |
       | email         | thourston19@thetimes.com |
       | dateOfBirth   | 10021990                 |
       | maritalStatus | married                  |
       | cellPhone     | 7162486251               |

   Then System must show error message.



  @dt @parallel
  Scenario: Registered user should be able see error message
    Then I pass all information as a list of list
      | email             | dateOfBirth | SSN       | maritalStatus | cellPhone  | homePhone  |
      | rarklez@webmd.com | 09.11.1987  | 567861967 | married       | 3712850302 | 8227546021 |


     Then System must show error message.




  @so
  Scenario Outline: Registered user should be able to click on the next button
    When user want applying with a Co - Borrower’s
    And user enter "<firstName>" as a first name, "<middleName>" as a middle name, "<lastName>" as a last name
    And  "<dateOfBirth>" as a DOB , "<email>" as a email address
    And write "<SSN>" as a  SSN  "<maritalStatus>" as a marital status, "<cellPhone>" as a cell phone
    And add all random information about Co - Borrower’s
    And Co - Borrower’s don’t want to write home phone information
    Then user should be able click on the next button.

    Examples: valid information's
      | firstName | middleName | lastName | dateOfBirth | email                    | SSN       | maritalStatus | cellPhone  |
      | Shepperd  | Thornton   | Hourston | 10051989    | thourston19@thetimes.com | 681200841 | married       | 2998040891 |
      | Jan       | Blakelee   | Kildale  | 10111989    | bkildale1a@nps.gov       | 366952800 | married       | 8954463595 |
      | Mozes     | Bard       | Shave    | 11101987    | bshave1e@typepad.com     | 126612410 | married       | 8783023785 |
      | Juan      | Marrilee   | Rizzi    | 10111989    | mrizzi1f@scribd.com      | 284546726 | divorced      | 4968410729 |
      | Cecil     | Dena       | Lewsy    | 11121985    | dlewsy1h@storify.com     | 897349127 | divorced      | 8782146901 |
