package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Hooks;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Utils {
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Optionally, re-interrupt the thread if needed
            Thread.currentThread().interrupt();
        }
    }

    public static void checkAlert(String message) {
        WebDriver driver = Hooks.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Theres no message", message , alertText);
        alert.accept();
        System.out.println("Alert message: " + alertText);
    }
}
