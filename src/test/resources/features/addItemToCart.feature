@AddItemToCart
Feature: Add item to cart

  As a shopper
  I want to add a book to my cart
  So that I can prepare items for purchase.

  @Happy
  @ClearCart
  Scenario: Add one book to the cart
    Given I am on the Home page
    When I search for "Roomies"
    And click the Add to Cart button
    Then I see the item added to cart successfully toast message
    And I see the cart icon badge shows 1

  @Happy
  @ClearCart
  Scenario: Add multiple items to the cart - 2 books
    Given I already have "Rot & Ruin" in the cart
    And I am on the Home page
    When I search for "Roomies"
    And click the Add to Cart button
    Then I see the item added to cart successfully toast message
    And I see the cart icon badge shows 2

  @Happy
  @ClearCart
  Scenario: Add multiple items to the cart - 3 books
    Given I already have "Rot & Ruin" in the cart
    Given I already have "Slayer" in the cart
    And I am on the Home page
    When I search for "Roomies"
    And click the Add to Cart button
    Then I see the item added to cart successfully toast message
    And I see the cart icon badge shows 3