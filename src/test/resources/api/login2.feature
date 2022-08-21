Feature: Testing DuoBank API

  Background:
    Given The Base URI is set

  @api
  Scenario:  Verify Negative test Post login with invalid credentials
    When I send a Post request to the endpoint with wrong credentials
    Then The response should contain an error message

  @api
  Scenario: Verify test Post response payload in Login
     When I send a post request to the end point with existing email and password

    Then the response payload should have the following body info

      | status-code | 200                              |
      | success     | 1                                |
      | message     | You have successfully logged in. |

