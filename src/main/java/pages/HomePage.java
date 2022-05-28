package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return driver.getCurrentUrl().endsWith("index.php");
    }

    @Step("Click on Sign In button")
    public void clickOnSignInButton() {
        click(signInButton);
    }
}
