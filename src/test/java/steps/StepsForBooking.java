package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StepsForBooking extends CommonSteps {

    String cityName;
    public static final By DATAPICKER = By.cssSelector("(//*[@class=\"datepicker dropdown-menu\"])[1]");


    public void setDatepicker(WebDriver driver, String cssSelector, String date)
    {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(
            String.format("$('body.fixed-nav:nth-child(2)>div.datepicker.dropdown-menu:nth-child(27)').datepicker('setDate','07-06-2022')", cssSelector, date));
    }
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
        Thread.sleep(20000);
        driver.findElement(By.xpath("(//*[@role='option'])[1]")).click();

    }

    @And("User chooses real arrivalDate for booking")
    public void userChoosesRealArrivalDateForBooking() {
        click(homePage.ARRIVAL_DATE);
        click(By.xpath("((//*[@class='datepicker-days'])[1]//tr//td[contains(text(),'24')])[2]"));
    }

    @And("User chooses real departureDate for booking")
    public void userChoosesRealDepartureDateForBooking() {
        click(By.xpath("//p[contains(text(),'Travellers')]"));
        click(homePage.DEPARTURE_DATE);
        click(By.xpath("(//td[@class='day '][contains(text(),'30')])[2]"));
    }

    @And("User chooses travellers and rooms")
    public void userChoosesTravellersAndRooms() {
        click(By.xpath("//p[contains(text(),'Travellers')]"));
        click(By.cssSelector(".roomInc i:first-child"));
        click(By.xpath("(//input[@id='adults']/../div)[2]/i"));

    }

    @And("User chooses past arrivalDate for booking")
    public void userChoosesPastArrivalDateForBooking() {
        click(homePage.ARRIVAL_DATE);
        setDatepicker(driver, "body.fixed-nav:nth-child(2) > div.datepicker.dropdown-menu:nth-child(27)", "07-06-2022");
       // click(By.xpath("((//*[@class='datepicker-days'])[1]//tr//td[contains(text(),'24')])[1]"));
    }

    @And("User click on search button")
    public void userClickOnSearchButton() {
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


    @Then("PastDate is not selected")
    public void pastdateIsNotSelected() {
        System.out.println("h");

    }
}
