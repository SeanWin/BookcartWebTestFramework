package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    private WebDriver driver;

    public WebDriver webDriverManager() throws IOException {
        if (driver == null) {
            Properties prop = new Properties();
            try (FileInputStream fis = new FileInputStream("src/test/resources/global.properties")) {
                prop.load(fis);
            }
            String url = prop.getProperty("QAUrl");
            String browser = System.getProperty("browser", prop.getProperty("browser"));

            // detect CI environment for headless
            boolean ci = System.getenv("CI") != null;

            switch (browser.toLowerCase()) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    if (ci) {
                        options.addArguments("--headless");
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    if (ci) {
                        options.addArguments("-headless");
                    }
                    driver = new FirefoxDriver(options);
                }
                case "edge" -> {
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    if (ci) {
                        options.addArguments("--headless");
                    }
                    driver = new EdgeDriver(options);
                }
                default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if (!ci) {
                driver.manage().window().maximize();
            }
            driver.get(url);
        }
        return driver;
    }
}
