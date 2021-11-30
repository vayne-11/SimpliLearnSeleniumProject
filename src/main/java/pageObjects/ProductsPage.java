package pageObjects;

import helpers.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helpers.Helpers.mouseOver;
import static helpers.Helpers.waitForVisibility;

public class ProductsPage extends BaseTest {
    private static String shippingCost = "2.00";

    @FindBy(how = How.XPATH, using = "//a[contains(@href, 'id_category=3')]")
    private WebElement womensClothesLink;

    @FindBy(how = How.XPATH, using = "//a[contains(@href, 'http://automationpractice.com/index.php?id_category=8&controller=category')]")
    private WebElement womensDressesLink;

    @FindBy(how = How.XPATH, using = "//a[text()='List']")
    private WebElement listViewLink;

    @FindBy(how = How.CLASS_NAME, using = "ajax_block_products_total")
    private WebElement modalTotalProductsPrice;

    @FindBy(how = How.CLASS_NAME, using = "ajax_cart_shipping_cost")
    private WebElement modalShippingPrice;

    @FindBy(how = How.CLASS_NAME, using = "ajax_block_cart_total")
    private WebElement modalTotalPrice;

    @FindBy(how = How.XPATH, using = "//*[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void viewDressList() {
        mouseOver(womensClothesLink);
        womensDressesLink.click();
        listViewLink.click();
    }

    public String addExpensiveDressToCart() {
        String expensiveDress = getMostExpensiveItem();
        String path = "//*[contains(@class, 'ajax_add_to_cart_button')]/../../div/span[contains(text(), " + expensiveDress + ")]/../.././div[2]/a";
        WebElement addToCart = driver.findElement(By.xpath(path));
        addToCart.click();
        return expensiveDress;
    }

    public void verifyCartUpdated(String expectedTotalProductsPrice, String expectedShippingPrice, String totalPrice) {
        waitForVisibility(modalTotalProductsPrice);
        assert (modalTotalProductsPrice.getText().endsWith(expectedTotalProductsPrice));
        assert (modalShippingPrice.getAttribute("innerText").endsWith(expectedShippingPrice)); // Using innerText, getText returning empty string
        assert (modalTotalPrice.getAttribute("innerText").endsWith(totalPrice)); // Using innerText, getText returning empty string
    }

    public void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }

    private String getMostExpensiveItem() {
        List<WebElement> allSpans = driver.findElements(By.xpath("//*[@itemprop='price']"));
        ArrayList<String> al = new ArrayList<String>();

        for (int i = 0; i < allSpans.size(); i++) {
            al.add(allSpans.get(i).getText().replace("$", ""));
        }

        Collections.sort(al);
        String last = al.get(al.size() - 1);
        System.out.println("The most expensive item is: " + last);
        return last;
    }
}
