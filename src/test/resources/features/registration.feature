@Feature_Registration
Feature: Registration test

  @Regression
  Scenario: Create account on amazon
    Given I'm on main page
    And I click on Account and Lists button
    When I'm on Sign In page
    And I click on Create Account button
    #Next step isn't finished. I blocked by issue with receiving email
    And I create new account
    Then I'm on main page

  @Regression
  Scenario: Login on amazon
    Given I'm on main page
    And I click on Account and Lists button
    When I'm on Sign In page
    And I'm signing in
    Then I'm on main page
