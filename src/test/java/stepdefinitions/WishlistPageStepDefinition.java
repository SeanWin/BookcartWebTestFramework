package stepdefinitions;

import io.cucumber.java.en.Then;
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
}
