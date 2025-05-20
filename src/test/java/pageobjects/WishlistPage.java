package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishlistPage {
    By clearWishlistButton = By.xpath("//button[.//span[text()=' Clear Wishlist ']]");
    By title = By.cssSelector("td.mat-column-title a");
    By toastLocator = By.cssSelector(".mat-mdc-snack-bar-label");
    String bookRow = "//tr[.//td[contains(@class,'mat-column-title')]//a[normalize-space()='%s']]";
    By removeFromWishlistButton = By.xpath(".//button[.//span[normalize-space()='Remove from Wishlist']]");

    public WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickClearWishlistButton() {
        driver.findElement(clearWishlistButton).click();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        return toast.getText().trim();
    }

    private By bookRowLocator(String title) {
        return By.xpath(String.format(bookRow, title));
    }

    public void clickRemoveFromWishlistButtonForBook(String title) {
        driver.findElement(bookRowLocator(title)).findElement(removeFromWishlistButton).click();
    }
}
