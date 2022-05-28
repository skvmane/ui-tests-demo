package tests;

import features.LoginFeature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Epic("Authorization")
    @Story("Login with valid credentials")
    @Test(testName = "LP-1")
    public void successfulLogin() {
        new LoginFeature().login();
    }

    @Epic("Authorization")
    @Story("Login with invalid password")
    @Test(testName = "LP-2")
    public void failedLogin() {
        new LoginFeature().invalidPassLogin();
    }

    @Epic("Authorization")
    @Story("Login with valid credentials")
    @Test(testName = "LP-3")
    public void verifyPassMasking() {
        new LoginFeature().verifyPassMasking();
    }
}
