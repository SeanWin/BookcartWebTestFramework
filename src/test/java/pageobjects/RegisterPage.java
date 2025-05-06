package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    By firstnameField = By.cssSelector("input[formcontrolname='firstName']");
    By lastnameField = By.cssSelector("input[formcontrolname='lastName']");
    By usernameField = By.cssSelector("input[formcontrolname='userName']");
    By passwordField = By.cssSelector("input[formcontrolname='password']");
    By confirmPasswordField = By.cssSelector("input[formcontrolname='confirmPassword']");
    By maleRadioButton = By.xpath("//input[@type='radio' and @value='Male']");
    By femaleRadioButton = By.xpath("//input[@type='radio' and @value='Female']");
    By registerButton = By.xpath("//button[.//span[text()='Register']]");
    By toastLocator = By.cssSelector(".mat-mdc-snack-bar-label");

    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstname(String firstname) {
        driver.findElement(firstnameField).sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        driver.findElement(lastnameField).sendKeys(lastname);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickMaleRadioButton() {
        driver.findElement(maleRadioButton).click();
    }

    public void clickFemaleRadioButton() {
        driver.findElement(femaleRadioButton).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        return toast.getText().trim();
    }

    public void enterFirstnameSlow(String firstName) {
        WebElement field = driver.findElement(firstnameField);
        slowType(field, firstName, 100);
    }

    public void enterLastnameSlow(String lastName) {
        WebElement field = driver.findElement(lastnameField);
        slowType(field, lastName, 100);
    }

    public void enterUsernameSlow(String username) {
        WebElement field = driver.findElement(usernameField);
        slowType(field, username, 100);
    }

    public void enterPasswordSlow(String password) {
        WebElement field = driver.findElement(passwordField);
        slowType(field, password, 100);
    }

    public void enterConfirmPasswordSlow(String confirmPassword) {
        WebElement field = driver.findElement(confirmPasswordField);
        slowType(field, confirmPassword, 100);
    }

    public void slowType(WebElement element, String text, long millisPerChar) {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            try {
                Thread.sleep(millisPerChar);
            } catch (InterruptedException ignored) { }
        }
    }
}
