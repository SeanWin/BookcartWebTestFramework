package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By loginPageButton = By.xpath("//button[.//span[text()=' Login ']]");
    By profileUsername = By.xpath("//a[contains(@class, 'mat-mdc-menu-trigger')]//span[contains(@class, 'mdc-button__label')]/span");

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
}
