
@bbn
Feature: As a librarian, I want to know borrowed books number
  Scenario: verify the total amount of borrowed books
    Given user logins as a librarian
    When user takes borrowed books number
    Then borrowed books number information must match with the DB