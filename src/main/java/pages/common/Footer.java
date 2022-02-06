package pages.common;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import services.AbstractServicePage;

public class Footer extends AbstractServicePage {

    public Footer(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "footer")
    private WebElement footerContainer;

    @FindBy(id = "newsletter_block_left")
    private WebElement newsletter;

    @FindBy(id = "newsletter-input")
    private WebElement newsletterEmailField;

    @FindBy(xpath = "//button[@name='submitNewsletter']")
    private WebElement submitNewsletterButton;

    @FindBy(css = ".alert-success")
    private WebElement successAlert;

    @Override
    public boolean pageIsDisplayed() {
        return footerContainer.isDisplayed();
    }

    @Step(value = "Fill email field with {0}")
    public void fillNewsletterEmail(String email) {
        writeText(newsletterEmailField, email);
    }

    @Step(value = "Click on submit button")
    public void clickOnNewsletterSubmitButton() {
        click(submitNewsletterButton);
    }

    @Step(value = "Check successful subscription")
    public String getAlert() {
        return successAlert.getText();
    }
}
