@Register
Feature: User Registration

  As a new visitor
  I want to create an account
  So that I can log in and save my shopping cart, orders, and wishlist.

  @Happy
  Scenario: Successful user registration
    Given I am on the register page
    And I fill in the registration form with a unique username and the following details
      | firstName | lastName | username  | password | confirmPassword |
      | John      | Doe      |Username   | Password1| Password1       |
    # Note: the actual username will have a random 5 digit number appended to the end for uniqueness
    When I click the Register button
    Then I should see the successful registration toast
    And I should be redirected to the Login page
    And verify the account has been created with login

    @Sad
    Scenario: Unsuccessful user registration - username unavailable, weak password and password mismatch
      Given I am on the register page
      When I fill in the registration form with the following details
        | firstName | lastName | username  | password | confirmPassword |
        | John      | Doe      | Username  | password| Password       |
      Then I should see all relevant registration error messages