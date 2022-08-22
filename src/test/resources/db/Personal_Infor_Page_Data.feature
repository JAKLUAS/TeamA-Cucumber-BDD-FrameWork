

Feature: Data base Scenario


   @regression
  Scenario: Verify b_firstName column length of the tbl_mortagage table.
    When I send a request to add a new b_firstName that is more than the expected length of 300
    Then The data should be truncated to the expected size


    @regression
    Scenario: Verify b_marital column length of the tbl_mortgage table
      When  I send a request to add a new b_marital that is more than the expected length of 100
      Then Data should be truncated to the expected size



    @regression
  Scenario: Verify the mortgage table for unique SSN numbers
    When  I send a request to retrieve duplicate SSN numbers
    Then  The result must be empty in the test case




