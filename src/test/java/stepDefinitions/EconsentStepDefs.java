package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class EconsentStepDefs {

    String firstName;
    String lastName;
    String email;

    @Given("I am on Econsent page")
    public void iAmOnEconsentPage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));


}
    @When("I fill up the fields with the following user information")
public void iFillUpTheFieldsWithTheFollowingUserInformation(io.cucumber.datatable.DataTable dataTable) {

}
}
