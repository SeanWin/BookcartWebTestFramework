package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;
    LoginPage loginPage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
        this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
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

    @Then("I should be redirected to the Home page")
    public void i_should_be_redirected_to_the_home_page() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Home", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("I should see {string} in the top nav bar")
    public void i_should_see_in_the_top_nav_bar(String expectedUsername) {
        System.out.println(homePage.getProfileUsername());
        Assert.assertEquals(homePage.getProfileUsername(), expectedUsername);
    }
}
