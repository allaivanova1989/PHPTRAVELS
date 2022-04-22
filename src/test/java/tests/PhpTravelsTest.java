package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/login.feature"},
        glue = "steps",
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class PhpTravelsTest extends AbstractTestNGCucumberTests {

}