@LoginActionParameterWithoutExample
Feature: Login Action With Parameter Without Example

  Scenario: Successful Login with Valid Credentials
    Given User is on Login Page2
    When User enters "johnwick" and "Excommunicado123!"
    And Click Login2
    Then Userlabel with "johnwick" will be displayed