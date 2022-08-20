Feature: Data mapping for Employment and Income page


Background:

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



  Scenario: Registered user fills out employment and income info
  When User enters the following credentials
    | employer_name | position | city  | start_date | gross_monthly_income |
    | John Doe      | Director | Homer | 12242022   | 7600                 |
  Then the user should be able to click on next button

  Given I am on the credit report page
  Then I should be able to click next button

  Given I am on the E-consent page
  When I input correct information and click Agree
  Then I should be able to click next button

  When I am on the Summary section
  And I click on the save button
  Then I should be able to apply successfully

  Then The database should also have the same info for Employment and Income columns
    | employer_name | position | city  | start_date | gross_monthly_income |
    | John Doe      | Director | Homer | 12242022   | 7600                 |


  @smoke @regression
  Scenario: Verify the Employment and Income column names for mortagage table

  When I send a request to retrieve colum names for mortagage table
  Then I should be able to see following Employment and Income columns
    | employer_name          |
    | position               |
    | city                   |
    | start_date             |
    | end_date               |
    | current_job            |
    | co_employer_name       |
    | co_position            |
    | co_city                |
    | co_state               |
    | co_start_date          |
    | co_end_date            |
    | co_current_job         |
    | gross_monthly_income   |
    | monthly_over_time      |
    | monthly_bonuses        |
    | monthly_commision      |
    | monthly_dividents      |
    | c_gross_monthly_income |
    | c_monthly_over_time    |
    | c_monthly_bonuses      |
    | c_monthly_commision    |
    | c_monthly_dividents    |
    | add_belong             |
    | income_source          |
    | amount                 |


@smoke @regression
  Scenario: Verify the mortagage table for unique IDs
    When  I send a request to retrieve duplicate IDs
    Then  The result should show as empty


@smoke @regression
  Scenario: I check the mortgage table for minimum down-payment implemented correctly
    When  I send a request to retrieve minimum down-payment
    Then  The result should not be empty



