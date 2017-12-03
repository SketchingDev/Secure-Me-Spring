package uk.co.sketchingdev.secureme.systemtests.steps;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import uk.co.sketchingdev.secureme.systemtests.SeleniumConfiguration;

@ContextConfiguration(classes = SeleniumConfiguration.class)
@TestPropertySource(locations="classpath:application.properties")
abstract class IntegrationTestSteps {
}
