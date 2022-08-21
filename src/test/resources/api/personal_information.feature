Feature: Testing DuoBank API

   Background:
     Given The Base URI is set


  @dr1
  Scenario: Verify User info update with GET request


    When  I send a GET request to "/getmortagage.php" endpoint with the following values
      | userName | duotechb5@gmail.com              |
      | password  | duotechb5                 |


    Then The response should contain the following information

      | status-code  | 200                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |




    @dr1
    Scenario: Verify the response with Post request

      When I send a Post request to "/mortagagedetails.php" endpoint with following
        | id          | 713     |
        | b_firstName | Ollie   |
        | b_lastName  | Kenndy  |
        | b_marital   | Married |

      Then The Response should have following information
        | Status      | 200                           |
        | b_firstname | Ollie                         |
        | b_email     | leonor.mclaughlin@hotmail.com |