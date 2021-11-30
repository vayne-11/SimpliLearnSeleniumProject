package pageObjects;

import helpers.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static data.TestData.*;
import static helpers.Helpers.selectOptionFromList;

public class AuthenticationPage extends BaseTest {
    public String pageUrl = BASEURL + "/index.php?controller=authentication&back=my-account";

    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    private WebElement signInLink;

    @FindBy(how = How.XPATH, using = "//a[@class='logout']")
    private WebElement signOutLink;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailAddressFld;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement passwordFld;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement signInBtn;

    @FindBy(how = How.ID, using = "email_create")
    private WebElement emailCreateFld;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(how = How.ID, using = "customer_firstname")
    private WebElement firstNameFld;

    @FindBy(how = How.ID, using = "customer_lastname")
    private WebElement lastNameFld;

    @FindBy(how = How.ID, using = "address1")
    private WebElement address1Fld;

    @FindBy(how = How.ID, using = "city")
    private WebElement cityFld;

    @FindBy(how = How.ID, using = "postcode")
    private WebElement zipCodeFld;

    @FindBy(how = How.ID, using = "phone_mobile")
    private WebElement mobileFld;

    @FindBy(how = How.ID, using = "id_state")
    private WebElement stateFld;

    @FindBy(how = How.ID, using = "submitAccount")
    private WebElement registerBtn;

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginInAs(String email, String pass) {
        emailAddressFld.sendKeys(email);
        passwordFld.sendKeys(pass);
        signInBtn.click();
    }

    public void logoutAsUser() {
        signOutLink.click();
    }

    public AuthenticationPage createAccount(String email) {
        emailCreateFld.sendKeys(email);
        createAccountBtn.click();
        firstNameFld.sendKeys(NEW_FIRSTNAME);
        lastNameFld.sendKeys(NEW_LASTNAME);
        passwordFld.sendKeys(NEW_PASS);
        address1Fld.sendKeys(NEW_ADDRESS1);
        cityFld.sendKeys(NEW_CITY);
        selectOptionFromList(stateFld, NEW_STATE);
        zipCodeFld.sendKeys(NEW_ZIP);
        mobileFld.sendKeys(NEW_MOBILE);
        registerBtn.click();
        return this;
    }
}