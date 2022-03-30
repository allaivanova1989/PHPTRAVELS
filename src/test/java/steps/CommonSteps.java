package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CommonSteps {
    WebDriver driver;
   String  email;
   String password;
   HomePage homePage;
   LoginPage loginPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
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
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Welcome Back')]")).isDisplayed());

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
