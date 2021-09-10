package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBPersonalInfoStepDefs {

    String expectedFirstName = "Margarito";
    String expectedLastName = "Mills";
    String expectedEmail = "shannon.brakus@gmail.com";
    Map<String, Object> mapInfo;

    String expectedNewFirstName = "Kurush";
    String expectedNewLastName = "Yusufiy";
    String expectedNewEmail = "kurush.yusufiy@gmail.com";
    Map<String, Object> mapUpdatedInfo;

    List<List<Object>>  actualUsersResult;

    @When("The user sent a query to database for user information for personal info page")
    public void theUserSentAQueryToDatabaseForUserInformationForPersonalInfoPage(String query) {
        List<Map<String, Object>> listOfMaps = DBUtility.getQueryResultListOfMaps(query);
        mapInfo = listOfMaps.get(0);
    }
    @Then("The user information for personal info page should match")
    public void theUserInformationForPersonalInfoPageShouldMatch() {
        Assert.assertEquals(mapInfo.get("b_firstName"), expectedFirstName);
        Assert.assertEquals(mapInfo.get("b_lastName"), expectedLastName);
        Assert.assertEquals(mapInfo.get("b_email"), expectedEmail);



    }
    @When("The user sent update query to the database for user information for personal info page from database")
    public void theUserSentUpdateQueryToTheDatabaseForUserInformationForPersonalInfoPageFromDatabase(String updatedQuery) throws SQLException {
        DBUtility.updateQuery(updatedQuery);
        String selectedQuery = "select * from tbl_mortagage where id = '566'";
        List<Map<String, Object>> listOfMaps = DBUtility.getQueryResultListOfMaps(selectedQuery);
        mapUpdatedInfo = listOfMaps.get(0);

    }
    @Then("The user information for personal info page be updated")
    public void theUserInformationForPersonalInfoPageBeUpdated() {
        Assert.assertEquals(mapUpdatedInfo.get("b_firstName"), expectedNewFirstName);
        Assert.assertEquals(mapUpdatedInfo.get("b_lastName"), expectedNewLastName);
        Assert.assertEquals(mapUpdatedInfo.get("b_email"), expectedNewEmail);

    }

    @When("I send a query to get the first {int} users from mortgage table")
    public void i_send_a_query_to_get_the_first_users_from_mortgage_table(Integer count) {
        actualUsersResult = DBUtility.getQueryResultAsListOfLists("select id, b_firstName,b_middleName, b_lastName, b_email, b_dob, b_ssn, b_martial, b_cell from tbl_mortgage limit"+count+"");

    }
    @Then("The result should be the following")
    public void theResultShouldBeTheFollowing(List<List<Object>> expectedResult) {
    }
}
