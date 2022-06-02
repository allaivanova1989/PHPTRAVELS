package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modals.FactoryForSignUp;
import modals.SignUp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsForLogin extends CommonSteps {

    private static final By WELCOME_PHRASE = By.xpath("//span[contains(text(),'Welcome Back')]");
    private static final By ERROR_ALERT = By.xpath("//div[@class='alert alert-danger failed']");
    public static final By SUCCESS_REGISTRATION_MESSAGE = By.cssSelector("[class='alert alert-success signup']");


    WebElement element;
    String email;
    String password;
    public static String correctPassword;
    public static String correctEmail;
    HomePage homePage;


    @Before
    public void start() {
        setUp();

    }

    public void createUser() {

        driver.get("https://www.phptravels.net");
        click(homePage.SIGNUP_BUTTON);
        click(STOP_COOKIE);
        SignUp signUp = FactoryForSignUp.createUser();
        homePage.FilInTableSignUP(signUp);
        correctEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
        correctPassword = driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("value");
        element = driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button"));
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        click(SUBMIT_REGISTRATION);

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (SUCCESS_REGISTRATION_MESSAGE));

    }


    @Given("email for log in")
    public void emailForLogIn() {

    }

    @Given("password for log in")
    public void passwordForLogIn() {

    }

    @Given("email for log in {string}")
    public void emailForLogIn(String email) {
        this.email = email;
    }

    @Given("password for log in {string}")
    public void passwordForLogIn(String password) {
        this.password = password;
    }

    @When("User enters correct login and correct password and clicks Login button")
    public void userEntersCorrectLoginAndCorrectPasswordAndClicksLoginButton() {
        createUser();
        driver.findElement(By.xpath(loginPage.EMAIL_INPUT)).sendKeys(correctEmail);
        driver.findElement(By.xpath(loginPage.PASSWORD_INPUT)).sendKeys(correctPassword);
        click(loginPage.LOGIN_BUTTON);
    }

    @When("User enters incorrect login and correct password and clicks Login button")
    public void userEntersIncorrectLoginAndCorrectPasswordAndClicksLoginButton() {
        driver.get("https://www.phptravels.net/login");
        driver.findElement(By.xpath(loginPage.EMAIL_INPUT)).sendKeys(email);
        driver.findElement(By.xpath(loginPage.PASSWORD_INPUT)).sendKeys(correctPassword);
        click(loginPage.LOGIN_BUTTON);

    }

    @When("User enters correct login and incorrect password and clicks Login button")
    public void userEntersCorrectLoginAndIncorrectPasswordAndClicksLoginButton() {
        driver.get("https://www.phptravels.net/login");
        driver.findElement(By.xpath(loginPage.EMAIL_INPUT)).sendKeys(correctEmail);
        driver.findElement(By.xpath(loginPage.PASSWORD_INPUT)).sendKeys(password);
        click(loginPage.LOGIN_BUTTON);
    }

    @Then("We can see text welcome")
    public void weCanSeeText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (WELCOME_PHRASE));
        assertTrue(driver.findElement(WELCOME_PHRASE).isDisplayed());
    }

    @And("HomePage is opened")
    public void homepageIsOpened() {
        homePage.isPageOpen();
    }

    @Then("We had error message")
    public void weHadErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (ERROR_ALERT));
        assertTrue(driver.findElement(ERROR_ALERT).isDisplayed());
    }

    @And("We are on page failed")
    public void weAreOnPageFailed() {
        assertTrue(driver.findElement(By.xpath("//meta[@content='https://www.phptravels.net/login/failed']")).isEnabled());
    }

    @After
    public void finish() {
        tearDown();

    }

}
