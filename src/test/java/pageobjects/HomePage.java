package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    By loginPageButton = By.xpath("//button[.//span[text()=' Login ']]");
    By profileUsername = By.xpath("//a[contains(@class, 'mat-mdc-menu-trigger')]//span[contains(@class, 'mdc-button__label')]/span");
    By logoutButton = By.xpath("//span[text()='Logout']");
    By searchInput = By.xpath("//input[@placeholder='Search books or authors']");
    By firstAutocompleteOption = By.cssSelector("mat-option[role='option']");
    By firstBookCoverImage = By.cssSelector("img[alt='Book cover image']");
    By autoCompletePanel = By.id("mat-autocomplete-0");
    By biographyCategory = By.xpath("//mat-list-item//span[contains(text(), 'Biography')]");
    By fictionCategory = By.xpath("//mat-list-item//span[contains(text(), 'Fiction')]");
    By mysteryCategory = By.xpath("//mat-list-item//span[contains(text(), 'Mystery')]");
    By fantasyCategory = By.xpath("//mat-list-item//span[contains(text(), 'Fantasy')]");
    By romanceCategory = By.xpath("//mat-list-item//span[contains(text(), 'Romance')]");
    By books = By.cssSelector("app-book-card");
    By title = By.cssSelector("div.card-title strong");
    By addToCartButton = By.xpath(".//button[.//span[contains(normalize-space(), 'Add to Cart')]]");
    By price = By.cssSelector("mat-slider input[type='range']");
    By noBooks = By.cssSelector("h1.display-4");
    By toastLocator = By.cssSelector(".mat-mdc-snack-bar-label");
    By cartQuantity = By.id("mat-badge-content-0");
    By home = By.cssSelector(".brand-title button");
    By cart = By.xpath("//button[.//mat-icon[contains(text(),'shopping_cart')]]");

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginPageButton() {
        driver.findElement(loginPageButton).click();
    }

    public String getProfileUsername() {
        return driver.findElement(profileUsername).getText();
    }

    public void clickProfileUsername() {
        driver.findElement(profileUsername).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public boolean isLoginButtonPagePresent() {
        return !driver.findElements(loginPageButton).isEmpty();
    }

    public void searchForBook(String title) {
        driver.findElement(searchInput).sendKeys(title);
    }

    public void clickBook() {
        driver.findElement(firstAutocompleteOption).click();
        driver.findElement(firstBookCoverImage).click();
    }

    public boolean isHidden() {
        return driver.findElement(autoCompletePanel).getAttribute("class").contains("mat-mdc-autocomplete-hidden");
    }

    public void clickBiographyCategory() {
        driver.findElement(biographyCategory).click();
    }

    public void clickFictionCategory() {
        driver.findElement(fictionCategory).click();
    }

    public void clickMysteryCategory() {
        driver.findElement(mysteryCategory).click();
    }

    public void clickFantasyCategory() {
        driver.findElement(fantasyCategory).click();
    }

    public void clickRomanceCategory() {
        driver.findElement(romanceCategory).click();
    }

    public int countBooks() {
        return driver.findElements(books).size();
    }

    public List<String> getBookTitles() {
        List<String> bookTitles = new ArrayList<>();
        List<WebElement> bookCards = driver.findElements(books);

        for (WebElement card : bookCards) {
            bookTitles.add(card.findElement(title).getText().trim());
        }
        return bookTitles;
    }

    public boolean isAddToCartButtonPresentForAllBooks() {
        List<WebElement> bookCards = driver.findElements(books);
        for (WebElement card : bookCards) {
            if (!card.findElement(addToCartButton).isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void setPriceFilter(int targetValue) {
        WebElement slider = driver.findElement(price);
        driver.findElement(price).click();

        int current = Integer.parseInt(slider.getAttribute("value"));
        int min = Integer.parseInt(slider.getAttribute("min"));

        while (current > targetValue && current > min) {
            slider.sendKeys(Keys.ARROW_LEFT);
            current = Integer.parseInt(slider.getAttribute("value"));
        }
    }

    public String getNoBooksMessage() {
        return driver.findElement(noBooks).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(firstAutocompleteOption).click();
        driver.findElement(addToCartButton).click();
    }

    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        return toast.getText().trim();
    }

    public int getCartQuantity() {
        return Integer.parseInt(driver.findElement(cartQuantity).getText());
    }

    public void clickHome() {
        driver.findElement(home).click();
    }

    public void clickCartButton() {
        driver.findElement(cart).click();
    }
}
