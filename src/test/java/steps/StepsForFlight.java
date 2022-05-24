package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class StepsForFlight extends CommonSteps{
    String airlineName;
    static Optional<WebElement> result;

    @Before
    public void start() {
        setUp();

    }
    @Given("User on the flightsPage")
    public void userOnTheFlightsPage() {
        driver.get("https://www.phptravels.net/flights");

    }

    @When("User look for flights company {string}")
    public void userLookForFlightCompany (String airlineName) {
        this.airlineName = airlineName;
        List<WebElement> airlines = driver.findElements(By.xpath("//h6"));
        result = airlines.stream()
                        .filter( text->text.getText().equals(airlineName) )
                                .findAny();

    }
    @Then("Airline was found")
    public void airlineWasFound() {
        assertNotNull(result);


    }

    @After
    public void finish() {
        tearDown();

    }


}
