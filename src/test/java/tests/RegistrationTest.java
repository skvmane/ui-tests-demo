package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.user.User;
import models.user.UserDataFactory;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    @Epic(value = "Signing-up")
    @Story(value = "Test for account creation")
    @Test(testName = "Successful registration")
    public void successfulRegister() throws InterruptedException {
        User user = new UserDataFactory().create();

        HomePage homepage = new HomePage(driver);
        homepage.clickOnSignInButton();
        AuthenticationPage authPage = new AuthenticationPage(driver);
        authPage.fillEmailToCreate(user.getEmail());
        authPage.clickOnCreateButton();
        AccountCreationPage createPage = new AccountCreationPage(driver);
        assertThat(createPage.pageIsDisplayed())
                .isTrue();
        createPage.selectMaleGender();
        createPage.fillFirstName(user.getFirstName());
        createPage.fillLastName(user.getLastName());
        createPage.fillPassword(user.getPassword());
        createPage.selectDay(user.getDayOfBirth());
        createPage.selectMonth(user.getMonthOfBirth());
        createPage.selectYear(user.getYearOfBirth());
        createPage.signForNewsletter();
        createPage.signForSpecialOffers();
        createPage.fillAddrFirstName(user.getFirstName());
        createPage.fillAddrLastName(user.getLastName());
        createPage.fillCompany(user.getCompany());
        createPage.fillMainAddress(user.getAddressMain());
        createPage.fillSecondAddress(user.getAddressSecond());
        createPage.fillCity(user.getCity());
        createPage.selectState(user.getState());
        createPage.fillZip(user.getPostcode());
        createPage.selectCountry(user.getCountry());
        createPage.fillAdditionalInfo(user.getAdditionalInfo());
        createPage.fillPhone(user.getPhone());
        createPage.fillMobilePhone(user.getPhoneMobile());
        createPage.fillAlias(user.getAddressAlias());
        createPage.register();
        MyAccountPage myAccPage = new MyAccountPage(driver);
        assertThat(myAccPage.pageIsDisplayed())
                .isTrue();
    }
}
