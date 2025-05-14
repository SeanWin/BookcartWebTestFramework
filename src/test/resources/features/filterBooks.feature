@Filter
Feature: Filter books

  As a shopper
  I want to filter the books
  So that I can narrow down the book list.

  Scenario: Filter books by category - biography
    Given I am on the Home page
    When I click the Biography category button
    Then 9 books are displayed
    And the books have the following titles:
      |Rot & Ruin|
      |Roomies|
      | Dr. Strange Beard|
      |The Simple Wild|
      |The Hate U Give|
      |The Help|
      |The Last Pirate of New York: A Ghost Ship, a Killer, and the Birth of a Gangster Nation|
      |The Ministry of Truth: The Biography of George Orwell's "1984"|
      |Rough Magic: Riding the World's Loneliest Horse Race|
    And all books have an Add to Cart button

  Scenario: Filter books by category - fiction
    Given I am on the Home page
    When I click the Fiction category button
    Then 10 books are displayed
    And the books have the following titles:
      |Harry Potter and the Goblet of Fire|
      |Harry Potter and the Deathly Hallows|
      |Curuk ve Harabe|
      |A Princess in Theory: Reluctant Royals|
      |Robbie|
      |Wicked and the Wallflower|
      |City of Girls|
      |Mrs. Everything|
      |Magic for Liars|
      |7/1/1993|
    And all books have an Add to Cart button

  Scenario: Filter books by category - mystery
    Given I am on the Home page
    When I click the Mystery category button
    Then 8 books are displayed
    And the books have the following titles:
      |Harry Potter and the Chamber of Secrets|
      |Harry Potter and the Order of the Phoenix|
      |Slayer|
      |Catching Fire|
      |The Fault in Our Stars|
      |11/22/63|
      |This Storm|
      |One Night at the Lake|
    And all books have an Add to Cart button
