package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    public boolean isPageOpen() {
        return driver.findElement(By.xpath("//input[@placeholder='First Name']")).isDisplayed();
    }

}
