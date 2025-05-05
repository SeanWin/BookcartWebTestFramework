package stepdefinitions;

import io.cucumber.java.en.When;
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

}
