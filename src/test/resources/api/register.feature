Feature: Testing DuoBank API

   Background:
     Given The Base URI is set



  Scenario: Verify User info update with POST request


    When  I send a Post request to "/register.php" endpoint with the following values
      | first_name | Jhony                |
      | last_name  | Deep                 |
      | email      | Jhony_deep5@gmail.com |
      | passwords  | jhony1234            |

    Then The response should contain the following

      | status-code  | 201                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |



    @api
    Scenario: verify created user info
      When I send a post request to the end point with valid credentials
      Then verify the status code