package stepdefinitions;

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
        MatcherAssert.assertThat(homePage.getBookTitles(), is(testData));
    }

    @Then("all books have an Add to Cart button")
    public void all_books_have_an_add_to_cart_button() {
        Assert.assertTrue(homePage.isAddToCartButtonPresentForAllBooks());
    }
}
