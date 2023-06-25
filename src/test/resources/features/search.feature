Feature: Search functionality

  In order to view the Mercedes-Benz Stadium page
  As a Mercedes fan
  I want to navigate to the Mercedes-Benz Stadium page successfully

  Scenario Outline: Search for "Mercedes-Benz Stadium"

    Given User is on the Google homepage
    When User searches for <keyword>
    And User clicks on the link containing Mercedes-Benz Stadium
    Then User should be successfully directed to the homepage containing <title>

    Examples:
      | keyword                 | title                                               |
      | "Mercedes Benz Stadium" | "Mercedes-Benz Stadium \| Official Home of Atlanta" |