package testcases;

import builders.UserBuilder;
import entities.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegistrationTest extends BaseTest {
    @BeforeMethod()
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        super.setup(browser);
    }

    @Test
    public void userIsAbleToNavigateToAuthenticationPage() {
        openStartPage().navigateToAuthenticationPage();
    }

    @Test(dependsOnMethods = "userIsAbleToNavigateToAuthenticationPage")
    public void userIsAbleToCreateAccount() {
        User user = new UserBuilder().build();
        openStartPage()
                .navigateToAuthenticationPage()
                .navigateToCreateAccountPage(user.getEmail())
                .fillAccountInfo(user);

    }
}
