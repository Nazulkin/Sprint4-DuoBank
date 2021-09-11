package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBPersonalInfoStepDefs {



    String theExpectedFirstName = "Kurush";
    String theExpectedLastName = "Yusufiy";
    String theExpectedEmail = "kurush.yusufiy@gmail.com";

    Map<String, Object> mapInfo;

    List<List<Object>> actualResult;



    @When("I send a query to the database to retrieve the info of columns in the Personal Info Page table")
    public void iSendAQueryToTheDatabaseToRetrieveTheInfoOfColumnsInThePersonalInfoPageTable(String docString) {
        List<Map<String, Object>> listOfMaps = DBUtility.getQueryResultListOfMaps(docString);
        mapInfo = listOfMaps.get(0);
    }
    @Then("The columns I got should match my expected column")
    public void theColumnsIGotShouldMatchMyExpectedColumn() {
        Assert.assertEquals(mapInfo.get("b_firstName"), theExpectedFirstName);
        Assert.assertEquals(mapInfo.get("b_lastName"), theExpectedLastName);
        Assert.assertEquals(mapInfo.get("b_email"), theExpectedEmail);
    }

    @When("I send a query to get the first {int} users from the mortagage table")
    public void iSendAQueryToGetTheFirstUsersFromTheMortagageTable(Integer int1) {
        actualResult = DBUtility.getQueryResultAsListOfLists("select * from tbl_mortagage limit " +int1+ "");
    }
    @Then("The result should be the as shown below")
    public void theResultShouldBeTheAsShownBelow(List<List<Object>> expectedResult) {
        for (int i = 0; i < expectedResult.size(); i++) {

            for (int j = 0; j < expectedResult.get(i).size(); j++) {
                Assert.assertEquals(expectedResult.get(i).get(j), String.valueOf(actualResult.get(i).get(j)));
            }
        }
    }


}


