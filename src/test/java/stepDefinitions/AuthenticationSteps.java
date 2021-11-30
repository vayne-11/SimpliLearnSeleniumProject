package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.BaseTest;
import pageObjects.AuthenticationPage;

import static data.TestData.*;

public class AuthenticationSteps extends BaseTest {
    AuthenticationPage authenticationPage;

    @Given("^I am on the sign (in|up) page$")
    public void i_am_on_the_sign_in_page(String page) throws Throwable {
        authenticationPage = new AuthenticationPage(driver);
        driver.navigate().to(authenticationPage.pageUrl);
    }

    @When("^I sign in with valid credentials$")
    public void i_sign_in_with_valid_credentials() throws Throwable {
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.loginInAs(EXISTING_USER, EXISTING_PASS);
    }

    @Given("^I logout$")
    public void i_logout() throws Throwable {
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.logoutAsUser();
    }

    @When("^I create a new account$")
    public void i_create_a_new_account() throws Throwable {
        authenticationPage = new AuthenticationPage(driver);
        authenticationPage.createAccount(NEW_EMAIL);
    }
}
