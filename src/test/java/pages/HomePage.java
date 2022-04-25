package pages;

import elements.Input;
import modals.SignUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public  final String LOGIN_BUTTON = "//div/div[a[contains(text(),'Signup')]]/a[contains(text(),'Login')]";
    public  final By SIGNUP_BUTTON = By.xpath("//div/div[a[contains(text(),'Signup')]]/a[contains(text(),'Signup')]");
    private  final By WELCOME = By.xpath("//h2[@class='sec__title font-size-30 text-white'][span]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return driver.findElement(WELCOME).isDisplayed();
    }

    public void FilInTableSignUP(SignUp signUp) {

        new Input(driver,"First Name").write(signUp.getName());
        new Input(driver,"Last Name").write(signUp.getLastName());
        new Input(driver,"Phone").write(signUp.getPhone());
        new Input(driver,"Email").write(signUp.getEmail());
        new Input(driver,"Password").write(signUp.getPassword());


    }
}
