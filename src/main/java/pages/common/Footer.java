package pages.common;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.AbstractServicePage;

public class Footer extends AbstractServicePage {
    @FindBy(id = "footer")
    private WebElement footerContainer;
    @FindBy(id = "newsletter-input")
    private WebElement newsletterEmailField;
    @FindBy(xpath = "//button[@name='submitNewsletter']")
    private WebElement submitNewsletterButton;
    @FindBy(css = ".alert-success")
    private WebElement successAlert;

    public Footer(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return footerContainer.isDisplayed();
    }

    @Step("Fill email field with {0}")
    public Footer fillNewsletterEmail(String email) {
        writeText(newsletterEmailField, email);
        return this;
    }

    @Step("Click on submit button")
    public Footer clickOnNewsletterSubmitButton() {
        click(submitNewsletterButton);
        return this;
    }

    @Step("Check successful subscription")
    public String getAlertText() {
        return successAlert.getText();
    }
}
