package uk.co.sketchingdev.secureme.systemtests.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ElementAssertions extends IntegrationTestSteps {

    private final WebDriver driver;

    @Autowired
    public ElementAssertions(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver);
    }

    @Then("^an element containing the text \"([^\"]*)\" should\\s*((?:not)?)\\s+exist$")
    public void an_element_containing_the_text_x_should_x_exist(String text, String notMatch) {
        boolean isPresent = notMatch.isEmpty();

        By xPath = By.xpath(String.format("//*[contains(text(),'%s')]", text));
        assertEquals(isPresent, !driver.findElements(xPath).isEmpty());
    }

    @Then("^I should see an alert with the text \"(.*?)\"$")
    public void i_should_see_an_alert_with_the_text(String expectedValue) {
        String actualValue = driver.switchTo().alert().getText();
        assertEquals(expectedValue, actualValue);
    }
}
