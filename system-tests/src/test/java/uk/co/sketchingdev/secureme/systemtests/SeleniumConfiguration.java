package uk.co.sketchingdev.secureme.systemtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
@ComponentScan
public class SeleniumConfiguration {

    @Bean
    @ConditionalOnProperty("selenium.hub.url")
    public WebDriver remoteWebDriver(@Value("${selenium.hub.url}") URL seleniumHubUrl,
                                     DesiredCapabilities capabilities) {

        return new RemoteWebDriver(seleniumHubUrl, capabilities);
    }

    @Bean
    @ConditionalOnProperty("webdriver.chrome.driver")
    public WebDriver localWebDriver(@Value("${webdriver.chrome.driver}") String chromeDriverLocation,
                                    DesiredCapabilities capabilities) {

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        return new ChromeDriver(capabilities);
    }

    @Bean
    public DesiredCapabilities capabilities() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-xss-auditor");

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return capabilities;
    }

    @Bean
    public WebDriverWait webDriverWait(@Value("${webdriver.timeout}") String timeout, WebDriver webDriver) {
        return new WebDriverWait(webDriver, Integer.parseInt(timeout));
    }
}
