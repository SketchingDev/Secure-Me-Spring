# Secure-Me Spring [![Build Status](https://travis-ci.org/SketchingDev/Secure-Me-Spring.svg?branch=development)](https://travis-ci.org/SketchingDev/Secure-Me-Spring)

This project (currently under heavy development) is a [Spring MVC][spring-mvc] website with a worrying number of 
vulnerabilities! Your job is to learn about common vulnerabilities in modern web-applications by finding and fixing 
them.

Testing the state of the vulnerabilities is achieved by running the [Selenium][selenium] based system-tests.

## Selenium tests

The Selenium tests are specific to Chrome as they pass Chrome specific arguments to disable automatic XSS protection.

### Locally

1. Install [Chrome][chrome]
2. Download the [Chrome Driver][chrome-driver]
3. Set the Chrome Driver's location in either:
  * `webdriver.chrome.driver` property in `system-tests/src/test/resources/application.properties`
  * `WEBDRIVER_CHROME_DRIVER` environment variable

### Remote

A Selenium server with headless Chrome can be setup with Docker.

1. Install [Docker][docker-install]
2. Pull the [Selenium Standalone Server with Chrome image][selenium-server-chrome-image] 
  * `$ docker pull selenium/standalone-chrome`
3. Start the image
  * `$ docker run -d -p 4444:4444 selenium/standalone-chrome`
4. Set the Selenium Server's endpoint in either:
  * `selenium.hub.url` property in `system-tests/src/test/resources/application.properties`
  * `SELENIUM_HUB_URL` environment variable

## Vulnerabilities

* Cross-site scripting (XSS)
  * Reflected
  
[spring-mvc]: https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc
[selenium]: http://www.seleniumhq.org/
[chrome]: https://www.google.co.uk/chrome/browser/desktop/index.html
[chrome-driver]: https://sites.google.com/a/chromium.org/chromedriver/getting-started
[docker-install]: https://docs.docker.com/engine/installation/
[selenium-server-chrome-image]: https://hub.docker.com/r/selenium/standalone-chrome/