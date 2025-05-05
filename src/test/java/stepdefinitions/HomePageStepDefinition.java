package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
    }

    @Given("I am on the Login page")
    public void i_am_on_the_login_page() {
        homePage.clickLoginPageButton();
    }

    @Then("I should be redirected to the Home page")
    public void i_should_be_redirected_to_the_home_page() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Home", 3);
        Assert.assertTrue(titleMatches);
    }
}
