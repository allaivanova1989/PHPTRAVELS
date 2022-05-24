package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Input {
    private String inputLocator = "//input[@placeholder='%s']";
    WebDriver driver;
    String Label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        Label = label;
    }
    public void write(String text) {
        log.info("Write " + text + " in the input " + this.Label + " when creating an userData");

        WebElement element =   driver.findElement(By.xpath(String.format(inputLocator, this.Label)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(String.format(inputLocator, this.Label))).sendKeys(text);

    }
    public String getText() {
        log.info("Get text from the field " + this.Label);
        return driver.findElement(By.xpath(String.format(inputLocator, this.Label))).getText();

    }
}
