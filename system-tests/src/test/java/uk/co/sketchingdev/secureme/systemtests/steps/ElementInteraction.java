package uk.co.sketchingdev.secureme.systemtests.steps;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.sketchingdev.secureme.systemtests.selenium.ByFactory;

import java.util.Objects;

public class ElementInteraction extends IntegrationTestSteps {

    private final WebDriver driver;

    private final WebDriverWait wait;

    private final ByFactory byFactory;

    @Autowired
    private ElementInteraction(WebDriver webDriver, WebDriverWait wait, ByFactory byFactory) {
        this.driver = Objects.requireNonNull(webDriver);
        this.wait = Objects.requireNonNull(wait);
        this.byFactory = Objects.requireNonNull(byFactory);
    }

    @When("^I enter \"([^\"]*)\" into input field having (id|class|css|name|xpath) \"([^\"]*)\"$")
    public void enter_text(String text, String elementType, String elementName) {
        By by = byFactory.getByType(elementType, elementName);

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(text);
    }

    @When("^I click on element having (id|class|css|name|xpath) \"(.*?)\"$")
    public void click(String elementType, String elementName) {
        By by = byFactory.getByType(elementType, elementName);

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.click();
    }
}
