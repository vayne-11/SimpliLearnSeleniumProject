package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.TestData;
import helpers.BaseTest;
import pageObjects.AuthenticationPage;
import pageObjects.CartPage;
import pageObjects.ProductsPage;
import pageObjects.MyAccountPage;

public class ProductSteps extends BaseTest {
    AuthenticationPage authenticationPage;
    ProductsPage productsPage;
    CartPage cartPage;
    MyAccountPage myAccountPage;

    String dressPrice;
    String cartTotal;

    @Given("^I have added an item to the cart$")
    public void i_have_added_an_item_to_the_cart() throws Throwable {
        authenticationPage = new AuthenticationPage(driver);
        driver.navigate().to(authenticationPage.pageUrl);
        authenticationPage.loginInAs("testuser1@mailinator.com", "automation_practice_pass");
        i_add_the_most_expensive_dress_to_the_cart();
        i_should_see_the_cart_update();
        productsPage.proceedToCheckout();
        cartTotal = cartPage.getCartTotal();
    }

    @When("^I add the most expensive dress to the cart$")
    public void i_add_the_most_expensive_dress_to_the_cart() throws Throwable {
        productsPage = new ProductsPage(driver);
        productsPage.viewDressList();
        dressPrice= productsPage.addExpensiveDressToCart();
    }

    @Then("^I should see the cart update$")
    public void i_should_see_the_cart_update() throws Throwable {
        double d = Double.parseDouble(dressPrice);
        double s = Double.parseDouble(TestData.SHIPPING);

        String total = String.valueOf(d + s);

        productsPage.verifyCartUpdated(dressPrice, TestData.SHIPPING, total);
    }


    @Then("^I should see my shopping cart$")
    public void i_should_see_my_shopping_cart() throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        cartPage = new CartPage(driver);
        myAccountPage.viewCart();
        cartPage.verifyCartTotal(cartTotal);
    }

}
