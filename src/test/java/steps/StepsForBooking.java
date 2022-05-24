package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.HomePageFactory;

import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.*;

public class StepsForBooking extends CommonSteps {
    HomePageFactory homePageFactory =PageFactory.initElements(driver,HomePageFactory.class);


    String arrivalDateAtFirst;

    @Before
    public void start() {
        setUp();

    }

    @Given("User on the Homepage")
    public void userOnTheHomepage() {
        driver.get("https://www.phptravels.net");

        arrivalDateAtFirst = driver.findElement(By.id("checkin")).getAttribute("value");
    }

    @When("User enters cityName {string} for booking")
    public void userEntersCityNameForBooking(String cityName) throws InterruptedException {
        HomePageFactory homePageFactory =PageFactory.initElements(driver,HomePageFactory.class);
        homePageFactory.chooseCity(cityName);
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
        int dayOfMonth = Calendar.DAY_OF_MONTH;
        int pastDay;
        if (dayOfMonth == 1) {
            click(By.xpath("((//*[@class='datepicker-days'])[1]//tr//td[contains(text(),'30')])[1]"));
        } else {
            pastDay = dayOfMonth - 1;
            click(By.xpath("((//*[@class='datepicker-days'])[1]//tr//td[contains(text(),'" + pastDay + "')])[1]"));
        }


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('checkin').setAttribute('value', '07-06-2022')");

    }

    @And("User click on search button")
    public void userClickOnSearchButton() {
        click(By.xpath("(//button[@id='submit'])[1]"));
    }

    @Then("Searching is failed")
    public void searchingIsFailed() {
        assertTrue(driver.findElement(By.cssSelector("[alt='no results']")).isEnabled());
    }

    @Then("PastDate is not selected")
    public void pastdateIsNotSelected() {
        assertEquals(driver.findElement(By.id("checkin")).getAttribute("value"), arrivalDateAtFirst);


    }

    @After
    public void finish() {
        tearDown();

    }


}
