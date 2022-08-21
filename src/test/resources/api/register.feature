Feature: Testing DuoBank API
  Background:
     Given The Base URI is set


@api
  Scenario: Verify User info update with POST request


    When  I send a Post request to "/register.php" endpoint with the following values
      | first_name | Halil                  |
      | last_name  | Baba                   |
      | email      | halodkmn1251@gmail.com |
      | passwords  | halo1234               |

    Then The response should contain the following

      | status-code  | 201                             |
      | Content-Type | application/json; charset=UTF-8 |
      | Server       | nginx/1.20.0                    |




  @api



    Scenario: verify created user info

      When I send a post request to the end point with valid credentials
      Then verify the status code

  @api
    Scenario:verify existing user info with negative test case

      When I send a post request to the end point with existing credentials
      Then verify the status code  and error message


  @api
    Scenario: create a user info and verify wit serialization
       When i send a post request to the end point  with faker
       Then The response should contain the following credentials
         | status-code  | 201                              |
         | Content-Type | application/json; charset=UTF-8  |
         | Server       | nginx/1.20.0                     |
         | message      | You have successfully registered. |


  @api
  Scenario: sending the request with pojo
    When  I send  request to the end point using pojo
    Then  verifying the status code and header.


