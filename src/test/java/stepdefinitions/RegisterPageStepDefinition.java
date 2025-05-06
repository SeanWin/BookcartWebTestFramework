package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.RegisterPage;
import utils.TestContextSetup;

import java.util.Map;
import java.util.Random;

public class RegisterPageStepDefinition {

    TestContextSetup testContextSetup;
    RegisterPage registerPage;

    public  RegisterPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.registerPage = testContextSetup.pageObjectManager.getRegisterPage();
    }

    @Given("I fill in the registration form with the following details")
    public void i_fill_in_the_registration_form_with_the_following_details(DataTable dataTable) {
        Map<String, String> formDetails = dataTable.asMaps().getFirst();
        String firstName = formDetails.get("firstName");
        String lastName = formDetails.get("lastName");
        String username = formDetails.get("username");
        String password = formDetails.get("password");
        String confirmPassword = formDetails.get("confirmPassword");
        String uniqueUsername = username + String.format("%05d", new Random().nextInt(100000));
        testContextSetup.generatedUsername = uniqueUsername;
        testContextSetup.password = password;

        registerPage.enterFirstnameSlow(firstName);
        registerPage.enterLastnameSlow(lastName);
        registerPage.enterUsernameSlow(uniqueUsername);
        registerPage.enterPasswordSlow(password);
        registerPage.enterConfirmPasswordSlow(confirmPassword);
        registerPage.clickMaleRadioButton();
    }

    @When("I click the Register button")
    public void i_click_the_register_button() {
        registerPage.clickRegisterButton();
    }

    @Then("I should see the successful registration toast")
    public void i_should_see_the_successful_registration_toast() {
        Assert.assertEquals(registerPage.getToastMessage(), "Registration successful");
    }
}
