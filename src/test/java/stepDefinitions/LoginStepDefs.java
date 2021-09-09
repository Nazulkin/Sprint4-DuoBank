package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {

  @Given("I have logged in to Duobank")
  public void iHaveLoggedInToDuobank() {
    LoginPage loginPage = new LoginPage();
    Driver.getDriver().navigate().to(ConfigReader.getProperty("url"));
    loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    Driver.getDriver().findElement(By.xpath("//a[@href='mortagage.php']"));


  }

  @When("I am on Summary Page")
  public void iAmOnSummaryPage() {

    LoginPage loginPage = new LoginPage();

    loginPage.mortgageApplicationMenu.click();

    /*PreApprovalDetailsTests preApproval = new PreApprovalDetailsTests();
    preApproval.positiveTestPreApprovalDetails();
    PersonalInformationTests personalInformationTests = new PersonalInformationTests();
    personalInformationTests.verifyWithValidCredentials();
    ExpensesTests expensesTests = new ExpensesTests();
    expensesTests.verifyWithRentCheckBox();
    EmploymentAndIncomeTests employmentAndIncomeTests = new EmploymentAndIncomeTests();
    employmentAndIncomeTests.verifyWithValidDataEmploymentAndIncome();
    CreditReportTest creditReportTest = new CreditReportTest();
    creditReportTest.positiveAnswerForCreditReport();
    EconsentTests econsentTests = new EconsentTests();
    econsentTests.EconsentWithValidCredentials();
    Thread.sleep(3000);
    */

  }


  @Then("There are {int} edit buttons")
  public void thereAreEditButtons(Integer int1) {

  }

  }



