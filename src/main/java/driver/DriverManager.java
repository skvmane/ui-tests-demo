package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static void removeDriver() {
        getDriver().quit();
        DRIVER.remove();
    }


}
