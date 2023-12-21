Feature: Search and place order for products
  Scenario: Product search for both home and offers page
    Given user is on GreenKart landing page
    When user searches with shortname "tom" to extract actual name of product
    And user searches "tom" in offers page to extract actual name there as well
    Then the names extracted from both pages will match
