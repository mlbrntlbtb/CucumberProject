@LoginActionDataTable
Feature: Login Action With Data Table

 Scenario: Successful Login with Valid Credentials
    Given User is on Login Page3
    When User enters Credentials3
    |johnwick|Excommunicado123!|
    And Click Login3
    Then Userlabel with Credentials will be displayed3
    |johnwick|