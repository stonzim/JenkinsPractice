Feature: Application Login
  Scenario: Admin Page Default Login
    Given user is on Net-banking landing page
    When user logs into application
    Then homepage is displayed
    And cards are displayed