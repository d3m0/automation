package testcases;

import builders.UserBuilder;
import entities.User;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegistrationTest extends BaseTest {
    @Test
    public void userIsAbleToNavigateToAuthenticationPage() {
        openStartPage().navigateToAuthenticationPage();
    }

    @Test
    public void userIsAbleToCreateAccount() {
        User user = new UserBuilder().build();
        openStartPage()
                .navigateToAuthenticationPage()
                .navigateToCreateAccountPage(user.getEmail())
                .fillAccountInfo(user)
                .register();
    }
}
