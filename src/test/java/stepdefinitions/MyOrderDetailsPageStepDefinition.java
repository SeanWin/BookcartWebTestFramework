package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageobjects.MyOrderDetailsPage;
import utils.TestContextSetup;

public class MyOrderDetailsPageStepDefinition {

    TestContextSetup testContextSetup;
    MyOrderDetailsPage myOrderDetailsPage;

    public MyOrderDetailsPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.myOrderDetailsPage = testContextSetup.pageObjectManager.getMyOrderDetailsPage();
    }

    @Then("I should be redirected to the My Order Details page")
    public void iShouldBeRedirectedToTheMyOrdersPage() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("My Order Details", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("I see my latest order listed with today's date and total {string}")
    public void iSeeMyLatestOrderListedWithTodaySDateAndTotal(String expectedAmount) {
        Assert.assertEquals(expectedAmount, myOrderDetailsPage.getLatestOrderTotal());
        Assert.assertEquals(testContextSetup.genericUtils.getExpectedDate(), myOrderDetailsPage.getLatestOrderDate());
    }


}
