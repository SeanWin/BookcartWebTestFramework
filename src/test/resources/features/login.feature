Feature: User Login

  As a returning customer
  I want to enter my username and password
  So that I can authenticate and access my account-specific data (cart, orders, wishlist).

  Scenario: Successful login with valid credentials
    Given I am on the Login page
    When I enter "Username12" into the Username field
    And I enter "Password1" into the Password field
    And I click the Login button
    Then I should be redirected to the Home page