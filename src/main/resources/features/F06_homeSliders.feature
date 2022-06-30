@smoke
Feature: F06_homeSliders | users will be able to open sliders in home page
  Scenario:first slider is clickable on home page
    Given user go to "1" slider
    Then relative product for slider is displayed

  Scenario:second slider is clickable on home page
    Given user go to "2" slider
    Then relative product for slider is displayed