@employmentAndIncome @db_only
Feature: Operation on Expenses page.


  @smoke @regression
 Scenario: Verify the user and relater information from database
    When I sent a query to database for employer name from the Employment Information
    """
     select * from loan.tbl_mortagage
    """
    Then The employer name should match

  @regression
  Scenario: Verifying Employment Information from the 10 applicants in tbl_mortagage table
    When I send a query to get the first 10 applicants information from tbl_mortagage table
    Then The result should be as following
      | 0   | George   | Chief executive officer          | Albuquerque   | NM |
      | 314 | Joshua   | Solutions engineer               | Detroit       | NY |
      | 315 | Timothy  | Optometrist                      | Portland      | NY |
      | 333 | Bob      | Chief marketing officer          | Oklahoma City | NY |
      | 518 | Raymond  | Site reliability engineer        | Denver        | NY |
      | 519 | Larry    | Podiatrist                       | San Francisco | NY |
      | 520 | Nicholas | Data warehouse architect         | Columbus      | NY |
      | 521 | Justin   | Cardiologist                     | San Diego     | NY |
      | 522 | Gregory  | Director of information security | San Antonio   | NY |
      | 523 | Patrick  | Software architect               | Phoenix       | NY |


