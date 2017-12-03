package uk.co.sketchingdev.secureme.systemtests.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.util.Objects;

public class NavigationSteps extends IntegrationTestSteps {

    private final WebDriver driver;

    private final URI uri;

    @Autowired
    public NavigationSteps(WebDriver driver, @Value("${webapp.url}") URI uri) {
        this.driver = Objects.requireNonNull(driver);
        this.uri = Objects.requireNonNull(uri);
    }

    @Given("^I navigate to \"([^\"]*)\" of the website$")
    public void i_navigate_to_x_of_the_website(String page) {
        driver.get(uri.resolve(page) + page);
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void navigate_to(String link) {
        driver.get(link);
    }
}
