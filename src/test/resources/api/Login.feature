Feature: Testing DuoBank Login API

   Background:
     Given The Base URI is set


  @api
  Scenario: Verify successful login information
    When I send a POST request to the endpoint with existing credentials
    Then I verify the status code


  @api
  Scenario: Verify Login info update with POST request
    When  I send a Post request to "/login.php" endpoint with the following information
      | email      | Jhony_deep5@gmail.com |
      | passwords  | jhony1234            |
    Then the response should contain the following data
      | status-code  | 200                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |



  @api
  Scenario: Verify the return response of the url with POST request

    When  I send a Post request to "/login.php" endpoint with the following information
      | email      | Jhony_deep5@gmail.com |
      | passwords  | jhony1234            |
    Then the response should contain the following data
      | status-code  | 200                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |

    Then the return response should be less that 1000ms


  @test
  Scenario: Verify Login info update with POST request using Json File
