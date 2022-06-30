@smoke
Feature: F03_currencies | user could switch between different currencies
  Scenario: user could move between currencies
    When user select random currency
    And currency is changed in Home Page correctly