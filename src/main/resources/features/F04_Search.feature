@smoke
Feature: F04_Search | users will be able to search for products with different parameters
  Scenario: user could search using product name
    Given user clicks on search field
    When user search with name of product
    Then user could find relative results

  Scenario: user could search using sku
    Given user clicks on search field
    When user search with sku of product "AP_MBP_13"
    Then user will find only one results and user will click on it
    Then verify sku "AP_MBP_13"