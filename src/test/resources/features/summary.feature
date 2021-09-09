Feature: Test Summary Page


  Background: login using provided credentials
    Given I have logged in to Duobank
    When I am on Summary Page


  @matt
  Scenario: Verify Summary Page buttons

    Then There are 6 edit buttons



