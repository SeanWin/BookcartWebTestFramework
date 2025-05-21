@Wishlist
Feature: Wishlist management

  As a registered user
  I want to be able to add books to a wishlist
  So that I can save them and add them to my cart later

  Background:
    Given I am logged in with username "Username75179" and password "Password1"

  @Happy
  @ClearWishlist
  Scenario: Add a book to the wishlist from Home page
    Given I am on the Home page
    When I search for "The Martian"
    And I click the heart icon
    Then I should see the Added to Wishlist!!! toast message
    And I see the heart icon badge shows 1
    And validate that the book title in the wishlist page matches with home page

  @Happy
  @ClearWishlist
  Scenario: Add a book to the wishlist from Book Details page
    Given I am on the Book Details page for "Red Rising"
    When I click the Add to Wishlist button
    Then I should see the Added to Wishlist!!! toast message
    And I see the heart icon badge shows 1
    And validate that the book title in the wishlist page matches with book details page

  @Happy
  Scenario: Remove a book from wishlist - one book already in wishlist
    Given I have "The Martian" in my wishlist
    And I am on the Wishlist page
    When I click the Remove from Wishlist button for "The Martian"
    Then I should see the Removed from Wishlist!!! toast message
    And I see the heart icon badge shows 0

  @Happy
  @ClearWishlist
  Scenario: Remove a book from wishlist - two books already in wishlist
    Given I have "The Martian" in my wishlist
    And I have "Red Rising" in my wishlist
    And I am on the Wishlist page
    When I click the Remove from Wishlist button for "Red Rising"
    Then I should see the Removed from Wishlist!!! toast message
    And I see the heart icon badge shows 1

  @Happy
  Scenario: Clear wishlist - two books in wishlist
    Given I have "The Martian" in my wishlist
    And I have "Red Rising" in my wishlist
    And I am on the Wishlist page
    When I click the Clear Wishlist button
    Then I should see the Wishlist cleared!!! toast message
    And I should see the "Your wishlist is empty." message on the screen
    And the Continue shopping button is visible

  @Happy
  @ClearWishlist
  @ClearCart
  Scenario: Add a book from wishlist to cart
    Given I have "The Martian" in my wishlist
    And I am on the Wishlist page
    When I click the Add to Cart button for "The Martian"
    Then I see the item added to cart successfully toast message
    And I see the cart icon badge shows 1
    And validate that the book title in the cart page matches with wishlist page
