package pages;

import elements.Input;
import modals.SignUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFactory {

    WebDriver driver;

    public HomePageFactory(WebDriver idriver) {
        this.driver = idriver;
    }

    @FindBy(xpath ="//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")
   public WebElement signupButton;


    @FindBy(xpath ="//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")
    public WebElement loginButton;

    @FindBy(xpath ="//span[@id='select2-hotels_city-container']")
    public WebElement searchByCityField;

    @FindBy(css ="#checkin")
    public WebElement checkinDate;

    @FindBy(css ="#checkout")
    public WebElement checkoutDate;


    @FindBy(xpath ="//body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/p[1]")
   public WebElement travellersChose;

    @FindBy(xpath ="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/button[1]/span[1]/i[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
   public WebElement searchByCityInput;

    @FindBy(xpath = "(//*[@role='option'])[1]")
    public WebElement firstResultCity;

    @FindBy(xpath = "//h2[@class='sec__title font-size-30 text-white'][span]")
    public WebElement welcome;

    public void clickOnLogin (){
        loginButton.click();
    }

    public void clickOnSignUp (){
        signupButton.click();
    }

    public void chooseCity (String cityName) throws InterruptedException {
        searchByCityField.click();
        searchByCityInput.sendKeys(cityName);
        Thread.sleep(1500);
        firstResultCity.click();

    }

    public boolean isPageOpen() {
        return welcome.isDisplayed();
    }

    public void FilInTableSignUP(SignUp signUp) {

        new Input(driver,"First Name").write(signUp.getName());
        new Input(driver,"Last Name").write(signUp.getLastName());
        new Input(driver,"Phone").write(signUp.getPhone());
        new Input(driver,"Email").write(signUp.getEmail());
        new Input(driver,"Password").write(signUp.getPassword());


    }


}
