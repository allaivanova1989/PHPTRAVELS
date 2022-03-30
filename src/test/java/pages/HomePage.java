package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final String LOGIN_BUTTON = "//div/div[a[contains(text(),'Signup')]]/a[contains(text(),'Login')]";
    public static final String SIGNUP_BUTTON = "//div/div[a[contains(text(),'Signup')]]/a[contains(text(),'Signup')]";
    private static final By MAIN_FORM = By.id("Tab");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return driver.findElement(MAIN_FORM).isDisplayed();
    }

}
