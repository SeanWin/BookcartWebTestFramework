package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.WishlistPage;
import utils.TestContextSetup;

public class WishlistPageStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;
    WishlistPage wishlistPage;

    public WishlistPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
        this.wishlistPage = testContextSetup.pageObjectManager.getWishlistPage();
    }

    @When("I click the Remove from Wishlist button for {string}")
    public void iClickTheRemoveFromWishlistButtonFor(String title) throws InterruptedException {
        Thread.sleep(3500);
        wishlistPage.clickRemoveFromWishlistButtonForBook(title);
    }

    @When("I click the Clear Wishlist button")
    public void iClickTheClearWishlistButton() throws InterruptedException {
        Thread.sleep(3500);
        wishlistPage.clickClearWishlistButton();
    }

    @When("I click the Add to Cart button for {string}")
    public void iClickTheAddToCartButtonFor(String title) throws InterruptedException {
        Thread.sleep(3500);
        wishlistPage.clickAddToCartButtonForBook(title);
        testContextSetup.wishlistPageBookTitle = wishlistPage.getTitle();
    }

    @Then("validate that the book title in the wishlist page matches with home page")
    public void validateThatTheBookTitleInTheWishlistPageMatchesWithHomePage() {
        homePage.clickWishlistPageButton();
        Assert.assertEquals(testContextSetup.homePageBookTitle, wishlistPage.getTitle());
    }

    @Then("validate that the book title in the wishlist page matches with book details page")
    public void validateThatTheBookTitleInTheWishlistPageMatchesWithBookDetailsPage() {
        homePage.clickWishlistPageButton();
        Assert.assertEquals(testContextSetup.bookDetailsPageBookTitle, wishlistPage.getTitle());
    }

    @Then("I should see the Removed from Wishlist!!! toast message")
    public void iShouldSeeTheRemovedFromWishlistToastMessage() {
        Assert.assertEquals("Removed from Wishlist!!!", wishlistPage.getToastMessage());
    }

    @Then("I should see the Wishlist cleared!!! toast message")
    public void iShouldSeeTheWishlistClearedToastMessage() {
        Assert.assertEquals("Wishlist cleared!!!", wishlistPage.getToastMessage());
    }
}
