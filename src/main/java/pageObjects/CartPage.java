package pageObjects;

import helpers.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static helpers.Helpers.waitForVisibility;

public class CartPage extends BaseTest {
    @FindBy(how = How.ID, using = "total_price")
    private WebElement cartGrandTotal;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getCartTotal() {
        return cartGrandTotal.getText();
    }

    public void verifyCartTotal(String cartTotal) {
        waitForVisibility(cartGrandTotal);
        assert (cartGrandTotal.getText().equals(cartTotal));
    }
}
