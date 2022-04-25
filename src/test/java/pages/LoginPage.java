package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public static final String EMAIL_INPUT = "//input[@placeholder='Email']";
    public static final String PASSWORD_INPUT = "//input[@placeholder='Password']";
    public static final String LOGIN_BUTTON = "//div[@class='btn-box pt-3 pb-4']/button";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
