package pages.common;

import org.openqa.selenium.WebDriver;
import services.AbstractServicePage;

public abstract class BasePage extends AbstractServicePage {
    private Footer footer;

    public BasePage(WebDriver driver) {
        super(driver);
        this.footer = new Footer(driver);
    }

    public Footer getFooter() {
        return footer;
    }
}
