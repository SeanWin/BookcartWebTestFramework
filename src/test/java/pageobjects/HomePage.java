package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By loginPageButton = By.xpath("//button[.//span[text()=' Login ']]");
    By profileUsername = By.xpath("//a[contains(@class, 'mat-mdc-menu-trigger')]//span[contains(@class, 'mdc-button__label')]/span");
    By logoutButton = By.xpath("//span[text()='Logout']");

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
}
