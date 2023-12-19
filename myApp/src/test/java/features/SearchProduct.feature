Feature: Search and place order for products
  Scenario: Product search for both home and offers page
    Given user is on GreenKart landing page
    When user searches with shortname "tom" to extract actual name of product
    Then user searches for the same shortname in offers page to check if it exists
