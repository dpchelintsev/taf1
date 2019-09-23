@Feature_Purchase
Feature: Purchase test

  @Regression
  Scenario: Purchase on amazon
    Given I'm on main page
    And I click on Account and Lists button
    And I'm signing in
    And I search for "Iphone"
    When I see list of result
    And I select first result
    And I click on 'Add to cart' button
    And I click on 'View cart' button
    Then I see "iPhone" in cart
