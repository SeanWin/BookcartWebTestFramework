package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ShoppingCartPage;
import utils.TestContextSetup;

public class UserFlowStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;
    LoginPage loginPage;
    ShoppingCartPage shoppingCartPage;

    public UserFlowStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
        this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
        this.shoppingCartPage = testContextSetup.pageObjectManager.getShoppingCartPage();
    }

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        homePage.clickLoginPageButton();
    }

    @Given("I am on the register page")
    public void i_am_on_the_register_page() {
        homePage.clickLoginPageButton();
        loginPage.clickRegisterPageButton();
    }

    @Given("I am logged in with username {string} and password {string}")
    public void i_am_logged_in_with_credentials(String username, String password) {

        testContextSetup.generatedUsername = username;
        testContextSetup.password = password;

        homePage.clickLoginPageButton();

        loginPage.enterUsername(testContextSetup.generatedUsername);
        loginPage.enterPassword(testContextSetup.password);
        loginPage.clickLoginButton();
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Home", 3);
        Assert.assertTrue(titleMatches);


    }

    @Given("I am on the Home page")
    public void i_am_on_the_home_page() {
        testContextSetup.genericUtils.waitForTitle("Home", 3);
    }

    @Given("I am on the Shopping Cart page")
    public void i_am_on_the_shopping_cart_page() {
        homePage.clickCartButton();
    }

    @Given("I am on the Wishlist page")
    public void iAmOnTheWishlistPage() {
        homePage.clickWishlistPageButton();
    }

    @Given("I am on the Checkout page")
    public void iAmOnTheCheckoutPage() {
        homePage.clickCartButton();
        shoppingCartPage.clickCheckoutButton();
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Checkout", 3);
        Assert.assertTrue(titleMatches);
    }
}
