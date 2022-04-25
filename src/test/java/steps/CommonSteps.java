package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class CommonSteps {
    public  static WebDriver driver;

       WebDriverWait wait;
      StepsForLogin stepsForLogin;
       SignUpPage signUpPage;
    @Before
    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        stepsForLogin = new StepsForLogin();
        signUpPage = new SignUpPage(driver);
return driver;

    }
    @After
    public void tearDown() {
        driver.quit();

    }
}
