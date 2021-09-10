package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditReportPage extends PageBase{
    @FindBy(xpath="//label[@id='creditreport1']")
    public WebElement yesCheckBox;
    @FindBy(xpath="//label[@for='creditreport2']")
    public WebElement noCheckBox;
    @FindBy(xpath = "//a[@id=steps-uid-0]") //////*[@id="steps-uid-0"]/div[3]/ul/li[2]/a
    public WebElement nextButton;
}
