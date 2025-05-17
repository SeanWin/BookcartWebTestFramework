package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {
    By title = By.cssSelector("td.mat-column-title a");
    By price = By.cssSelector("td.mat-column-price");
    By quantity = By.cssSelector("td.mat-column-quantity > div > div:nth-child(2)");
    By total = By.cssSelector("td.mat-column-total");
    By checkoutButton = By.cssSelector("td.mat-column-action button span.mdc-button__label");
    By clearButtonButton = By.xpath("//button[.//span[text()=' Clear cart ']]");

    public WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getTitles() {
        return driver.findElements(title)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<String> getPrices() {
        return driver.findElements(price)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<String> getQuantities() {
        return driver.findElements(quantity)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<String> getTotals() {
        return driver.findElements(total)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isCheckoutButtonPresent() {
        return !driver.findElements(checkoutButton).isEmpty();
    }

    public String getCheckoutButtonText() {
        return driver.findElement(checkoutButton).getText();
    }

    public void clickClearButtonButton() {
        driver.findElement(clearButtonButton).click();
    }
}
