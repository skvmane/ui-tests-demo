package driver;

import exceptions.InvalidTargetException;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static config.ConfigManager.getConfiguration;

@Log4j2
public class TargetFactory {
    public WebDriver createInstance(String browser) {
        try {
            WebDriver driver;
            Target target = Target.valueOf(getConfiguration().target().toUpperCase());

            switch (target) {
                case LOCAL:
                    driver = new DriverFactory().create(browser);
                    break;
                case REMOTE:
                    driver = createRemoteInstance(new DriverOptionsFactory().create(browser));
                    break;
                default:
                    throw new InvalidTargetException("Target is not supported");
            }
            return driver;
        } catch (InvalidTargetException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities option) {
        try {
            RemoteWebDriver remoteDriver;
            String host = String.format("%s://%s:%s",
                    getConfiguration().protocol(),
                    getConfiguration().host(),
                    getConfiguration().port());
            remoteDriver = new RemoteWebDriver(new URL(host), option);
            return remoteDriver;
        } catch (MalformedURLException e) {
            log.error("Invalid remote host URL");
        }
        return null;
    }

    enum Target {
        LOCAL, REMOTE
    }
}
