package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // Open Chrome in incognito mode
        options.addArguments("--disable-search-engine-choice-screen"); // Disable all extensions (optional)

        // Initialize the ChromeDriver
        driver = new ChromeDriver(options);

        driver.get("https://www.demoblaze.com/");
    }

    @After
    public void tearDown() {
        // Close the browser and clean up the WebDriver
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }
}