@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter first and last name
    And user enter date of birth
    And user enter email and password and confirm password
    And user press on register button
    Then user register to the system successfully