package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import models.user.User;
import models.user.UserDataFactory;
import org.testng.annotations.Test;
import pages.common.Footer;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsletterTest extends BaseTest {

    @Epic(value = "Newsletter")
    @Story(value = "Test for successful subscription")
    @Test(testName = "Newsletter successful subscription")
    public void successfulSubscription() {
        Footer footer = new Footer(driver);
        User user = new UserDataFactory().create();

        footer.fillNewsletterEmail(user.getEmail());
        footer.clickOnNewsletterSubmitButton();
        assertThat(footer.getAlert()).contains("You have successfully subscribed");
    }
}
