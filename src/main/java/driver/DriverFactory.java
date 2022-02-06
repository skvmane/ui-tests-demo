package driver;

import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import services.AbstractFactory;

@Log4j2
public class DriverFactory implements AbstractFactory<WebDriver, String> {

    @Override
    public WebDriver create(String browser) {
        try {
            Browser browserType = Browser.valueOf(browser.toUpperCase());
            AbstractDriverOptions driverOptions = new DriverOptionsFactory().create(browser);

            switch (browserType) {
                case CHROME:
                    WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                    return new ChromeDriver((ChromeOptions) driverOptions);
                case FIREFOX:
                    WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                    return new FirefoxDriver((FirefoxOptions) driverOptions);
                case EDGE:
                    WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                    return new EdgeDriver((EdgeOptions) driverOptions);
                default:
                    throw new BrowserNotSupportedException("Browser " + browser + " is not supported");
            }
        } catch (BrowserNotSupportedException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
