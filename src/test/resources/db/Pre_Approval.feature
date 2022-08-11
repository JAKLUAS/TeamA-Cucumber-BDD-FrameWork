Feature: User sing up feature
  as an unregister user i should be able to sing up using singup page

  Background:
    Given I am on the home page
    When I enter valid credentials.
    Then I should be able to sing in successfully

  @Asif
  Scenario: Registered user fill Preapproval application , with Realtor, Loan officer and Other Type Payment
    When I should click on mortgage application
    Then I need to fill preapproval details with Realtor, Loan officer
      | realtor_info | b_cell     | est_purchase_price | down_payment |
      | john         | 3475556677 | 300000             | 60000        |

    Then The database should also have correctly mapped information for payment
      | realtor_info | b_cell     | est_purchase_price | down_payment |
      | john         | 3475556677 | 300000             | 60000        |

  @Asif2
  Scenario: Registered user fill Preapproval application , with Realtor, Loan officer and Other Type Payment
    When I should click on mortgage application
    And I add new user to database for application
      | realtor_info | b_cell     | est_purchase_price | down_payment |
      | john         | 3475556677 | 300000             | 60000        |
    Then I should be able to fill preapproval details with Realtor, Loan officer
    Then The database should also have correctly mapped information for payment
      | realtor_info | b_cell     | est_purchase_price | down_payment |
      | john         | 3475556677 | 300000             | 60000        |

