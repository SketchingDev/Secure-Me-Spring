Feature: XSS Vulnerabilities
  As a user I should able to inject JavaScript into the pages

  Scenario: Reflected XSS
    Given I navigate to "/" of the website
    When I enter "<script>alert('Hello World')</script>" into input field having id "search"
    And I click on element having id "search-submit"
    Then I should see an alert with the text "Hello World"