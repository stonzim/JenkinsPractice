Feature: Search and place order for products

  Background:
    Given user is on GreenKart landing page

  @Offers
  Scenario Outline: Product search for both home and offers page
    When user searches with shortname <name> to extract actual name of product
    And user searches <name> in offers page to extract actual name there as well
    Then the names extracted from both pages will match
    Examples:
    | name |
    | tom  |
    | bee  |

  @ShoppingCart
  Scenario Outline: Multiple products selected and added to cart
    When user searches with shortname <name> to extract actual name of product
    And user uses the plus button to add 4 items to cart
    And user confirms the amount in cart and proceeds to checkout
    Then the full name of the item will be displayed
    And the user will see the correct number of items in the cart
    And the Apply and Place Order buttons will be displayed
    Examples:
    | name |
    | bro  |
    | car  |