
Feature: Personal Info Page related features

Background: Common steps for all scenarios
  Given The user is on the homepage
#  When The user enters the valid credentials
#  Then The user should be able to login and go to the Personal Info Page

  @smoke @regression
  Scenario: Login with valid credentials and go to Personal Info Page
    Given The user enters the valid credentials and goes to personal info page

    Scenario: Entering with valid credentials for Personal Info Page
      When The user enters with valid personal page credentials and proceeds to next page





