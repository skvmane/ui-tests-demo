package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "//div/a[contains(text(), 'Sign out')]")
    private WebElement signOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return driver.getCurrentUrl().endsWith("my-account");
    }

    @Step("Click on Sign Out button")
    public void clickOnSignOutButton() {
        click(signOutButton);
    }
}
