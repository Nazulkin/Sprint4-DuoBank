package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.EconsentPage;
import pages.LoginPage;
import pages.SignUpPage;
import uitests.*;
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

    @Given("I am on Econsent page")
    public void i_am_on_econsent_page() {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            LoginPage loginPage = new LoginPage();

        do {
            loginPage.login(ConfigReader.getProperty("username3"), ConfigReader.getProperty("password3"));
        }
        while (!driver.getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));

        loginPage.mortgageApplicationMenu.click();

        PreApprovalDetailsTests preApproval = new PreApprovalDetailsTests();
        preApproval.positiveTestPreApprovalDetails();
        PersonalInformationTests personalInformationTests = new PersonalInformationTests();
        personalInformationTests.verifyWithValidCredentials();
        ExpensesTests expensesTests = new ExpensesTests();
        expensesTests.verifyWithRentCheckBox();
        EmploymentAndIncomeTests employmentAndIncomeTests = new EmploymentAndIncomeTests();
        employmentAndIncomeTests.verifyWithValidDataEmploymentAndIncome();
        CreditReportTest creditReportTest = new CreditReportTest();
        creditReportTest.positiveAnswerForCreditReport();
    }


        }

        @When("I fill up the fields with the following user information")
        public void iFillUpTheFieldsWithTheFollowingUserInformation(List<Map<String, String>> dataTable) throws SQLException {

            firstName = dataTable.get(0).get("First Name");
            lastName = dataTable.get(0).get("Last Name");
            email = dataTable.get(0).get("Email");

            EconsentPage econsentPage = new EconsentPage();

            econsentPage.firsName.sendKeys(firstName);
            econsentPage.lastName.sendKeys(lastName);
            econsentPage.email.sendKeys(email);
        }

        @Then("This information should be stored correctly in the database")
        public void thisInformationShouldBeStoredCorrectlyInTheDatabase() throws SQLException {


            String query = "select first_name, last_name, email where email = '" + email + "'";


            List<Map<String, Object>> queryResultListOfMaps = DBUtility.getQueryResultListOfMaps(query);
            Map<String, Object> map = queryResultListOfMaps.get(0);

            System.out.println(map);

            Assert.assertEquals(firstName, (String) (map.get("first_name")));
            Assert.assertEquals(lastName, (String) (map.get("last_name")));
            Assert.assertEquals(email, ((String) (map.get("email"))).toLowerCase());
        }
    }
}
