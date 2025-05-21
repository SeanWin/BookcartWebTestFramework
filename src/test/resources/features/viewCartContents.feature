@ViewCart
Feature: View cart contents

  As a shopper
  I want to see my cart
  So that I can review what I’ve selected.

  Background:
    # Comment out the below line to run tests logged out
    Given I am logged in with username "Username50785" and password "Password1"

  @Happy
  @ClearCart
  Scenario: View cart contents - one book
    Given I already have "The Hookup" in the cart
    When I press the cart icon
    Then I should be redirected to the Shopping Cart page
    And I should see the following cart details:
      | Title       | Price   | Quantity | Total  |
      | The Hookup  | ₹434.00 | 1        | ₹434.00|
    And the checkout button is present

  @Happy
  @ClearCart
  Scenario: View cart contents - two books
    Given I already have "The Hookup" in the cart
    Given I already have "Slayer" in the cart
    When I press the cart icon
    Then I should be redirected to the Shopping Cart page
    And I should see the following cart details:
      | Title       | Price     | Quantity | Total    |
      | The Hookup  | ₹434.00   | 1        | ₹434.00  |
      | Slayer      | ₹1,234.00 | 1        | ₹1,234.00|
    And the checkout button is present