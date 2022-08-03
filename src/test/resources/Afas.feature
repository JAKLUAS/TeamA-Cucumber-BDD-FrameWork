#@regression
#Feature: User sign in feature
#  as a registered user i should be able to sign in
#
#
# Background:
#    Given I am on the home page
#    When I enter valid credentials.
#
#   When i click o Application list
#
#
#  Scenario: Registered user sign in positive
#    Then I should be able to sign in successfully
#  @smoke
#Scenario: Registered user click on Application list
#  Given i am on sign in page
#  Then Application list needs to appear successfully
#
#  @smoke
#    Scenario: Change Entries to 50
#      Given im on Application list page
#    When i click on the number
#    Then i should be able to change it to FifTy
#
#      Scenario: Click on By Duotech team
#        When i click on the number
#        Then i should be able to change it to FifTy
#        Given im on the sign in page
#        When i click on by Duotech Team
#        Then i should be able to go to another window
#
#Scenario: go to previous window feature
#  When i click on the number
#  Then i should be able to change it to FifTy
#  Given im on the sign in page
#  When i click on by Duotech Team
#  Then i should be able to go to another window
#  Given im on the second window
#  When i will switch to previous window
#  Then i should be able to log out from the website
