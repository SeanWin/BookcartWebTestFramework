package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {
    By title = By.cssSelector("td.mat-column-title a");
    By price = By.cssSelector("td.mat-column-price");
    By quantity = By.cssSelector("td.mat-column-quantity > div > div:nth-child(2)");
    By total = By.cssSelector("td.mat-column-total");
    By checkoutButton = By.cssSelector("td.mat-column-action button span.mdc-button__label");
    By clearButtonButton = By.xpath("//button[.//span[text()=' Clear cart ']]");
    By decrementButton = By.xpath("//mat-icon[normalize-space()='remove_circle']/ancestor::button");
    By incrementButton = By.xpath("//mat-icon[normalize-space()='add_circle']/ancestor::button");
    By toastLocator = By.cssSelector(".mat-mdc-snack-bar-label");
    By cartTotal = By.xpath("//strong[normalize-space()='Cart Total:']/parent::td/following-sibling::td/strong");
    String bookRow = "//tr[.//td[contains(@class,'mat-column-title')]//a[normalize-space()='%s']]";
    By deleteButton = By.xpath(".//button[.//mat-icon[normalize-space()='delete']]");
    By emptyCartMessage = By.xpath("(//mat-card-title[contains(@class, 'mat-h1')])[2]");
    By continueShoppingButton = By.xpath("//button[.//span[normalize-space()='Continue shopping']]");


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

    public void clickDecrementButton() {
        driver.findElement(decrementButton).click();
    }

    public void clickIncrementButton() {
        driver.findElement(incrementButton).click();
    }

    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        return toast.getText().trim();
    }

    public int getQuantity() {
        return Integer.parseInt(driver.findElement(quantity).getText());
    }

    public String getCartTotal() {
        return driver.findElement(cartTotal).getText();
    }

    private By bookRowLocator(String title) {
        return By.xpath(String.format(bookRow, title));
    }

    public void clickDeleteButtonForBook(String title) {
        driver.findElement(bookRowLocator(title)).findElement(deleteButton).click();
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessage).getText();
    }

    public boolean isContinueShoppingButtonPresent() {
        return !driver.findElements(continueShoppingButton).isEmpty();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
