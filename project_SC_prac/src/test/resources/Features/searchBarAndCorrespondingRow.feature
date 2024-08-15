# logged by Rizwans
# On 8th Aug 2024
Feature: Search bar and corresponding row

  Scenario: search bar functionality scenario
    Given when the user is on the homepage of shopclues
    When the user clicks in search bar and enter the text
    And user click on search button
    Then the user is presented with list options

  Scenario: Navigation to My cart
    Given when the user is on the homepage of shopclues
    When the user clicks on the cart icon
    Then the user is navigated to MyCart
