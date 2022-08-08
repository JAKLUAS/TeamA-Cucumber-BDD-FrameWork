Feature: Data-Mapping



  @data_mapping_ui_to_db
Scenario: New User Sign Up from UI to DB flow
Given I am on the home page
When I navigate to singup page and enter valid credentials as list of maps .
  | firstname | lastname | email           | password  |
  | Muhammed  | Salah    | salah2@gmail.com | salah2022 |
Then I should be able to sing up successfully
And The database should also have correctly mapped info
  | firstname | lastname | email           | password  |
  | Muhammed  | Salah    | salah2@gmail.com | salah2022 |





  @data_mapping_db_to_ui
  Scenario: New User Creation, verify data mapping DB to UI flow
    When I add a new user to the database with the following info
      | firstname | lastname | email              | password  |
      | Armando   | Maradona | maradona27@gmail.com | maradona7 |
    Then I should be able to log in with the same credentials on the UI
    And  The firstname, lastname also should be correct




  @verifyColumnName @db
  Scenario: Verify the column names for albums table
    When  I send a request to retrieve colum names for albums table
    Then It should be the following

      | id          |
      | email       |
      | password    |
      | first_name  |
      | last_name   |
      | phone       |
      | image       |
      | type        |
      | created_at  |
      | modified_at |
      | zone_id     |
      | church_id   |
      | country_id  |
      | active      |

  @metadata
  Scenario: Verify the first_name column length of tbl_user table
    When  I send a request to add a new first_name that is more than the expected length of 100
    Then  The data should be truncated to the expected length





