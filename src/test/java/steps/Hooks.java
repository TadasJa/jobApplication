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
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Disable sandboxing
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration
        options.addArguments("--window-size=1920,1080"); // Set window size
        options.addArguments("--incognito"); // Open Chrome in incognito mode
        options.addArguments("--disable-search-engine-choice-screen"); // Disable search engine choice screen

        // Initialize the ChromeDriver
        driver = new ChromeDriver(options);

        // Open the target URL
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