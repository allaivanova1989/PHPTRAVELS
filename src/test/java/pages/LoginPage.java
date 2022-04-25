package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public  final String EMAIL_INPUT = "//input[@placeholder='Email']";
    public  final String PASSWORD_INPUT = "//input[@placeholder='Password']";
    public  final By LOGIN_BUTTON = By.xpath("//div[@class='btn-box pt-3 pb-4']/button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
