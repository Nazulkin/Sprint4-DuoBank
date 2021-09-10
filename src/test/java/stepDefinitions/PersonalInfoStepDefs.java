package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.PreApprovalDetaisPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PersonalInfoStepDefs {

    String url = ConfigReader.getProperty("url");
    LoginPage loginPage = new LoginPage();
    PreApprovalDetaisPage preApprovalDetaisPage = new PreApprovalDetaisPage();

    String realtorInfo;
    String estPurchase;
    String downPayment ;
    String downPaymentPercentage;


    @Given("The user is on the homepage")
    public void theUserIsOnTheHomepage() {
        System.out.println("Background");
        Driver.getDriver().get(url);

    }

    @When("The user enters the valid credentials as {string} and {string} for password")
    public void theUserEntersTheValidCredentialsAsAndForPassword(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("The user should be able to login and selects the Mortgage Application Page")
    public void theUserShouldBeAbleToLoginAndSelectsTheMortgageApplicationPage() {
        Assert.assertEquals("http://duobank-env.eba-hjmrxg9a.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());
        loginPage.mortgageApplicationMenu.click();

    }


    @When("The user enters the preapproval page with the following information")
    public void theUserEntersThePreapprovalPageWithTheFollowingInformation(List<Map<String, String>> dataTable) throws SQLException {
        realtorInfo = dataTable.get(0).get("Realtor Info");
        estPurchase = dataTable.get(0).get("Estimated Purchase Price");
        downPayment = dataTable.get(0).get("Down Payment Amount");
        downPaymentPercentage = dataTable.get(0).get("Down Payment Percentage");

        PreApprovalDetaisPage preApprovalDetailsPage = this.preApprovalDetaisPage;

        preApprovalDetailsPage.realtorInfo.sendKeys(realtorInfo);
        preApprovalDetailsPage.estimatedPrice.sendKeys(estPurchase);
        preApprovalDetailsPage.downPayment.sendKeys(downPayment);
        preApprovalDetailsPage.downPaymentPercent.sendKeys(downPaymentPercentage);
        preApprovalDetailsPage.next.click();



    }
//    @Then("The information should be stored correctly in the database")
//    public void theInformationShouldBeStoredCorrectlyInTheDatabase() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("proceed to the Personal Info Page")
//    public void proceedToThePersonalInfoPage() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }

