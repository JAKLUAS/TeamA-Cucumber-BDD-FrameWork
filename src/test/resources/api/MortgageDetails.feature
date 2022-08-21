Feature: Testing DuoBank API
  Background:
     Given The Base URI is set


  Scenario: Verify a specific mortgage application details POST a logged in user


    When  I verify a Post mortgage application to return "/mortagagedetails.php " endpoint with the following values
      | id      | 569 |


    Then The response should contain the following informationn

      | status-code  | 200                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |
      | b_firstName  | Maria                           |
      | b_lastName   | Wuckert                         |
      | b_email      | fae.hilll@hotmail.com           |



