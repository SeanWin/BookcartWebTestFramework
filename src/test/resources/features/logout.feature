@Logout
Feature: User Logout

  As a logged‑in user
  I want to logout after finishing
  So that I can end my session securely

  @Happy
  Scenario: Successful user logout
    Given I am logged in with username "Username12323" and password "Password1"
    When I press the Logout button
    Then I should be redirected to the Login page
    And the login page button is present