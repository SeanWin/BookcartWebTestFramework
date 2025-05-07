package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.LoginPage;
import utils.TestContextSetup;

public class LoginPageStepDefinition {

    LoginPage loginPage;
    TestContextSetup testContextSetup;

    public LoginPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("I enter {string} into the Username field")
    public void i_enter_into_the_username_field(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter {string} into the Password field")
    public void i_enter_into_the_password_field(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the Login page")
    public void i_should_be_redirected_to_the_login_page() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Login", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("verify the account has been created with login")
    public void verify_the_account_has_been_created_with_login() throws InterruptedException {
        Thread.sleep(2000);
        i_enter_into_the_username_field(testContextSetup.generatedUsername);
        i_enter_into_the_password_field(testContextSetup.password);
        i_click_the_login_button();
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Home", 3);
        Assert.assertTrue(titleMatches);
    }

}
