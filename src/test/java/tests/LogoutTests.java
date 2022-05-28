package tests;

import features.LoginFeature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {
    @Epic("Authorization")
    @Story("Logout")
    @Test(testName = "LP-4")
    public void successfulLogout() {
        new LoginFeature().login().logout();
    }
}
