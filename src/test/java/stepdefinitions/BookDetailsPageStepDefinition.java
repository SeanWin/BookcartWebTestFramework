package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.BookDetailsPage;
import utils.TestContextSetup;

import java.util.List;
import java.util.Map;

public class BookDetailsPageStepDefinition {

    TestContextSetup testContextSetup;
    BookDetailsPage bookDetailsPage;

    public BookDetailsPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.bookDetailsPage = testContextSetup.pageObjectManager.getBookDetailsPage();
    }

    @When("I click the Add to Wishlist button")
    public void iClickTheAddToWishlistButton() {
        bookDetailsPage.clickAddToWishlistButton();
        testContextSetup.bookDetailsPageBookTitle = bookDetailsPage.getTitle();
    }

    @Then("I should be redirected to the book details page")
    public void i_should_be_redirected_to_the_book_details_page() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Book Details", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("I should see the following book details:")
    public void i_should_see_the_following_book_details(DataTable dataTable) {
        List<Map<String, String>> expectedDetails = dataTable.asMaps(String.class, String.class);
        Map<String, String> expected = expectedDetails.getFirst();

        Assert.assertEquals(expected.get("Title"), bookDetailsPage.getTitle());
        Assert.assertEquals(expected.get("Author"), bookDetailsPage.getAuthor());
        Assert.assertEquals(expected.get("Category"), bookDetailsPage.getCategory());
        Assert.assertEquals(expected.get("Price"), bookDetailsPage.getPrice());

    }

    @Then("the Add to Cart button should be visible")
    public void the_add_to_cart_button_should_be_visible() {
        Assert.assertTrue(bookDetailsPage.isAddToCartButtonPresent());
    }

    @Then("a list of similar books should be present")
    public void a_list_of_similar_books_should_be_present() {
        Assert.assertTrue(bookDetailsPage.isSimilarBooksListPresent());
    }
}
