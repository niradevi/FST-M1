@SmokeTest
Feature: Basic Syntax
  @Scenario1
  Scenario: Test Home page
    Given user is on homepage
    When the user clicks on About Us link
    Then the user is redirected to About Us page
    Then close the browser


