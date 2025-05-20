@UpdateCart
Feature: Update cart

  As a shopper
  I want to update the cart
  So that I can increase or decrease how
  many books I buy and remove books I don't want.

  Background:
    # Comment out the below line to run tests logged out
    Given I am logged in with username "Username12323" and password "Password1"

  @ClearCart
  @Happy
  Scenario: update cart quantity - decrement
    Given I already have "The Chosen" in the cart
    Given I already have "The Chosen" in the cart
    And I am on the Shopping Cart page
    When I click the decrement button
    Then I see the One item removed from cart toast message
    And quantity is updated to 1
    And the cart total is updated to "₹5,555.00"

  @ClearCart
  @Happy
  Scenario: update cart quantity - increment
    Given I already have "The Chosen" in the cart
    And I am on the Shopping Cart page
    When I click the increment button
    Then I see the One Item added to cart toast message
    And quantity is updated to 2
    And the cart total is updated to "₹11,110.00"

  @Happy
  Scenario: update cart quantity - delete item in cart with 1 book
    Given I already have "The Chosen" in the cart
    And I am on the Shopping Cart page
    When I click the Delete item button for "The Chosen"
    Then I see the Book removed from cart toast message
    And I should see the empty cart screen message
    And the Continue shopping button is visible

  @ClearCart
  @Happy
  Scenario: update cart quantity - delete item in cart with 2 different books
  and delete book with quantity 2
    Given I already have "The Chosen" in the cart
    And I already have "The Chosen" in the cart
    And I already have "Slayer" in the cart
    And I am on the Shopping Cart page
    When I click the Delete item button for "The Chosen"
    Then I see the Book removed from cart toast message
    And I should see the following cart details:
      | Title       | Price     | Quantity | Total    |
      | Slayer      | ₹1,234.00 | 1        | ₹1,234.00|
    And the cart total is updated to "₹1,234.00"

  @ClearCart
  @Happy
  Scenario: update cart quantity - delete item in cart with 3 different books
    Given I already have "The Chosen" in the cart
    And I already have "The Hookup" in the cart
    And I already have "Slayer" in the cart
    And I am on the Shopping Cart page
    When I click the Delete item button for "The Chosen"
    Then I see the Book removed from cart toast message
    And I should see the following cart details:
      | Title       | Price     | Quantity | Total    |
      | The Hookup  | ₹434.00   | 1        | ₹434.00  |
      | Slayer      | ₹1,234.00 | 1        | ₹1,234.00|
    And the cart total is updated to "₹1,668.00"

  @Happy
  Scenario: update cart quantity - clear cart with 3 different books
    Given I already have "The Chosen" in the cart
    And I already have "The Hookup" in the cart
    And I already have "Slayer" in the cart
    And I am on the Shopping Cart page
    When I click the Clear cart button
    Then I see the Cart cleared toast message
    And I should see the "Your shopping cart is empty." message on the screen
    And the Continue shopping button is visible