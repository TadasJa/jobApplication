package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;
import utils.Utils;

import java.time.Duration;
import java.util.UUID;


public class StepDefinitionsForCheckoutFlow {
    private WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Then("I check if all fields are visible")
    public void checkAllCheckoutField() {
        String[] fieldIds = {"name", "country", "city", "card", "month", "year"};
        for (String fieldId : fieldIds) {
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
            if (field.isDisplayed()) {
                System.out.println(fieldId + " field is visible.");
            } else {
                System.err.println(fieldId + " field is NOT visible.");
            }
        }
    }

    @Then("I place an order")
    public void placeOrder() {
        WebElement placeOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn-success')]")));
        placeOrder.click();

    }

    @Then("I add user information to the checkout page {string}")
    public void addUserInformation(String addValues) {
        String random = UUID.randomUUID().toString().replace("-", "");
        String[] fieldIds = {"name", "country", "city", "card", "month", "year"};
        if (addValues.equals("all")) {
            for (String fieldId : fieldIds) {
                WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
                field.sendKeys(random.substring(0, 10));
            }
        } else if (addValues.equals("few")) {
            WebElement fieldName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            fieldName.sendKeys(random.substring(0, 10));
            WebElement fieldCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
            fieldCity.sendKeys(random.substring(0, 10));
        }

    }

    @Then("I click on purchase button")
    public void purchaseButton() {
        WebElement purchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='purchaseOrder()']")));
        purchase.click();

    }

    @Then("I see order confirmation")
    public void orderConfirmation() {
        WebElement purchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your purchase!']")));
        purchase.isDisplayed();
    }

    @And("I see checkout message")
    public void checkoutMessage() {
        Utils.sleep(1000);
        String missingCredentials = "Please fill out Name and Creditcard.";
        Utils.checkAlert(missingCredentials);
    }

}
