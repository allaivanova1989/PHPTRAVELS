package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class CommonSteps {
    public static final By STOP_COOKIE = By.id("cookie_stop");
    public static final By SUBMIT_REGISTRATION = By.xpath("//span[contains(text(),'Signup')]/ancestor::button");

    public static final By SUCCESS_REGISTRATION_MESSAGE = By.cssSelector("[class='alert alert-success signup']");
    public static WebDriver driver;

    WebDriverWait wait;
    StepsForLogin stepsForLogin;
    SignUpPage signUpPage;
    JavascriptExecutor javascriptExecutor;
    HomePage homePage;
    LoginPage loginPage;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        stepsForLogin = new StepsForLogin();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);


    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void tearDown() {
        driver.quit();

    }
}
