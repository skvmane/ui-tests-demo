package tests;


import driver.DriverManager;
import driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static config.ConfigManager.getConfiguration;


public abstract class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setupRun() {
        String browser = getConfiguration().browser();
        driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);
        String baseUrl = getConfiguration().baseUrl();
        DriverManager.getDriver().get(baseUrl);
    }

    @AfterMethod
    public void teardown() {
        DriverManager.removeDriver();
    }
}
