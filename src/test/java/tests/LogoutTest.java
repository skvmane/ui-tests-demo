package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import static config.ConfigManager.getConfiguration;
import static org.assertj.core.api.Assertions.assertThat;

public class LogoutTest extends BaseTest {

    @Epic(value = "Authorization")
    @Story(value = "Test for logout")
    @Test(testName = "Logout")
    public void successfulLogout() {
        HomePage homepage = new HomePage(driver);
        MyAccountPage myAccPage = new MyAccountPage(driver);
        AuthenticationPage authPage = new AuthenticationPage(driver);

        homepage.clickOnSignInButton();
        authPage.fillEmailToSignIn(getConfiguration().username());
        authPage.fillPassword(getConfiguration().password());
        authPage.clickOnSubmitButton();
        assertThat(myAccPage.pageIsDisplayed())
                .isTrue();
        myAccPage.clickOnSignOutButton();
        assertThat(homepage.pageIsDisplayed())
                .isTrue();
    }
}
