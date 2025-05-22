package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {
    By nameField = By.cssSelector("input[formcontrolname='name']");
    By addressLine1Field = By.cssSelector("input[formcontrolname='addressLine1']");
    By addressLine2Field = By.cssSelector("input[formcontrolname='addressLine2']");
    By pincodeField = By.cssSelector("input[formcontrolname='pincode']");
    By stateField = By.cssSelector("input[formcontrolname='state']");
    By placeOrderButton    = By.xpath("//button[.//span[normalize-space()='Place Order']]");
    By toastLocator = By.cssSelector(".mat-mdc-snack-bar-label");
    By errorFields = By.cssSelector("mat-error.mat-mdc-form-field-error");

    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    
    public void enterAddressLine1(String addressLine1) {
        driver.findElement(addressLine1Field).sendKeys(addressLine1);
    }
    
    public void enterAddressLine2(String addressLine2) {
        driver.findElement(addressLine2Field).sendKeys(addressLine2);
    }
    
    public void enterPincode(String pincode) {
        driver.findElement(pincodeField).sendKeys(pincode);
    }
    
    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        return toast.getText().trim();
    }

    public void leaveFieldsBlank() {
        driver.findElement(nameField).sendKeys(Keys.TAB);
        driver.findElement(addressLine1Field).sendKeys(Keys.TAB);
        driver.findElement(addressLine2Field).sendKeys(Keys.TAB);
        driver.findElement(pincodeField).sendKeys(Keys.TAB);
        driver.findElement(stateField).sendKeys(Keys.TAB);
    }

    public List<String> getAllErrorMessages() {
        List<WebElement> errors = driver.findElements(errorFields);
        return errors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
