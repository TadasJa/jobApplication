package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class StepDefinitionsForAddingProducts {
    private WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Then("I go to phones section")
    public void iGoToPhoneSection() {
        Utils.sleep(1000);
        WebElement pressOnPhoneInTheMainPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick[contains(., 'phone')]]")));
        pressOnPhoneInTheMainPage.click();
    }

    @Then("I pick an item {string}")
    public void iItem(String phone) {
        WebElement iItem = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(phone)));
        iItem.click();
    }

    @Then("I press Add to cart button")
    public void addToCart() {
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@onclick, 'addToCart')]")));
        addToCart.click();
    }

    @Then("I press on cart button in the main page")
    public void pressCartButtonOnTheMainPage() {
        Utils.sleep(1000);
        WebElement pressOnCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
        pressOnCartButton.click();
        Utils.sleep(2000);

    }

    @Then("I see the same product that I added {string}")
    public void checkIfTheSameProductIsAdded(String product) {
        WebElement checkTheValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + product + "']")));
        String value = checkTheValue.getText();
        assertEquals("The values do not match!", product, value);
        System.out.println("The values match: " + value);
        checkTheValue.isDisplayed();
    }

    @Then("I remove the product that was added previously {string}")
    public void removeTheProductFromCart(String product) {
        Utils.sleep(1000);
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(text(), '" + product + "')]/following-sibling::td/a[contains(@onclick, 'deleteItem')]")));
        deleteButton.click();
        Utils.sleep(2000);
    }

    @And("I see success message for adding the product to the cart")
    public void addedMessage() {
        String addedToCart = "Product added.";
        Utils.checkAlert(addedToCart);
    }

    @And("I press on home page button")
    public void homePage() {
        Utils.sleep(1000);
        WebElement pressOnHomePageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nav-link' and contains(text(), 'Home')]")));
        pressOnHomePageButton.click();
    }

    @Then("I go to laptop section")
    public void iGoToLaptopSection() {
        Utils.sleep(1000);
        WebElement pressOnLaptopsInTheMainPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick[contains(., 'notebook')]]")));
        pressOnLaptopsInTheMainPage.click();
    }

    @Then("I check if the cart is empty")
    public void iCheckIfTheCartIsempty() {
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
        int rowCount = cart.findElements(By.tagName("tr")).size();

        if (rowCount == 0) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("The cart is not empty. Row count: " + rowCount);
            throw new AssertionError("Expected cart to be empty, but found " + rowCount + " items.");
        }
    }
}
