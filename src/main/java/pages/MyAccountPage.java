package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".logout")
    private WebElement signOutButton;

    @Override
    public boolean pageIsDisplayed() {
        return signOutButton.isDisplayed();
    }
    
    @Step(value = "Click on Sign Out button")
    public void clickOnSignOutButton() {
        click(signOutButton);
    }

}
