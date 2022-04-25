package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{
    private static final By REGISTRATION_TEXT = By.xpath("//p[contains(text(),'Please enter all credentials to signup')]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPageOpen() {
        return driver.findElement(By.xpath("//input[@placeholder='First Name']")).isDisplayed();
    }

}
