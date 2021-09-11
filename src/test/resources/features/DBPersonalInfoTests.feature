Feature: Database related tests for Personal Info Page

  @personalinfo_db @db_only
  Scenario: Verify the mortgage table options Page columns
    When I send a query to the database to retrieve the info of columns in the Personal Info Page table
    """
    select * from tbl_mortagage where id = '556'
    """
    Then The columns I got should match my expected column
  @personalinfo_db @db_only
  Scenario: Verify the first 5 users in the mortagage table
      When I send a query to get the first 5 users from the mortagage table
      Then The result should be the as shown below
        | 0   |         |         |       |                             |            |             |           |             |
        | 314 | teuejhd | hjkf    | jkhkj | dsfsfds@gmail.com           | 1966-01-02 | 435-34-5435 | Married   | 454354-3534 |
        | 315 | Edmundo | Marline | Hintz | micheline.flatley@gmail.com | 2000-01-01 | 754-16-2461 | Separated | 156-02-5830 |
        | 333 |         |         |       |                             |            |             |           |             |
        | 518 | Malik   | Tamala  | Hane  | kerry.kihn@yahoo.com        | 2000-01-01 | 661-89-1438 | Married   | 217-04-8551 |

    Scenario:

