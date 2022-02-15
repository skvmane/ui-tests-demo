package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import static config.ConfigManager.getConfiguration;
import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest{

    @Epic(value = "Authorization")
    @Story(value = "Test for login with valid credentials")
    @Test(testName = "Successful login")
    public void successfulLogin() {
        HomePage homepage = new HomePage(driver);
        MyAccountPage myAccPage = new MyAccountPage(driver);
        AuthenticationPage authPage = new AuthenticationPage(driver);

        homepage.clickOnSignInButton();
        authPage.fillEmailToSignIn(getConfiguration().username());
        authPage.fillPassword(getConfiguration().password());
        authPage.clickOnSubmitButton();
        assertThat(myAccPage.pageIsDisplayed())
                .isTrue();
    }

}
