package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertTrue;

public class StepsForBooking extends CommonSteps{

    String cityName;
    String arrivalDate;
    String departureDate;

    @Before
    public void start() {
        setUp();

    }

    @Given("User on the start page")
    public void userOnTheStartPage() {
        driver.get("https://www.phptravels.net");
    }

    @When("User enters cityName {string} for booking")
    public void userEntersCityNameForBooking(String cityName) throws InterruptedException {
        this.cityName = cityName;
        click(By.xpath("(//span[contains(text(), 'Search by City')])[1]"));
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(cityName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@role='option'])[1]")).click();

    }

    @And("User enters arrivalDate {string} for booking")
    public void userEntersArrivalDateForBooking(String arrivalDate) {
        this.arrivalDate = arrivalDate;
        Actions actions = new Actions(driver);
        WebElement element =   driver.findElement(By.xpath("//*[@id='checkin']"));

        actions.sendKeys(element,arrivalDate).perform();

    }

    @And("User enters departuredate {string} for booking")
    public void userEntersDeparturedateForBooking(String departureDate) {
        this.departureDate = departureDate;
        driver.findElement(By.id("checkout")).sendKeys(departureDate);
        System.out.println();
    }

    @And("User chooses travellers and rooms")
    public void userChoosesTravellersAndRooms() {
        click(By.xpath("//p[contains(text(),'Travellers')]"));
        click(By.cssSelector(".roomInc i:first-child"));
        click(By.xpath("(//input[@id='adults']/../div)[2]/i"));



    }

    @And("User click on searche button")
    public void userClickOnSearcheButton() {
        click(By.xpath("(//button[@id='submit'])[1]"));
    }

    @Then("Searching is failed")
    public void searchingIsFailed() {
        assertTrue(driver.findElement(By.cssSelector("[alt='no results']")).isEnabled());
    }
    @After
    public void finish() {
        tearDown();

    }



}
