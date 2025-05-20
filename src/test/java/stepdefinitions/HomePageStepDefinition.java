package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import pageobjects.HomePage;
import utils.TestContextSetup;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class HomePageStepDefinition {

    TestContextSetup testContextSetup;
    HomePage homePage;

    public HomePageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
    }

    @Given("I already have {string} in the cart")
    public void iAlreadyHaveInTheCart(String title) throws InterruptedException {
        i_search_for(title);
        clickTheAddToCartButton();
        homePage.clickHome();
    }

    @Given("I am on the Book Details page for {string}")
    public void iAmOnTheBookDetailsPageFor(String title) {
        i_search_for(title);
        click_on_the_book();
    }

    @Given("I have {string} in my wishlist")
    public void iHaveInMyWishlist(String title) throws InterruptedException {
        i_search_for(title);
        iClickTheHeartIcon();
        homePage.clickHome();
    }

    @When("I press the Logout button")
    public void i_press_the_logout_button() {
        homePage.clickProfileUsername();
        homePage.clickLogoutButton();
    }

    @When("I search for {string}")
    public void i_search_for(String title) {
        homePage.searchForBook(title);
    }

    @When("click on the book")
    public void click_on_the_book() {
        homePage.clickBook();
    }

    @When("I click the Biography category button")
    public void i_click_the_biography_category_button() {
        homePage.clickBiographyCategory();
    }

    @When("I click the Fiction category button")
    public void i_click_the_fiction_category_button() {
       homePage.clickFictionCategory();
    }

    @When("I click the Mystery category button")
    public void i_click_the_mystery_category_button() {
        homePage.clickMysteryCategory();
    }

    @When("I click the Fantasy category button")
    public void i_click_the_fantasy_category_button() {
        homePage.clickFantasyCategory();
    }

    @When("I click the Romance category button")
    public void i_click_the_romance_category_button() {
        homePage.clickRomanceCategory();
    }

    @When("I set the price filter to {int}")
    public void i_set_the_price_filter_to(Integer price) throws InterruptedException {
        Thread.sleep(2000);
        homePage.setPriceFilter(price);
    }

    @When("click the Add to Cart button")
    public void clickTheAddToCartButton() throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickAddToCartButton();
    }

    @When("I press the cart icon")
    public void iPressTheCartIcon() {
        homePage.clickCartButton();
    }

    @When("I click the heart icon")
    public void iClickTheHeartIcon() throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickWishlistIcon();
        testContextSetup.homePageBookTitle = homePage.getBookTitle();
    }

    @Then("I should be redirected to the Home page")
    public void i_should_be_redirected_to_the_home_page() {
        boolean titleMatches = testContextSetup.genericUtils.waitForTitle("Home", 3);
        Assert.assertTrue(titleMatches);
    }

    @Then("I should see {string} in the top nav bar")
    public void i_should_see_in_the_top_nav_bar(String expectedUsername) {
        System.out.println(homePage.getProfileUsername());
        Assert.assertEquals(homePage.getProfileUsername(), expectedUsername);
    }

    @Then("the login page button is present")
    public void the_login_page_button_is_present() {
        Assert.assertTrue(homePage.isLoginButtonPagePresent());
    }

    @Then("no results are displayed in the drop down menu")
    public void no_results_are_displayed_in_the_drop_down_menu() {
        System.out.println(homePage.isHidden());
        Assert.assertTrue(homePage.isHidden());
    }

    @Then("{int} books are displayed")
    public void books_are_displayed(int expectedBooksCount) {
        Assert.assertEquals(homePage.countBooks(), expectedBooksCount);
    }

    @Then("^the books have the following titles:$")
    public void the_books_have_the_following_titles(List<String> testData) throws InterruptedException {
        Thread.sleep(1000);
        MatcherAssert.assertThat(homePage.getBookTitles(), is(testData));
    }

    @Then("all books have an Add to Cart button")
    public void all_books_have_an_add_to_cart_button() {
        Assert.assertTrue(homePage.isAddToCartButtonPresentForAllBooks());
    }

    @Then("the No books found message is displayed")
    public void the_no_books_found_message_is_displayed() {
        Assert.assertEquals("No books found.", homePage.getNoBooksMessage());
    }

    @Then("I see the item added to cart successfully toast message")
    public void iSeeTheItemAddedToCartSuccessfullyToastMessage() {
        Assert.assertEquals("One Item added to cart", homePage.getToastMessage());
    }

    @Then("I see the cart icon badge shows {int}")
    public void iSeeTheCartIconBadgeShows(int expectedQuantity) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(expectedQuantity, homePage.getCartQuantity());
    }

    @Then("I should see the Added to Wishlist!!! toast message")
    public void iShouldSeeTheAddedToWishlistToastMessage() {
        Assert.assertEquals("Added to Wishlist!!!", homePage.getToastMessage());
    }

    @Then("I see the heart icon badge shows {int}")
    public void iSeeTheHeartIconBadgeShows(int expectedQuantity) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(expectedQuantity, homePage.getWishlistQuantity());
    }
}
