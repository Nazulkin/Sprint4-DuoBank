package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EconsentPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DBUtility;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EconsentStepDefs {


    String firstName;
    String lastName;
    String email;

    String expectedFirstName;
    String expectedLastName;
    String expectedEmail;
    String query;

    @Given("I am on Econsent page")
    public void iAmOnEconsentPage() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();

        do {
            loginPage.login(ConfigReader.getProperty("username3"), ConfigReader.getProperty("password3"));
        }
        while (!Driver.getDriver().getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));

        loginPage.mortgageApplicationMenu.click();





    }

    @When("I fill up the fields with the following user information")
    public void iFillUpTheFieldsWithTheFollowingUserInformation(List<Map<String, String>> dataTable) {

        firstName = dataTable.get(0).get("First Name");
        lastName = dataTable.get(0).get("Last Name");
        email = dataTable.get(0).get("Email");

        EconsentPage econsentPage = new EconsentPage();

        econsentPage.firsName.sendKeys(firstName);
        econsentPage.lastName.sendKeys(lastName);
        econsentPage.email.sendKeys(email);
        econsentPage.agreeButton.click();
        econsentPage.nextButton.click();


    }
    @Then("This information should be stored properly in the database")
    public void thisInformationShouldBeStoredProperlyInTheDatabase() {

        String query = "select eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email from tbl_mortagage where eConsent_declarer_Email = '" +email+"'";


        List<Map<String, Object>> queryResultListOfMaps = DBUtility.getQueryResultListOfMaps(query);
        Map<String, Object> map = queryResultListOfMaps.get(0);

        System.out.println(map);

        Assert.assertEquals(firstName, (String) (map.get("eConsent_declarer_FirstName")));
        Assert.assertEquals(lastName, (String) (map.get("eConsent_declarer_LastName")));
        Assert.assertEquals(email, ((String) (map.get("eConsent_declarer_Email"))).toLowerCase());

    }



    @When("I send the query to update econsent page first name, last name and email")
    public void iSendTheQueryToUpdateEconsentPageFirstNameLastNameAndEmail() {
        expectedFirstName = "Cameron";
        expectedLastName = "Parisian";
        expectedEmail = "dalton.schmidt@hotmail.com";


        query = "select * from tbl_mortagage where eConsent_declarer_Email = '" + expectedEmail + "'";

    }


    @Then("The actual output from the query should match the expected one that I sent to query")
    public void theActualOutputFromTheQueryShouldMatchTheExpectedOneThatISentToQuery() {
        List<Map<String, Object>> listOfMaps = DBUtility.getQueryResultListOfMaps(query);
        Map<String, Object> map = listOfMaps.get(0);
        Assert.assertEquals(map.get("eConsent_declarer_Email"), expectedEmail);
        Assert.assertEquals(map.get("eConsent_declarer_FirstName"), expectedFirstName);
        Assert.assertEquals(map.get("eConsent_declarer_LastName"), expectedLastName);





}
}
