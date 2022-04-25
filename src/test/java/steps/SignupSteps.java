package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class SignupSteps {
    WebDriver driver;
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;
    SignUpPage signUpPage;
    WebDriverWait wait;
    StepsForLogin stepsForLogin;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        stepsForLogin = new StepsForLogin();
        signUpPage = new SignUpPage(driver);


    }


    @Given("User on the signup page")
    public void userOnTheSignupPage() {
        driver.get("https://www.phptravels.net");
        driver.findElement(By.xpath(HomePage.SIGNUP_BUTTON)).click();
        signUpPage.isPageOpen();
    }


    @And("user enters lastName {string}")
    public void userEntersLastName(String lastName) {
        this.lastName = lastName;
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
    }


    @When("user enters data in fields")
    public void userEntersDataInFields(DataTable table) {

        System.out.println(table);
    }
    @When("user enters firstName  {string}")
    public void userEntersFirstNameFirstName(String firstName) {
        this.firstName = firstName;
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
    }

    @And("user enters phone {string}")
    public void userEntersPhone(String phone) {
        this.phone = phone;
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(phone);

    }

    @And("user enters email {string}")
    public void userEntersEmailEmail(String email) {
        this.email = email;
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        this.password = password;
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);

    }

    @And("User click on Signup")
    public void userClickOnSignup() {
        driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button")).click();
    }

    @Then("registration should be successful")
    public void registrationShouldBeSuccessful() {
        driver.findElement(StepsForLogin.SUCCESS_REGISTRATION_MESSAGE).isDisplayed();

    }
    @After
    public void tearDown() {
        driver.quit();

    }


}
