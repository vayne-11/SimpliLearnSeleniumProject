package stepDefinitions;

import cucumber.api.java.en.Then;
import helpers.BaseTest;
import pageObjects.MyAccountPage;

public class MyAccountSteps extends BaseTest {
    MyAccountPage myAccountPage;

    @Then("^I should be on my account page$")
    public void i_should_be_logged_in() throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.verifyPageLoaded();
    }
}
