@LoginActionParameterWithExample
Feature: Login Action With Parameter With Example

  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Login Page2
    When User enters "<username>" and "<password>"
    And Click Login2
    Then Userlabel with "<username>" will be displayed
    
  Examples:
  |username|password|
  |johnwick|Excommunicado123!|
  |johnwick|Excommunicado123!|
  |johnwick|Excommunicado123!|
  
  
  
  