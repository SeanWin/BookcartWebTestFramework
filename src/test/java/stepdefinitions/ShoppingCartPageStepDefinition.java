package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.ShoppingCartPage;
import utils.TestContextSetup;

import java.util.List;
import java.util.Map;

public class ShoppingCartPageStepDefinition {

    TestContextSetup testContextSetup;
    ShoppingCartPage shoppingCartPage;
    HomePage homePage;

    public ShoppingCartPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.shoppingCartPage = testContextSetup.pageObjectManager.getShoppingCartPage();
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
    }

    @When("I click the decrement button")
    public void i_click_the_decrement_button() throws InterruptedException {
        Thread.sleep(3500);
        shoppingCartPage.clickDecrementButton();
    }

    @When("I click the increment button")
    public void i_click_the_increment_button() throws InterruptedException {
        Thread.sleep(3500);
        shoppingCartPage.clickIncrementButton();
    }

    @When("I click the Delete item button for {string}")
    public void iClickTheDeleteItemButtonFor(String title) throws InterruptedException {
        Thread.sleep(3500);
        shoppingCartPage.clickDeleteButtonForBook(title);
    }

    @When("I click the Clear cart button")
    public void iClickTheClearCartButton() throws InterruptedException {
        Thread.sleep(3500);
        shoppingCartPage.clickClearButton();
    }

    @Then("I should be redirected to the Shopping Cart page")
    public void iShouldBeRedirectedToTheShoppingCartPage() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Shopping Cart", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("I should see the following cart details:")
    public void iShouldSeeTheFollowingCartDetails(DataTable dataTable) throws InterruptedException {
        Thread.sleep(2000);
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

    @Then("I see the One item removed from cart toast message")
    public void i_see_the_one_item_removed_from_cart_toast_message() {
        Assert.assertEquals("One item removed from cart", shoppingCartPage.getToastMessage());
    }

    @Then("quantity is updated to {int}")
    public void quantity_is_updated_to(int expectedQuantity) {
        Assert.assertEquals(expectedQuantity, shoppingCartPage.getQuantity());
    }

    @Then("the cart total is updated to {string}")
    public void the_cart_total_is_updated_to(String expectedCartTotal) {
        Assert.assertEquals(expectedCartTotal, shoppingCartPage.getCartTotal());
    }

    @Then("I see the One Item added to cart toast message")
    public void iSeeTheOneItemAddedToCartToastMessage() {
        Assert.assertEquals("One Item added to cart", shoppingCartPage.getToastMessage());
    }

    @Then("I see the Book removed from cart toast message")
    public void iSeeTheBookRemovedFromCartToastMessage() {
        Assert.assertEquals("Book removed from cart", shoppingCartPage.getToastMessage());
    }

    @Then("I should see the {string} message on the screen")
    public void iShouldSeeTheMessageOnTheScreen(String expectedMessage) {
        Assert.assertEquals(expectedMessage, shoppingCartPage.getEmptyCartMessage());
    }

    @Then("the Continue shopping button is visible")
    public void theContinueShoppingButtonIsVisible() {
        Assert.assertTrue(shoppingCartPage.isContinueShoppingButtonPresent());
    }

    @Then("I see the Cart cleared toast message")
    public void iSeeTheCartClearedToastMessage() {
        Assert.assertEquals("Cart cleared", shoppingCartPage.getToastMessage());
    }

    @Then("validate that the book title in the cart page matches with wishlist page")
    public void validateThatTheBookTitleInTheCartPageMatchesWithWishlistPage() {
        homePage.clickCartButton();
        Assert.assertEquals(testContextSetup.wishlistPageBookTitle, shoppingCartPage.getTitle());
    }
}
