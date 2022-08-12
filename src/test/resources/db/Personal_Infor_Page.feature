

Feature: Data mapping scenarios to the Personal Information Page

  @smoke  @regression
  Scenario: Data base to UI  end to end
     Given I am on the home page
     When I enter valid credentials.
     Then I should be able to sing in successfully
     When I should click on mortgage application
     Then I need to fill preapproval details
     And I should push next button
     When I am on the personal information page
    When  I pass this information as a list of maps

      | firstName | middleName | lastName | email                | dateOfBirth | SSN       | maritalStatus | cellPhone  | homePhone  |
      | Dominica  | Linet      | Hefferan | lhefferan6@state.com | 10.05.1989  | 541292226 | married       | 9073546524 | 5763643476 |

    Then user should be able click on the next button.
    When I am on the Expenses section
    And I enter monthly rental payment
    Then I should click on the next button

    Given User on the employment and income page
    When User enters all the necessary information
    Then the user should be able to click on next button

    Given I am on the credit report page
#    When I click yes to order credit report
    Then I should be able to click next button

    Given I am on the E-consent page
    When I input correct information and click Agree
    Then I should be able to click next button

    When I am on the Summary section
    And I click on the save button
    Then I should be able to apply successfully
    Then Data base should also have correct information
    | firstName | middleName | lastName | email                | dateOfBirth | SSN       | maritalStatus | cellPhone  | homePhone  |
    | Dominica  | Linet      | Hefferan | lhefferan6@state.com | 10.05.1989  | 541292226 | married       | 9073546524 | 5763643476 |


























