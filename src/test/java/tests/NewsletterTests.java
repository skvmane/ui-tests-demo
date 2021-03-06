package tests;

import features.SubscribeFeature;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.user.UserModel;
import org.testng.annotations.Test;
import providers.UserModelProvider;

public class NewsletterTests extends BaseTest {
    @Epic("Newsletter")
    @Story("Successful newsletter subscription")
    @Test(dataProvider = "getDefaultUser",
            dataProviderClass = UserModelProvider.class,
            testName = "HP-1")
    public void successfulSubscription(UserModel user) {
        new SubscribeFeature(user).subscribe();
    }
}
