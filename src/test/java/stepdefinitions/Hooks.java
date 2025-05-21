package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.ShoppingCartPage;
import pageobjects.WishlistPage;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {
    TestContextSetup testContextSetup;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    WishlistPage wishlistPage;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getHomePage();
        this.shoppingCartPage = testContextSetup.pageObjectManager.getShoppingCartPage();
        this.wishlistPage = testContextSetup.pageObjectManager.getWishlistPage();
    }

    @After(order = 1)
    public void afterScenario() throws IOException {
        testContextSetup.testBase.webDriverManager().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.testBase.webDriverManager();
        if(scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "Screenshot");
        }
    }

    @After(value = "@ClearCart", order = 2)
    public void clearCartAfter() throws IOException {
        homePage.clickCartButton();
        WebDriverWait wait = new WebDriverWait(testContextSetup.testBase.webDriverManager(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartPage.getClearButtonLocator()));
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartPage.getClearButtonLocator())).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(shoppingCartPage.getEmptyCartMessageLocator(), "Your shopping cart is empty."));
    }

    @After(value = "@ClearWishlist", order = 3)
    public void clearWishlistAfter() throws InterruptedException {
        homePage.clickWishlistPageButton();
        Thread.sleep(2000);
        wishlistPage.clickClearWishlistButton();
    }
}
