Feature: Testing DuoBank API

  Background:
    Given The Base URI is set


  Scenario:
    When I send a Post request to the endpoint with wrong credentials
    Then The response should contain an error message

