Feature: Testing register page on DuoBank

  Background:
    Given The Base URI is set


  @api
  Scenario: Verify User info update with POST request


    When  I send a Post request to "/register.php" endpoint with the following info
      | first_name | asif         |
      | last_name  | hamz         |
      | email      | ah41@mail.com |
      | passwords  | ah1234       |

    Then The info should contain the following

      | status-code | 201                               |
      | message     | You have successfully registered. |
      | success     | 1                                 |




  @api

  Scenario: verify created user info by ID

    When I send a post request to the end point with ID number
    Then verify the following info
      | user_id                       | 3407   |
      | first_mortagage_total_payment | 720631 |
      | rent_own_status               | Own    |
      | b_suffix                      | III    |

