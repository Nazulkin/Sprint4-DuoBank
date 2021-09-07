Feature: Sign Up related features

  @db_only
  Scenario: Sign up a new user
    Given I am in homepage and click on sign up
    When I fill up the fields with the following new user information

      | First Name | Last Name | Email           | Password     |
      | Giulia     | Alex      | galex@gmail.com | giuliaalex55 |


    Then This information should be stored correctly in the database



