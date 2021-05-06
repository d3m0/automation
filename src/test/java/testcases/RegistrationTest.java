package testcases;

import automation.builders.UserBuilder;
import automation.entities.User;
import automation.utils.BaseTest;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    public void userIsAbleToNavigateToAuthenticationPage() {
        openStartPage().navigateToAuthenticationPage();
    }

    @Test(description = "User is able to create account")
    public void userIsAbleToCreateAccount() {
        User user = new UserBuilder().build();
        openStartPage()
                .navigateToAuthenticationPage()
                .navigateToCreateAccountPage(user.getEmail())
                .fillAccountInfo(user)
                .register();
    }
}
