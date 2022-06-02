package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePageFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

public class SignupSteps extends CommonSteps {
    HomePageFactory homePageFactory = PageFactory.initElements(driver,HomePageFactory.class);

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

    @And("user enters password {string} and click on signup")
    public void userEntersPasswordAndClickOnSignup(String password) {
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

        List<List<String>> data = table.asLists();

                    driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data.get(1).get(1));
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data.get(2).get(1));
            driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys(data.get(3).get(1));
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(data.get(4).get(1));
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data.get(5).get(1));
            click(STOP_COOKIE);
            element = driver.findElement(By.xpath("//span[contains(text(),'Signup')]/ancestor::button"));
            javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
            click(SUBMIT_REGISTRATION);

    }

    @Then("registration is successful")
    public void registrationIsSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SUCCESS_REGISTRATION_MESSAGE)));

        assertTrue(driver.findElement(SUCCESS_REGISTRATION_MESSAGE).isDisplayed());

    }

    @After
    public void finish() {
        tearDown();

    }



}
