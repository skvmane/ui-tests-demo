package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

import java.util.List;

public class AuthenticationPage extends BasePage {
    @FindBy(xpath = "//div/h1[text()='Authentication']")
    private WebElement pageHeader;
    @FindBy(xpath = "//div[contains(@class, 'alert')]//ol/li")
    private List<WebElement> authErrors;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return pageHeader.isDisplayed();
    }

    public WebElement getInput(String inputId) {
        String path = String.format("//input[@id='%s']", inputId);
        return driver.findElement(By.xpath(path));
    }

    public WebElement getButton(String buttonName) {
        String path = String.format("//button[contains(@name, '%s')]", buttonName);
        return driver.findElement(By.xpath(path));
    }

    @Step("Fill input {0} with {1}")
    public AuthenticationPage setInput(String inputId, String inputValue) {
        writeText(getInput(inputId), inputValue);
        return this;
    }

    @Step("Click on {0} button")
    public void clickOnSubmitButton(String buttonName) {
        click(getButton(buttonName));
    }

    @Step("Check for auth error")
    public boolean authErrorIsDisplayed() {
        return authErrors.stream().anyMatch(s -> s.getText().contains("Authentication failed"));
    }

    @Step("Check is password masked")
    public boolean isPassMasked() {
        return getInput("passwd").getAttribute("type")
                .equals("password");
    }
}
