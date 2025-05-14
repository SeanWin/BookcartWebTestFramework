package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    By books = By.cssSelector("app-book-card");
    By title = By.cssSelector("div.card-title strong");
    By addToCartButton = By.xpath(".//button[.//span[contains(normalize-space(), 'Add to Cart')]]");
    By price = By.cssSelector("mat-slider input[type='range']");

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
}
