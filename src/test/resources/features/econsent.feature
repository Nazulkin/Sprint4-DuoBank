Feature: Econsent related features

  Background: steps for all scenarios
    Given I am on the homepage
#    Then I am entering the valid credentials
#    Then I should be able to login and land on the homepage
#    Then I click to Mortgage application
#    Then I enter Preapproval Details
#    Then I enter Personal Information
#    Then I enter Expenses details
#    Then I fill in Employment & Income page
#    Then I answer Credit Report request
#    Then I am on Econsent page

   @failed
  Scenario Outline: Sign Econsent using scenario outline

    When I fill up the fields with the following user information
      | First Name | Last Name | Email |
      | <firstName> | <lastName> | <email> |
    Then This information should be stored properly in the database

    Examples:
      | firstName | lastName | email |
      | Nazrin    | Guliyeva | nazulka@gmail.com |
      | Janel     | Guluzadeh| janel@gmail.com   |
      | Zaur      | Guliyev  | zaur@gmail.com    |


  Scenario: Verify signed Econsent info in DB

    When I fill up the fields with the following user information

  | First Name | Last Name | Email
  | Nezz       | Sari      | nezz@gmail.com

    Then This information should be stored properly in the database

  @econsent
Scenario: Verify information from the database
  When I send the query to update econsent page first name, last name and email
  Then The actual output from the query should match the expected one that I sent to query









