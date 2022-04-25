package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import modals.FactoryForSignUp;
import modals.SignUp;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StepsForLogin  {
    private static final By WELCOME_PHRASE = By.xpath("//span[contains(text(),'Welcome Back')]");
    private static final By ERROR_ALERT = By.xpath("//div[@class='alert alert-danger failed']");
    public static final By SUCCESS_REGISTRATION_MESSAGE = By.cssSelector("[class='alert alert-success signup']");
    WebDriver driver;
    String email;
    String password;
    HomePage homePage;
    WebDriverWait wait;
    public static String correctPassword;
    public static String correctEmail;
    StepsForLogin stepsForLogin;
    public static WebElement element;
    SignUpPage signUpPage;


    public void createUser() {

        driver.get("https://www.phptravels.net");
        driver.findElement(By.xpath(HomePage.SIGNUP_BUTTON)).click();
        driver.findElement(By.id("cookie_stop")).click();
        SignUp signUp = FactoryForSignUp.createUser();
        homePage.FilInTableSignUP(signUp);
        correctEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
        correctPassword = driver.findElement(By.xpath("//input[@placeholder='Password']")).getAttribute("value");
        element = driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (SUCCESS_REGISTRATION_MESSAGE));

    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver);
        stepsForLogin = new StepsForLogin();
        signUpPage = new SignUpPage(driver);
        createUser();

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

        driver.findElement(By.xpath(LoginPage.EMAIL_INPUT)).sendKeys(correctEmail);
        driver.findElement(By.xpath(LoginPage.PASSWORD_INPUT)).sendKeys(correctPassword);
        driver.findElement(By.xpath(LoginPage.LOGIN_BUTTON)).click();
    }

    @When("User enters incorrect login and correct password and clicks Login button")
    public void userEntersIncorrectLoginAndCorrectPasswordAndClicksLoginButton() {
        driver.get("https://www.phptravels.net/login");
        driver.findElement(By.xpath(LoginPage.EMAIL_INPUT)).sendKeys(email);
        driver.findElement(By.xpath(LoginPage.PASSWORD_INPUT)).sendKeys(correctPassword);
        driver.findElement(By.xpath(LoginPage.LOGIN_BUTTON)).click();
    }

    @When("User enters correct login and incorrect password and clicks Login button")
    public void userEntersCorrectLoginAndIncorrectPasswordAndClicksLoginButton() {
        driver.get("https://www.phptravels.net/login");
        driver.findElement(By.xpath(LoginPage.EMAIL_INPUT)).sendKeys(correctEmail);
        driver.findElement(By.xpath(LoginPage.PASSWORD_INPUT)).sendKeys(password);
        driver.findElement(By.xpath(LoginPage.LOGIN_BUTTON)).click();
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


   @ After
   public void tearDown() {
      driver.quit();

   }
}
