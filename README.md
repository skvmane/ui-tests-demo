# ui-tests-demo

## Project details:
UI Automation framework written on Java with [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/). The framework also supports such libraries as:
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) - carries out the management (i.e., download, setup) of the drivers required by Selenium WebDriver
- [TestNG](https://testng.org/doc/) - testing framework
- [Owner](https://github.com/matteobaccan/owner) - property reader
- [AssertJ](https://assertj.github.io/doc/) - provides fluent assertions
- [Lombok](https://github.com/projectlombok/lombok) - to reduce boilerplate code for model/data objects
- [Allure](https://github.com/allure-framework/allure-java) - test reporting tool
- [Log4j2](https://logging.apache.org/log4j/2.x/) - logging utility

## Preconditions
### Windows
1. [Install Java 8 or higher on your local machine] (https://java.com/en/download/) and [Set the JAVA_HOME Environment Variable] (https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
2. [Install Apache Maven] (https://maven.apache.org/install.html)





## Run tests
The test cases are located in the `test_suites` directory. They can be executed from terminal using `robot` command:
>robot calc_demo_suite.robot
