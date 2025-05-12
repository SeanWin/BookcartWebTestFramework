package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailsPage {
    By title = By.xpath("//td[strong[text()='Title']]/following-sibling::td");
    By author = By.xpath("//td[strong[text()='Author']]/following-sibling::td");
    By category = By.xpath("//td[strong[text()='Category']]/following-sibling::td");
    By price = By.xpath("//td[strong[text()='Price']]/following-sibling::td");
    By addToCartButton = By.xpath("//button[.//span[text()[normalize-space()='Add to Cart']]]");
    By similarBooks = By.xpath("//app-similarbooks//app-book-card");

    public WebDriver driver;

    public BookDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public String getAuthor() {
        return driver.findElement(author).getText();
    }

    public String getCategory() {
        return driver.findElement(category).getText();
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    public boolean isAddToCartButtonPresent() {
        return !driver.findElements(addToCartButton).isEmpty();
    }

    public boolean isSimilarBooksListPresent() {
        return !driver.findElements(similarBooks).isEmpty();
    }
}
