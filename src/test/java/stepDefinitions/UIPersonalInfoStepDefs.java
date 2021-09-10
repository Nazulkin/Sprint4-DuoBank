package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.PersonalInformationPage;
import pages.PreApprovalDetaisPage;
import uitests.PersonalInformationTests;
import uitests.PreApprovalDetailsTests;
import uitests.TestBase;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UIPersonalInfoStepDefs extends  {

    LoginPage loginPage = new LoginPage();

    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        System.out.println("Background");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @When("The user enters the valid credentials")
    public void theUserEntersTheValidCredentials() {

        new LoginPage().login(ConfigReader.getProperty("username2"), ConfigReader.getProperty("password2"));
    }

    @Given("The user enters the valid credentials and goes to personal info page")
    public void theUserEntersTheValidCredentialsAndGoesToPersonalInfoPage() {
        new PersonalInformationTests().loginSetup();
    }
//    @Then("The user should be able to login and go to the Personal Info Page")
//    public void theUserShouldBeAbleToLoginAndGoToThePersonalInfoPage() {
//
//        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php"));
//
//        loginPage.mortgageApplicationMenu.click();
//
//        PreApprovalDetailsTests preApproval = new PreApprovalDetailsTests();
//        preApproval.positiveTestPreApprovalDetails();
//    }

    @When("The user enters with valid personal page credentials and proceeds to next page")
    public void theUserEntersWithValidPersonalPageCredentials() {

        new PersonalInformationTests().verifyWithValidCredentials();

    }
    }







