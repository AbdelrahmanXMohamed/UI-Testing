@smoke
Feature: F07_followUs | users could open followUs links
  Scenario:user opens facebook link
    When click on "facebook" icon
    Then "facebook" is opened in new tab

  Scenario:user opens twitter link
    When click on "twitter" icon
    Then "twitter" is opened in new tab

  Scenario:user opens rss link
    When click on "rss" icon
    Then "rss" is opened in new tab

  Scenario:user opens youtube link
    When click on "youtube" icon
    Then "youtube" is opened in new tab
