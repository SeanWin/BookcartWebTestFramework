package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
    }

    @When("I press the Logout button")
    public void i_press_the_logout_button() {
        homePage.clickProfileUsername();
        homePage.clickLogoutButton();
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

    @Then("the login page button is present")
    public void the_login_page_button_is_present() {
        Assert.assertTrue(homePage.isLoginButtonPagePresent());
    }
}
