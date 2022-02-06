package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='My Store']")
    private WebElement logo;

    @FindBy(css = ".login")
    private WebElement signInButton;

    @Override
    public boolean pageIsDisplayed() {
        return logo.isDisplayed();
    }

    @Step(value = "Click on Sign In button")
    public void clickOnSignInButton() {
        click(signInButton);
    }
}
