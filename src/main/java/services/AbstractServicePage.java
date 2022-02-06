package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static config.ConfigManager.getConfiguration;

public abstract class AbstractServicePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractServicePage(final WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, getConfiguration().timeout());
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public abstract boolean pageIsDisplayed();

    //Click
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //Enter text
    public void writeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    //Select element from dropdown
    public void selectByIndex(WebElement element, int index) {
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }


}
