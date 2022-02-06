package driver;

import exceptions.BrowserNotSupportedException;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import services.AbstractFactory;

import static config.ConfigManager.getConfiguration;

@Log4j2
public class DriverOptionsFactory implements AbstractFactory<AbstractDriverOptions, String> {

    static final String START_MAXIMIZED = "--start-maximized";

    @Override
    public AbstractDriverOptions create(String browser) {
        try {
            Browser browserType = Browser.valueOf(browser.toUpperCase());

            switch (browserType) {
                case CHROME:
                    return getChromeOptions();
                case FIREFOX:
                    return getFireFoxOptions();
                case EDGE:
                    return getEdgeOptions();
                default:
                    throw new BrowserNotSupportedException("Browser " + browser + " is not supported");
            }
        } catch (BrowserNotSupportedException e) {
            log.error(e.getMessage());
        }
        return null;
    }


    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(getConfiguration().headless());
        chromeOptions.addArguments(START_MAXIMIZED);

        return chromeOptions;
    }

    public FirefoxOptions getFireFoxOptions() {
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setHeadless(getConfiguration().headless());
        ffOptions.addArguments(START_MAXIMIZED);

        return ffOptions;
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setHeadless(getConfiguration().headless());
        edgeOptions.addArguments(START_MAXIMIZED);

        return edgeOptions;
    }

}
