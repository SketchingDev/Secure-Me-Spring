package uk.co.sketchingdev.secureme.systemtests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber/SeleniumRunnerIT"},
        features = "classpath:features",
        glue = "uk.co.sketchingdev.secureme.systemtests.steps"
)
public class SeleniumRunnerIT {
}
