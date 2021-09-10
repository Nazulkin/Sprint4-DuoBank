@temp
Feature: Personal Info Page related features

Background: Common steps for all scenarios
  Given The user is on the homepage

  Scenario Outline: Login using valid credentials through examples

    When The user enters the valid credentials as "<username>" and "<password>" for password
    Then The user should be able to login and selects the Mortgage Application Page

    Examples: valid username and password list
      | username             | password    |
      | gularochka@gmail.com | duotech2021 |
      | phatamov8@gmail.com  | phatamov8   |
      | wtess9539@gmail.com  | 22222       |
      | Nazulka@gmail.com    | Toreador5!  |
      | duo10_team@gmail.com | Duo10_Team  |


    Scenario: Fill out PreApproval Page

      When The user enters the preapproval page with the following information
        | Realtor Info              | Estimated Purchase Price | Down Payment Amount | Down Payment Percentage |
        | testingkurush99@gmail.com | 600000                   | 100000              | 16                      |


#      Then The information should be stored correctly in the database
#      And proceed to the Personal Info Page
