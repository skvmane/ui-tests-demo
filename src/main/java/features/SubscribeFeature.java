package features;

import models.user.UserModel;
import pages.common.Footer;

import static driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SubscribeFeature {
    private final Footer footer;
    private final UserModel user;


    public SubscribeFeature(UserModel user) {
        this.user = user;
        this.footer = new Footer(getDriver());
    }

    public SubscribeFeature subscribe() {
        footer.fillNewsletterEmail(user.getEmail())
                .clickOnNewsletterSubmitButton();
        assertThat(footer.getAlertText()).contains("You have successfully subscribed");
        return this;
    }
}
