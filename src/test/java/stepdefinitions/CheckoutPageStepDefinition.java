package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.CheckoutPage;
import utils.TestContextSetup;

import java.util.List;
import java.util.Map;

public class CheckoutPageStepDefinition {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @When("I fill in the shipping address form with the following details:")
    public void fillInTheShippingAddressFormWithTheFollowingDetails(DataTable dataTable) throws InterruptedException {
        Thread.sleep(3500);
        Map<String, String> shippingAddressDetails = dataTable.asMaps().getFirst();
        String name = shippingAddressDetails.get("Name");
        String addressLine1 = shippingAddressDetails.get("Address Line 1");
        String addressLine2 = shippingAddressDetails.get("Address Line 2");
        String pincode = shippingAddressDetails.get("Pincode");
        String state = shippingAddressDetails.get("State");

        checkoutPage.enterName(name);
        checkoutPage.enterAddressLine1(addressLine1);
        checkoutPage.enterAddressLine2(addressLine2);
        checkoutPage.enterPincode(pincode);
        checkoutPage.enterState(state);
    }

    @When("I click the Place Order button")
    public void iClickThePlaceOrderButton() {
        checkoutPage.clickPlaceOrderButton();
    }

    @When("I leave all field in the form empty")
    public void iLeaveAllFieldInTheFormEmpty() {
        checkoutPage.leaveFieldsBlank();
    }

    @Then("I see the Order placed successfully!!! toast message")
    public void iSeeTheOrderPlacedSuccessfullyToastMessage() {
        Assert.assertEquals("Order placed successfully!!!", checkoutPage.getToastMessage());
    }

    @Then("I see the validation error messages")
    public void iSeeTheValidationErrorMessages() {
        List<String> actualErrors = checkoutPage.getAllErrorMessages();

        Assert.assertTrue(actualErrors.contains("Name is required"));
        Assert.assertTrue(actualErrors.contains("Address is required"));
        Assert.assertTrue(actualErrors.contains("Pincode is required"));
        Assert.assertTrue(actualErrors.contains("State is required"));
    }
}
