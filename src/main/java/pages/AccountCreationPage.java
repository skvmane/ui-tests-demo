package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;

public class AccountCreationPage extends BasePage {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    //Personal info block elements
    @FindBy(xpath = "//input[@value='1']")
    private WebElement radioMale;

    @FindBy(xpath = "//input[@value='2']")
    private WebElement radioFemale;

    @FindBy(id = "customer_firstname")
    private WebElement personalFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement personalLastName;

    @FindBy(id = "email")
    private WebElement personalEmail;

    @FindBy(id = "passwd")
    private WebElement personalPassword;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daySelect;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthSelect;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearSelect;

    @FindBy(xpath = "//input[@type='checkbox' and @id='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@type='checkbox' and @id='optin']")
    private WebElement optinCheckbox;

    //Address block elements
    @FindBy(id = "firstname")
    private WebElement addressFirstName;

    @FindBy(id = "lastname")
    private WebElement addressLastName;

    @FindBy(id = "company")
    private WebElement addressCompany;

    @FindBy(id = "address1")
    private WebElement addressMain;

    @FindBy(id = "address2")
    private WebElement addressSecond;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(xpath = "//select[@id='id_country']")
    private WebElement countrySelect;

    @FindBy(css = "textarea[id*='other']")
    private WebElement additionalInfo;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    //Methods
    @Override
    public boolean pageIsDisplayed() {
        return registerButton.isDisplayed();
    }

    @Step(value = "Select gender radio button (male)")
    public void selectMaleGender() {
        click(radioMale);
    }

    @Step(value = "Select gender radio button (female)")
    public void selectFemaleGender() {
        click(radioFemale);
    }

    @Step(value = "Fill First name field with {0}")
    public void fillFirstName(String email) {
        writeText(personalFirstName, email);
    }

    @Step(value = "Fill Last name field with {0}")
    public void fillLastName(String email) {
        writeText(personalLastName, email);
    }

    @Step(value = "Fill password field with {0}")
    public void fillPassword(String password) {
        writeText(personalPassword, password);
    }

    @Step(value = "Select {0} as day of birth")
    public void selectDay(int index) {
        selectByIndex(daySelect, index);
    }

    @Step(value = "Select {0} as month of birth")
    public void selectMonth(int index) {
        selectByIndex(monthSelect, index);
    }

    @Step(value = "Select {0} as year of birth")
    public void selectYear(int index) {
        selectByIndex(yearSelect, index);
    }

    @Step(value = "Sign up for newsletter")
    public void signForNewsletter() {
        if (newsletterCheckbox.isSelected()) {
            System.out.println("Checkbox is already selected");
        } else {
            newsletterCheckbox.click();
        }
    }

    @Step(value = "Sign up for special offers")
    public void signForSpecialOffers() {
        if (optinCheckbox.isSelected()) {
            System.out.println("Checkbox is already selected");
            ;
        } else {
            newsletterCheckbox.click();
        }
    }

    @Step(value = "Fill First name field on address block with {0}")
    public void fillAddrFirstName(String email) {
        writeText(addressFirstName, email);
    }

    @Step(value = "Fill Last name field on address block with {0}")
    public void fillAddrLastName(String email) {
        writeText(addressLastName, email);
    }

    @Step(value = "Fill Company field with {0}")
    public void fillCompany(String email) {
        writeText(addressCompany, email);
    }

    @Step(value = "Fill main address field with {0}")
    public void fillMainAddress(String email) {
        writeText(addressMain, email);
    }

    @Step(value = "Fill second address field with {0}")
    public void fillSecondAddress(String email) {
        writeText(addressSecond, email);
    }

    @Step(value = "Fill City field with {0}")
    public void fillCity(String email) {
        writeText(city, email);
    }

    @Step(value = "Select state")
    public void selectState(int index) {
        selectByIndex(stateSelect, index);
    }

    @Step(value = "Fill Postal code field with {0}")
    public void fillZip(String email) {
        writeText(postcode, email);
    }

    @Step(value = "Select country")
    public void selectCountry(int index) {
        selectByIndex(countrySelect, index);
    }

    @Step(value = "Fill additional info field with {0}")
    public void fillAdditionalInfo(String email) {
        writeText(additionalInfo, email);
    }

    @Step(value = "Fill home phone field with {0}")
    public void fillPhone(String email) {
        writeText(phone, email);
    }

    @Step(value = "Fill mobile phone field with {0}")
    public void fillMobilePhone(String email) {
        writeText(phoneMobile, email);
    }

    @Step(value = "Fill alias field with {0}")
    public void fillAlias(String email) {
        writeText(addressAlias, email);
    }

    @Step(value = "Click on register button")
    public void register() {
        click(registerButton);
    }


}
