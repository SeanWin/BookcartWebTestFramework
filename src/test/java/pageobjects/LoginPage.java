package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    By usernameField = By.cssSelector("input[formcontrolname='username']");
    By passwordField = By.cssSelector("input[formcontrolname='password']");
    By loginButton = By.xpath("//button[.//span[text()='Login']]");
    By registerPageButton = By.xpath("//button[.//span[text()='Register']]");

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickRegisterPageButton() {
        driver.findElement(registerPageButton).click();
    }
}
