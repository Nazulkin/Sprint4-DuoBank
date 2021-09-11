Feature: Personal Info Page related features

Background: Common steps for all scenarios
  Given I am on the Personal Info Page

   @personlinfo_ui
  Scenario: Entering the information with valid credentials to continue to the next page
    When The user enters all the required information with valid credentials
    Then The user should be able to go to the next page

  @personlinfo_ui
    Scenario: Trying to proceed to the next page without entering any credentials
      When The user tries to proceed to next page by clicking next button
      Then User should not be able to land on the next page












