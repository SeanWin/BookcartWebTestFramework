package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    By clearWishlistButton = By.xpath("//button[.//span[text()=' Clear Wishlist ']]");
    By title = By.cssSelector("td.mat-column-title a");

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
}
