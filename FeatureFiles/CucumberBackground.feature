@LoginActionUsingBackground
Feature: Login Action Using Background

Background: Print landing page
	Given User navigated on landing page
	Then Landing page should be displayed

  Scenario: Successful Login with Valid Credentials
    Given User is on Login Page
    When User enters UserName and Password
    And Click Login
    Then Userlabel with UserName will be displayed

  Scenario: Succesful Logout
    Given User is on Profile Page
    When User clicks on Logout
    Then Login Page will be displayed