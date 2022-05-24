package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFactory {

    WebDriver driver;

    public HomePageFactory(WebDriver idriver) {
        this.driver = idriver;
    }

    @FindBy(xpath ="//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")
    WebElement signupButton;


    @FindBy(xpath ="//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")
    WebElement loginButton;

    @FindBy(xpath ="//span[@id='select2-hotels_city-container']")
    WebElement searchByCityField;

    @FindBy(css ="#checkin")
    WebElement checkinDate;

    @FindBy(css ="#checkout")
    WebElement checkoutDate;


    @FindBy(xpath ="//body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/p[1]")
    WebElement travellersChose;

    @FindBy(xpath ="//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/button[1]/span[1]/i[1]")
    WebElement searchButton;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    WebElement searchByCityInput;

    @FindBy(xpath = "(//*[@role='option'])[1]")
    WebElement firstResultCity;

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
}
