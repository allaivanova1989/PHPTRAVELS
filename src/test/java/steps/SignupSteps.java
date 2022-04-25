package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class SignupSteps extends BaseSteps{
    WebDriver driver;
    String firstName;
    String lastName;
    String phone;
    String email;
    String password;


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
        driver.findElement(BaseSteps.SUCCESS_REGISTRATION_MESSAGE).isDisplayed();

    }


}
