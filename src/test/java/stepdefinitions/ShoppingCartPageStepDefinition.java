package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageobjects.ShoppingCartPage;
import utils.TestContextSetup;

import java.util.List;
import java.util.Map;

public class ShoppingCartPageStepDefinition {

    TestContextSetup testContextSetup;
    ShoppingCartPage shoppingCartPage;

    public ShoppingCartPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.shoppingCartPage = testContextSetup.pageObjectManager.getShoppingCartPage();
    }

    @Then("I should be redirected to the Shopping Cart page")
    public void iShouldBeRedirectedToTheShoppingCartPage() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Shopping Cart", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("I should see the following cart details:")
    public void iShouldSeeTheFollowingCartDetails(DataTable dataTable) {
        List<Map<String, String>> expectedRows = dataTable.asMaps(String.class, String.class);
        System.out.println(expectedRows);
        System.out.println(shoppingCartPage.getTitles()+" "+shoppingCartPage.getPrices()+" "+shoppingCartPage.getQuantities()+" "+shoppingCartPage.getTotals() );

        List<String> actualTitles = shoppingCartPage.getTitles();
        List<String> actualPrices = shoppingCartPage.getPrices();
        List<String> actualQuantities = shoppingCartPage.getQuantities();
        List<String> actualTotals = shoppingCartPage.getTotals();

        // Ensure the counts match
        Assert.assertEquals(expectedRows.size(), actualTitles.size());

        // Iterate each row by index
        for (int i = 0; i < expectedRows.size(); i++) {
            Map<String, String> expected = expectedRows.get(i);

            Assert.assertEquals(expected.get("Title"), actualTitles.get(i));
            Assert.assertEquals(expected.get("Price"), actualPrices.get(i));
            Assert.assertEquals(expected.get("Quantity"), actualQuantities.get(i));
            Assert.assertEquals(expected.get("Total"), actualTotals.get(i));
        }
    }

    @Then("the checkout button is present")
    public void theCheckoutButtonIsPresent() {
        System.out.println(shoppingCartPage.getCheckoutButtonText());
        Assert.assertTrue(shoppingCartPage.isCheckoutButtonPresent());
    }
}
