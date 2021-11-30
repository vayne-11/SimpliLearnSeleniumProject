package pageObjects;

import helpers.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseTest {
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Order history and details')]")
    private WebElement orderDetailsLink;

    @FindBy(how = How.XPATH, using = "//*[@title='View my shopping cart']")
    private WebElement viewCartLink;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void viewCart() {
        viewCartLink.click();
    }

    public boolean verifyPageLoaded() {
        return (orderDetailsLink.isDisplayed());
    }
}