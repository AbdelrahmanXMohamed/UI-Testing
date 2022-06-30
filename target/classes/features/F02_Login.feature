@smoke
Feature: F02_Login | users could use login functionality to open their accounts

  Scenario: user could login with valid email and password
    Given user go to login page
    When user login with valid "AbdelrahmanMohamed@gmail.com" and "p@$$word"
    Then user login to the system successfully