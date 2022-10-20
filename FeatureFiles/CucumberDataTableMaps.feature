@LoginActionDataTableMaps
Feature: Login Action With Data Table Maps

 Scenario: Successful Login with Valid Credentials
    Given User is on Login Page4
    When User enters Credentials4
    	|Username|Password|
	|johnwick|Excommunicado123!|
    And Click Login4
    Then Userlabel with Credentials will be displayed4
    	|Username|
    |johnwick|