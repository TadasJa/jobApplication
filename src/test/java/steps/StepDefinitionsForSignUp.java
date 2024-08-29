package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
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


public class StepDefinitionsForSignUp {
    private WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("I press Sign up button in the main page")
    public void signUpIntheMainPage() {
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
        signUpButton.click();
    }

    @And("I should see sign up pop up")
    public void iShouldSeeSignUpPoUpWindow() {
        WebElement signUpPopUpWindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInModalLabel")));
        signUpPopUpWindow.isDisplayed();
    }

    @Then("I close sign up pop up window")
    public void iCloseSignUpWindow() {
        Utils.sleep(1000);
        WebElement closeSignUpPopUpWindow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='signInModal']//button[@class='close']")));
        closeSignUpPopUpWindow.click();
    }

    @Then("I register with user name and password {string}")
    public void iRegisterWithRandomUserNameAndPassword(String user) {
        String random = UUID.randomUUID().toString().replace("-", "");
        WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-password")));
        password.isDisplayed();
        if (user.equals("random")) {
            Utils.sleep(1000);
            userName.sendKeys(random.substring(0, 30));
            Utils.sleep(1000);
            password.sendKeys(random.substring(0, 30));
        }
        if (user.equals("existing")) {
            Utils.sleep(1000);
            userName.sendKeys("Tester1992");
            Utils.sleep(1000);
            password.sendKeys("Tester1992");
        }
    }

    @Then("I press sign up button")
    public void iPressSignUp() {
        Utils.sleep(1000);
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick='register()']")));
        register.isDisplayed();
        register.click();
    }

    @And("I see sign up message {string}")
    public void signUpMessage(String message) {
        String successMessage = "Sign up successful.";
        String alreadyExistMessage = "This user already exist.";
        String withoutUserNameAndPassword = "Please fill out Username and Password.";
        switch (message) {
            case "success":
                Utils.checkAlert(successMessage);
                break;
            case "exists":
                Utils.checkAlert(alreadyExistMessage);
                break;
            default:
                Utils.checkAlert(withoutUserNameAndPassword);
                break;
        }
    }
}