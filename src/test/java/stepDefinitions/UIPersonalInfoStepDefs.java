package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.PersonalInformationPage;
import uitests.PreApprovalDetailsTests;
import utilities.ConfigReader;
import utilities.Driver;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UIPersonalInfoStepDefs {

    @Given("I am on the Personal Info Page")
    public void iAmOnThePersonalInfoPage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();

        loginPage.login(ConfigReader.getProperty("username2"), ConfigReader.getProperty("password2"));

        loginPage.mortgageApplicationMenu.click();
        PreApprovalDetailsTests preApproval = new PreApprovalDetailsTests();
        preApproval.positiveTestPreApprovalDetails();
    }
    @When("The user enters all the required information with valid credentials")
    public void theUserEntersAllTheRequiredInformationWithValidCredentials() {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        Faker faker = new Faker();

        if (!personalInformationPage.coBorrowerNoCheckBox.isSelected()) {
            personalInformationPage.coBorrowerNoCheckBox.click();
        }

        personalInformationPage.firstName.sendKeys(faker.name().firstName());

        personalInformationPage.middleName.sendKeys(faker.name().firstName());

        personalInformationPage.lastName.sendKeys(faker.name().lastName());

        Select selectBoxSuffix = new Select(personalInformationPage.suffixDropDownList);
        selectBoxSuffix.selectByIndex((int) (1 + (Math.random() * 5)));

        personalInformationPage.email.sendKeys(faker.internet().emailAddress());

        personalInformationPage.dateOfBirth.sendKeys("01012000");

        personalInformationPage.ssn.sendKeys(faker.number().digits(9));

        Select selectBoxStatus = new Select(personalInformationPage.martialStatus);
        selectBoxStatus.selectByIndex((int) (1 + (Math.random() * 3)));

        personalInformationPage.cellPhone.sendKeys(faker.phoneNumber().cellPhone());

        personalInformationPage.homePhone.sendKeys(faker.phoneNumber().phoneNumber());

        if (!personalInformationPage.privacyPolicyCheckBox.isSelected()) {
            personalInformationPage.privacyPolicyCheckBox.click();
        }



    }
    @Then("The user should be able to go to the next page")
    public void theUserShouldBeAbleToGoToTheNextPage() {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        personalInformationPage.nextButton.click();

    }

    @When("The user tries to proceed to next page by clicking next button")
    public void theUserTriesToProceedToNextPageByClickingNextButton() {
        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        personalInformationPage.nextButton.click();

    }
    @Then("User should not be able to land on the next page")
    public void userShouldNotBeAbleToLandOnTheNextPage() {

    }
}










