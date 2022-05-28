package tests;

import features.UserRegistrationFeature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.user.UserModel;
import org.testng.annotations.Test;
import providers.UserModelProvider;

public class RegistrationTests extends BaseTest {
    @Epic("Signing-up")
    @Story("Account creation")
    @Test(dataProvider = "getDefaultUser",
            dataProviderClass = UserModelProvider.class,
            testName = "LP-5")
    public void successfulRegistration(UserModel user) {
        new UserRegistrationFeature(user).fillAllFields()
                .createUser();
    }
}
