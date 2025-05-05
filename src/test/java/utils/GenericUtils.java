package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericUtils {
    WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForTitle(String expectedTitle, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }
}
