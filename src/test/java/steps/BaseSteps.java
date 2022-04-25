package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import modals.FactoryForSignUp;
import modals.SignUp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static final By SUCCESS_REGISTRATION_MESSAGE = By.cssSelector("[class='alert alert-success signup']");
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    SignUpPage signUpPage;
    StepsForLogin stepsForLogin;
    public static WebElement element;
    public static String correctPassword;
    public static String correctEmail;


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

    @After
    public void tearDown() {
        driver.quit();
    }

}
