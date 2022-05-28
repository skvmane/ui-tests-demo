package features;

import models.user.UserModel;
import pages.AccountCreationPage;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import static driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class UserRegistrationFeature {
    private final HomePage homepage;
    private final AuthenticationPage authPage;
    private final AccountCreationPage createPage;
    private final MyAccountPage myAccountPage;
    private final UserModel user;

    public UserRegistrationFeature(UserModel user) {
        this.user = user;
        this.homepage = new HomePage(getDriver());
        this.authPage = new AuthenticationPage(getDriver());
        this.createPage = new AccountCreationPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    public UserRegistrationFeature fillAllFields() {
        homepage.clickOnSignInButton();
        authPage.setInput("email_create", user.getEmail())
                .clickOnSubmitButton("SubmitCreate");
        assertThat(createPage.pageIsDisplayed())
                .as("Account creation page is not displayed")
                .isTrue();
        createPage.selectMaleGender()
                .setInput("customer_firstname", user.getFirstName())
                .setInput("customer_lastname", user.getLastName())
                .setInput("passwd", user.getPassword())
                .selectDay(user.getDayOfBirth())
                .selectMonth(user.getMonthOfBirth())
                .selectYear(user.getYearOfBirth())
                .selectCheckBox("newsletter")
                .selectCheckBox("optin")
                .setInput("firstname", user.getFirstName())
                .setInput("lastname", user.getLastName())
                .setInput("company", user.getCompany())
                .setInput("address1", user.getAddressMain())
                .setInput("address2", user.getAddressSecond())
                .setInput("city", user.getCity())
                .selectState(user.getState())
                .setInput("postcode", user.getPostcode())
                .selectCountry(user.getCountry())
                .fillAdditionalInfo(user.getAdditionalInfo())
                .setInput("phone", user.getPhone())
                .setInput("phone_mobile", user.getPhoneMobile())
                .setInput("alias", user.getAddressAlias());
        return this;
    }

    public UserRegistrationFeature createUser() {
        createPage.register();
        assertThat(myAccountPage.pageIsDisplayed())
                .as("My Account page is not displayed")
                .isTrue();
        return this;
    }
}
