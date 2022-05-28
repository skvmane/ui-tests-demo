package providers;

import models.user.UserDataFactory;
import org.testng.annotations.DataProvider;

public class UserModelProvider {

    @DataProvider(name = "getDefaultUser")
    public Object[][] getDefaultUser() {
        var defaultUserModel = new UserDataFactory().getDefaultUser();
        return new Object[][]{
                {
                        defaultUserModel
                }
        };
    }
}
