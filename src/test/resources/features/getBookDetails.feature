@BookDetails
Feature: Get book details

  As a shopper
  I want to retrieve a specific book’s details
  So that I can read its title, author, price, category, etc.

  @Happy
  Scenario Outline: Successfully get book details by title
    Given I am on the Home page
    When I search for "<bookTitle>"
    And click on the book
    Then I should be redirected to the book details page
    And I should see the following book details:
      | Title      | Author            | Category   | Price    |
      | <bookTitle> | <author>         | <category> | <price>  |
    And the Add to Cart button should be visible
    And a list of similar books should be present

    Examples:
      | bookTitle              | author             | category  | price     |
      | Roomies                | Christina Lauren   | Biography | ₹334.00   |
      | Like a Love Story      | Abdi Nazemian      | Romance   | ₹6,666.00 |
      | The Chosen             | Taran Matharu      | Fantasy   | ₹5,555.00 |

  @Happy
  Scenario Outline: Successfully get book details by author
    Given I am on the Home page
    When I search for "<author>"
    And click on the book
    Then I should be redirected to the book details page
    And I should see the following book details:
      | Title      | Author            | Category   | Price    |
      | <bookTitle> | <author>         | <category> | <price>  |
    And the Add to Cart button should be visible
    And a list of similar books should be present

    Examples:
      | bookTitle                   | author           | category | price     |
      | Robbie                      | Ella Frank       | Fiction  | ₹345.00   |
      | 7/1/1993                    | qwert            | Fiction  | ₹123.00   |
      | A Court of Mist and Fury    | Sarah J. Maas    | Romance  | ₹645.00   |

  @Sad
  Scenario: Unsuccessfully search for book by title/author
    Given I am on the Home page
    When I search for "random"
    Then no results are displayed in the drop down menu

