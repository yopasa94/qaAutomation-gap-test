Feature: Vacations Managment Application

Scenario: Check the home page
    Given open browser "chrome"
    When navigate to url "https://vacations-management.herokuapp.com/users/sign_in"
    And login_to_application with user "gap-automation-test@mailinator.com" and password "12345678"
    Then the page loads all the elements

Scenario: Create a new user
    Given open browser "chrome"
    When navigate to url "https://vacations-management.herokuapp.com/users/sign_in"
    And login_to_application with user "gap-automation-test@mailinator.com" and password "12345678"
    And a new user is created with the info
      | name | id | hiringDate  | leadName  |
      |James Smith| 1234567890 | 21-01-2014  | Silvio Yopasa |
    Then the new user appears in the users table

Scenario: Remove a user
    Given open browser "chrome"
    When navigate to url "https://vacations-management.herokuapp.com/users/sign_in"
    And login_to_application with user "gap-automation-test@mailinator.com" and password "12345678"
    And a user is deleted by id lead name "Silvio Yopasa"
    Then the user does not appear in the users table
