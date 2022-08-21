Feature: Testing DuoBank API

  Background:
    Given The Base URI is set

  @api1
  Scenario:  Verify test Post login with invalid credentials
    When I send a Post request to the endpoint with wrong credentials
    Then The response should contain an error message

