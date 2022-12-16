@borrowBooks
Feature: Books module
  As a student, I should be able to borrow a book
  @db
  Scenario Outline: Students borrow new books
    Given the user logged in  "<email>" and "<password>"
    And I navigate to "Books" page
    And I search book name called "Head First Java"
    When I click Borrow Book
    Then  verify that book is shown in "Borrowing Books” page
    And  verify logged "<student>" has same book in database
    Examples:
      | email               | password | student             |
      | student5@library    | i1oDgf2d | Test Student 5      |
      | student6@library    | NXhpXJdC | Test Student 6      |

