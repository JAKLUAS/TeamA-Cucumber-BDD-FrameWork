Feature: Testing DuoBank API
  Background:
     Given The Base URI is set

    @test
  Scenario: Verify a specific mortgage application details POST a logged in user


    When  I verify a Post mortgage application to return "/mortagagedetails.php " endpoint with the following values
      | id      | 569 |


    Then The response should contain the following information

      | status-code  | 200                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |
      | b_firstName  | Maria                           |
      | b_lastName   | Wuckert                         |
      | b_email      | fae.hilll@hotmail.com           |




  @Sakina
    Scenario: Verify a specific mortgage application details for a logged in user
      When I return a specific mortgage application details
      Then for a logged in user