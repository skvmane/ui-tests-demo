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
1. [Install Java 8 or higher on your local machine](https://java.com/en/download/) and [set the JAVA_HOME Environment Variable](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
2. [Install Apache Maven] (https://maven.apache.org/install.html)
### MacOS
TBD

## Run tests from IDE
1. [Install IntelliJ IDEA](https://www.jetbrains.com/idea/) IDE
2. Install Lombok Plugin: `IntelliJ IDEA > Preferences > Plugins > Browse repositories > Lombok Plugin`
3. Enable annotation processing: `IntelliJ IDEA > Preferences > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing`
4. Checkout project from git
5. Start import as Maven project
6. Go to the `src/test/resources/test.xml` , open context menu and click `Run`

## Run tests using command line
1. Download project files from git
Go to the checkout folder using cd java-api-test-demo
Start test using command for Windows: gradlew clean test for macOS: ./gradlew clean test
After test finished to generate the report using next command for Windows gradlew allureReport && gradlew allureServe for macOS: ./gradlew allureReport && ./gradlew allureServe


