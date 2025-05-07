package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.RegisterPage;
import utils.TestContextSetup;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RegisterPageStepDefinition {

    TestContextSetup testContextSetup;
    RegisterPage registerPage;

    public  RegisterPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.registerPage = testContextSetup.pageObjectManager.getRegisterPage();
    }

    @Given("I fill in the registration form with a unique username and the following details")
    public void i_fill_in_the_registration_form_with_a_unique_username_and_the_following_details(DataTable dataTable) {
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

    @When("I fill in the registration form with the following details")
    public void i_fill_in_registration_form_with_static_username(DataTable dataTable) {
        Map<String, String> formDetails = dataTable.asMaps().getFirst();
        String firstName = formDetails.get("firstName");
        String lastName = formDetails.get("lastName");
        String username = formDetails.get("username");
        String password = formDetails.get("password");
        String confirmPassword = formDetails.get("confirmPassword");

        registerPage.enterFirstnameSlow(firstName);
        registerPage.enterLastnameSlow(lastName);
        registerPage.enterUsernameSlow(username);
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
        Assert.assertEquals("Registration successful", registerPage.getToastMessage());
    }

    @Then("I should see all relevant registration error messages")
    public void i_should_see_all_error_messages() {
        List<String> actualErrors = registerPage.getAllErrorMessages();

        Assert.assertTrue(actualErrors.contains("User Name is not available"));
        Assert.assertTrue(actualErrors.contains("Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number"));
        Assert.assertTrue(actualErrors.contains("Password do not match"));
        }
}
