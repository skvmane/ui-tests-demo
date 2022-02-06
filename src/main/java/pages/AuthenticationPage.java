package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class AuthenticationPage extends BasePage {

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/h1[text()='Authentication']")
    private WebElement pageHeader;

    @FindBy(id = "email")
    private WebElement signInEmail;

    @FindBy(id = "email_create")
    private WebElement createEmail;

    @FindBy(id = "passwd")
    private WebElement signPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreate;

    @Override
    public boolean pageIsDisplayed() {
        return pageHeader.isDisplayed();
    }

    @Step(value = "Fill email field with {0} to sign in")
    public void fillEmailToSignIn(String email) {
        writeText(signInEmail, email);
    }

    @Step(value = "Fill password field with {0} to sign in")
    public void fillPassword(String password) {
        writeText(signPassword, password);
    }

    @Step(value = "Click on submit login button")
    public void clickOnSubmitButton() {
        click(submitLogin);
    }

    @Step(value = "Fill email field with {0} to create account")
    public void fillEmailToCreate(String email) {
        writeText(createEmail, email);
    }

    @Step(value = "Click on create button")
    public void clickOnCreateButton() {
        click(submitCreate);
    }

}
