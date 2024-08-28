package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;
import java.util.UUID;

public class StepDefinitionsForLogin {
        private WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @When("I press Login button in the main page")
        public void loginIntheMainPage() {
            Utils.sleep(1000);
            WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
            signUpButton.click();
        }

        @And("I should see Login pop up")
        public void iShouldSeeLoginPoUpWindow() {
            Utils.sleep(1000);
            WebElement signUpPopUpWindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("logInModalLabel")));
            signUpPopUpWindow.isDisplayed();
        }

        @Then("I close Login pop up window")
        public void iCloseLoginWindow() {
            Utils.sleep(1000);
            WebElement closeSignUpPopUpWindow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logInModal']//button[@class='close']")));
            closeSignUpPopUpWindow.click();
        }

        @Then("I Login with user name and password {string}")
        public void iLoginWithRandomUserNameAndPassword(String user) {
            String random = UUID.randomUUID().toString().replace("-", "");
            WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
            WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
            if (user.equals("random")) {
                userName.sendKeys(random.substring(0, 30));
                password.sendKeys(random.substring(0, 30));
            }
            if (user.equals("existing")) {
                userName.sendKeys("Tester1992");
                password.sendKeys("Tester1992");
            }
        }

        @Then("I press Login button")
        public void iPressLogin() {
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick='logIn()']")));
            login.click();;
        }

    @Then("I see that user is Logged in")
    public void checkIfLogedIn() {
        Utils.sleep(2000);
        String userName = "";
        WebElement checkLogedIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='nameofuser' and contains(text(), 'Welcome "+ userName +"')]")));
        checkLogedIn.isDisplayed();
    }

    @And("I see Login message {string}")
    public void loginMessage(String message)  {
        String noValues = "Please fill out Username and Password.";
        String randomValues = "User does not exist.";
        switch (message) {
            case "noValues":
                Utils.checkAlert(noValues);
                break;
            case "notExisting":
                Utils.checkAlert(randomValues);
                break;
        }
    }
    }

