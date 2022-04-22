package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
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
   String cityName;
   String firstDate;
   String secondDate;
   String room;


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
    public void weCanSeeText() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Welcome Back')]")).isDisplayed());

    }



    @Then("We had error message")
    public void weHadErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath("//div[@class='col align-self-end']")).getAttribute("afterShow").toString().contains("Wrong creden"));


        
    }

    @Given("cityName for booking {string}")
    public void citynameForBooking(String cityName) {
        this.cityName = cityName;
    }

    @Given("checkingDate {string}")
    public void checkingdate(String firstDate) {
        this.firstDate = firstDate;
    }

    @Given("checkoutDate {string}")
    public void checkoutdate(String secondDate) {
        this.secondDate = secondDate;
    }

    @Given("travellersRoom {string}")
    public void travellersroom(String room) {
        this.room = room;
    }

    @When("We input data and search hotels")
    public void weInputDataAndSearchHotels() {
        userEntersLoginAndPasswordAndClicksLoginButton();
        driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/hotels']")).click();
        driver.findElement(By.xpath("//span[span[contains(text(),'City')]]")).sendKeys(cityName);
        driver.findElement(By.cssSelector("[name='checkin']")).sendKeys(firstDate);
        driver.findElement(By.cssSelector("[name='checkout']")).sendKeys(secondDate);
        driver.findElement(By.xpath("//p[contains(text(),'Travellers')]")).sendKeys(room);
    }


    @Given("cityName for booking <cityName>")
    public void citynameForBookingCityName(String city) {
        this.cityName = city;

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
