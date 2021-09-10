@temp
  Feature: Database related tests for Personal Info Page

    @db_only
    Scenario: Verify the user information for personal info page from database
      When The user sent a query to database for user information for personal info page
      """
        select * from tbl_mortagage where id = "556"
      """
      Then The user information for personal info page should match

     @db_only
    Scenario: Updated the user information for personal info page from database
      When The user sent update query to the database for user information for personal info page from database
    """
    update tbl_mortagage set b_firstName='Kurush',
    b_lastName='Yusufiy', b_email='kurush.yusufiy@gmail.com' where id='556'
    """
      Then The user information for personal info page be updated

    @db_only
    Scenario: Verify the first 5 users in users table
      When I send a query to get the first 5 users from mortgage table
      Then The result should be the following
        | 0   |         |         |       |                             |            |             |           |             |
        | 314 | teuejhd | hjkf    | jkhkj | dsfsfds@gmail.com           | 1966-01-02 | 435-34-5435 | Married   | 454354-3534 |
        | 315 | Edmundo | Marline | Hintz | micheline.flatley@gmail.com | 2000-01-01 | 754-16-2461 | Separated | 156-02-5830 |
        | 333 |         |         |       |                             |            |             |           |             |
        | 518 | Malik   | Tamala  | Hane  | kerry.kihn@yahoo.com        | 2000-01-01 | 661-89-1438 | Married   | 217-04-8551 |