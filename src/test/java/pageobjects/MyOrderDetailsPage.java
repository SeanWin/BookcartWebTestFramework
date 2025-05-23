package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrderDetailsPage {
    By latestOrder = By.cssSelector("table[role='table'] tbody tr:nth-of-type(1)");
    By orderDetails = By.tagName("td");

    public WebDriver driver;

    public MyOrderDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLatestOrderDate() {
        return driver.findElement(latestOrder).findElements(orderDetails).get(1).getText().trim();
    }

    public String getLatestOrderTotal() {
        return driver.findElement(latestOrder).findElements(orderDetails).get(2).getText().trim();
    }
}
