package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class AccountCreationPage extends BasePage {
    @FindBy(xpath = "//textarea[@id='other']")
    private WebElement additionalInfo;
    @FindBy(xpath = "//button[@name='submitAccount']")
    private WebElement registerButton;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return registerButton.isDisplayed();
    }

    public WebElement getRadioButton(String radioButtonName) {
        String path = String.format("//label[contains(., '%s')]//input", radioButtonName);
        return driver.findElement(By.xpath(path));
    }

    public WebElement getInput(String inputName) {
        String path = String.format("//label[@for='%s']/following-sibling::input", inputName);
        return driver.findElement(By.xpath(path));
    }

    public WebElement getDropdown(String dropdownName) {
        String path = String.format("//select[@name='%s']", dropdownName);
        return driver.findElement(By.xpath(path));
    }

    public WebElement getCheckBox(String checkBoxName) {
        String path = String.format("//input[@type='checkbox'and @name='%s']", checkBoxName);
        return driver.findElement(By.xpath(path));
    }

    @Step("Select male radio button")
    public AccountCreationPage selectMaleGender() {
        click(getRadioButton("Mr."));
        return this;
    }

    @Step("Select female radio button")
    public AccountCreationPage selectFemaleGender() {
        click(getRadioButton("Mrs."));
        return this;
    }

    @Step("Fill input with {1}")
    public AccountCreationPage setInput(String inputName, String inputValue) {
        writeText(getInput(inputName), inputValue);
        return this;
    }

    @Step("Select {0} as day of birth")
    public AccountCreationPage selectDay(int index) {
        selectByIndex(getDropdown("days"), index);
        return this;
    }

    @Step("Select {0} as month of birth")
    public AccountCreationPage selectMonth(int index) {
        selectByIndex(getDropdown("months"), index);
        return this;
    }

    @Step("Select {0} as year of birth")
    public AccountCreationPage selectYear(int index) {
        selectByIndex(getDropdown("years"), index);
        return this;
    }

    @Step("Select {0} checkbox")
    public AccountCreationPage selectCheckBox(String checkBoxName) {
        if (getCheckBox(checkBoxName).isSelected()) {
            System.out.println("Checkbox is already selected");
        } else {
            getCheckBox(checkBoxName).click();
        }
        return this;
    }

    @Step("Select {0} state")
    public AccountCreationPage selectState(int index) {
        selectByIndex(getDropdown("id_state"), index);
        return this;
    }

    @Step("Select country")
    public AccountCreationPage selectCountry(int index) {
        selectByIndex(getDropdown("id_country"), index);
        return this;
    }

    @Step("Fill additional info field with {0}")
    public AccountCreationPage fillAdditionalInfo(String value) {
        writeText(additionalInfo, value);
        return this;
    }

    @Step("Click on register button")
    public AccountCreationPage register() {
        click(registerButton);
        return this;
    }
}
