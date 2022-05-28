package features;

import com.github.javafaker.Faker;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import static config.ConfigManager.getConfiguration;
import static driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginFeature {
    private final HomePage homepage;
    private final AuthenticationPage authPage;
    private final MyAccountPage myAccountPage;
    private final Faker faker = new Faker();

    public LoginFeature() {
        this.homepage = new HomePage(getDriver());
        this.authPage = new AuthenticationPage(getDriver());
        this.myAccountPage = new MyAccountPage(getDriver());
    }

    public LoginFeature login() {
        homepage.clickOnSignInButton();
        assertThat(authPage.pageIsDisplayed())
                .as("Authentication page is not displayed")
                .isTrue();
        authPage.setInput("email", getConfiguration().username())
                .setInput("passwd", getConfiguration().password())
                .clickOnSubmitButton("SubmitLogin");
        verifySuccessLogin();
        return this;
    }

    public LoginFeature verifySuccessLogin() {
        assertThat(myAccountPage.pageIsDisplayed())
                .as("My Account page is not displayed")
                .isTrue();
        return this;
    }

    public LoginFeature invalidPassLogin() {
        homepage.clickOnSignInButton();
        assertThat(authPage.pageIsDisplayed())
                .as("Authentication page is not displayed")
                .isTrue();
        authPage.setInput("email", getConfiguration().username())
                .setInput("passwd", faker.internet().password(5, 10))
                .clickOnSubmitButton("SubmitLogin");
        verifyFailedLogin();
        return this;
    }

    public LoginFeature verifyFailedLogin() {
        assertThat(authPage.pageIsDisplayed())
                .as("Authentication page is not displayed")
                .isTrue();
        assertThat(authPage.authErrorIsDisplayed())
                .as("Authentication error is not displayed")
                .isTrue();
        return this;
    }

    public LoginFeature verifyPassMasking() {
        homepage.clickOnSignInButton();
        authPage.setInput("passwd", getConfiguration().password());
        assertThat(authPage.isPassMasked())
                .as("Password field is not masked")
                .isTrue();
        return this;
    }

    public LoginFeature logout() {
        myAccountPage.clickOnSignOutButton();
        assertThat(authPage.pageIsDisplayed())
                .as("Authentication page is not displayed")
                .isTrue();
        return this;
    }
}
