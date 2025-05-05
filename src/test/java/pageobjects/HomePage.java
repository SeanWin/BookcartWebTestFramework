package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By loginPageButton = By.xpath("//button[.//span[text()=' Login ']]");

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginPageButton() {
        driver.findElement(loginPageButton).click();
    }
}
