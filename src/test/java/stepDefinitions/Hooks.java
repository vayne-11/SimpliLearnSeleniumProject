package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.BaseTest;
import org.openqa.selenium.WebDriver;

public class Hooks extends BaseTest {
    public static WebDriver driver;

    @Before()
    public void setUp(Scenario scenario) throws Exception {
        System.out.println("Start Browser");
        driver = BaseTest.getDriver();
    }

    @After()
    public void tearDown(Scenario scenario) throws Exception {
        System.out.println("Closing browser");
        BaseTest.closeBrowser();
    }
}
