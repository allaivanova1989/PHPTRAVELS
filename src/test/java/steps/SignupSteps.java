package steps;

import elements.Input;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SignupSteps extends CommonSteps {

   public static WebElement element;
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;


    @Before
    public void start() {
        setUp();

    }

    @Given("User on the signup page")
    public void userOnTheSignupPage() {
        driver.get("https://www.phptravels.net");
        click(homePage.SIGNUP_BUTTON);

    }


    @And("user enters lastName {string}")
    public void userEntersLastName(String lastName) {
        this.lastName = lastName;
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
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
        click(STOP_COOKIE);
        element = driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button"));
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
        click(SUBMIT_REGISTRATION);
    }

    @When("user enters data in fields and click on SignUp")
    public void userEntersDataInFieldsAndClickOnSignup(DataTable table) {
        List<Map<String, String>> dataMap = table.asMaps();
        for (Map<String, String> stringStringMap : dataMap) {
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(stringStringMap.get("FirstName"));
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(stringStringMap.get("LastName"));
            driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(stringStringMap.get("Phone"));
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(stringStringMap.get("Email"));
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(stringStringMap.get("Password"));
            click(STOP_COOKIE);
            element = driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button"));
            javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
            click(SUBMIT_REGISTRATION);
        }

    }

    @Then("registration should be successful")
    public void registrationShouldBeSuccessful() {
        driver.findElement(SUCCESS_REGISTRATION_MESSAGE).isDisplayed();

    }

    @After
    public void finish() {
        tearDown();

    }


}
