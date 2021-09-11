package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtility;

import java.util.List;

public class EmployementAndIncomeStepDefs {
    String expectedName;
    Object actualName;
    List<List<Object>> actualUsersResult;

    @When("I sent a query to database for employer name from the Employment Information")
    public void i_sent_a_query_to_database_for_employer_name_from_the_employment_information ( String docString ) {
        System.out.println ( "Sending query" );
        List<List<Object>> queryResultAsListOfList = DBUtility.getQueryResultAsListOfLists
                ( "select * from loan.tbl_mortagage" );
        expectedName = "Wonder Woman";
        actualName = queryResultAsListOfList.get ( 148 ).get ( 35 );
    }

    @Then("The employer name should match")
    public void the_employer_name_should_match ( ) {
        System.out.println ( "Verify the result " );
        if ( expectedName.equals ( actualName ) ) {
            System.out.println ( "System is working perfect" );
        } else {
            System.out.println ( "System needs to be fixed!" );
        }
        System.out.println ( "expected name: " + expectedName );
        System.out.println ( "actual name:   " + actualName );
    }

    @When("I send a query to get the first {int} applicants information from tbl_mortagage table")
    public void i_send_a_query_to_get_the_first_applicants_information_from_tbl_mortagage_table ( Integer count ) {

        actualUsersResult = DBUtility.getQueryResultAsListOfLists ( "select id, employer_name, position, city, state  from loan.tbl_mortagage limit" + count + "" );
    }

    @Then("The result should be as following")
    public void the_result_should_be_as_following ( List<List<Object>> expectedResult ) {
        for ( int i = 0; i < expectedResult.size ( ); i++ ) {
            for ( int j = 0; j < expectedResult.get ( i ).size ( ); j++ ) {
                Assert.assertEquals ( expectedResult.get ( i ).get ( j ), String.valueOf ( actualUsersResult.get ( i ).get ( j ) ) );
            }
        }
    }


}
