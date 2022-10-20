@LoginAction
Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given User is on Login Page
    When User enters UserName and Password
    And Click Login
    Then Userlabel with UserName will be displayed

 # Scenario: Succesful Logout
 # 	Given User is on Profile Page
 # 	When User clicks on Logout
 # 	Then Login Page will be displayed
