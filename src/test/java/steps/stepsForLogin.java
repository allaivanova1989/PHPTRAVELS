package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class stepsForLogin {
    private static final By WELCOME_PHRASE = By.xpath("//span[contains(text(),'Welcome Back')]");
    private static final By ERROR_ALERT = By.xpath("//div[@class='alert alert-danger failed']");

    WebDriver driver;
    String email;
    String password;
    HomePage homePage;
    LoginPage loginPage;

    WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Given("email for log in {string}")
    public void emailForLogIn(String email) {
        this.email = email;
    }

    @Given("password for log in {string}")
    public void passwordForLogIn(String password) {
        this.password = password;
    }

    @When("User enters login and password and clicks Login button")
    public void userEntersLoginAndPasswordAndClicksLoginButton() {
        driver.get("https://www.phptravels.net/login");
        driver.findElement(By.xpath(LoginPage.EMAIL_INPUT)).sendKeys(email);
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

    @After
    public void tearDown() {
        driver.quit();
    }

}
