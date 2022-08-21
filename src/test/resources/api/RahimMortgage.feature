Feature: Testing DuoBank API

  Background:
    Given The Base URI is set


  @api
  Scenario: Verify User info update with POST request


    When  I send a Get request to "/getmortagage.php" endpoint with the following values
      | username | duotechb5@gmail.com |
      | password | duotechb5           |


    Then The response should contain the following info

      | status-code  | 200                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |

