package uk.co.sketchingdev.secureme.systemtests.selenium;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class ByFactory {

    public By getByType(String type, String byValue) {
        switch(type) {
            case "id":
                return By.id(byValue);
            case "name":
                return By.name(byValue);
            case "class":
                return By.className(byValue);
            case "xpath":
                return By.xpath(byValue);
            case "css":
                return By.cssSelector(byValue);
            case "linkText":
                return By.linkText(byValue);
            case "partialLinkText":
                return By.partialLinkText(byValue);
            case "tagName":
                return By.tagName(byValue);
            default:
                throw new IllegalArgumentException(String.format("Type '%s' not supported", type));
        }
    }
}
