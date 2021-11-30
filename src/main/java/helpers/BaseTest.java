package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver = null;
    public static int timeout = 30;
    public static int wait = 10;

    public static WebDriver CreateWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("headless");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                closeBrowser();
            }
        });

        return driver;
    }

    public static WebDriver getDriver() {
        CreateWebDriver();
        return driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }
}