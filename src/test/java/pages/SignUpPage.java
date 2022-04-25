package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{
    private static final By REGISTRATION_FORM = By.cssSelector("[class='modal-body']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPageOpen() {
        return driver.findElement(REGISTRATION_FORM).isDisplayed();
    }

}
