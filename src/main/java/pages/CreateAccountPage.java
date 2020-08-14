package pages;

import entities.User;
import forms.CreateAccountForm;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LoadingPageFactory;
import utils.Verify;

import static java.lang.invoke.MethodHandles.lookup;

@Verify(title = "Login - My Store")
public class CreateAccountPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());

    @FindBy(id = "account-creation_form")
    private CreateAccountForm createAccountForm;

    public CreateAccountPage fillAccountInfo(User user) {
        LOGGER.trace("Filling user information {}", user.toString());
        createAccountForm.fillPersonalInformation(user);
        createAccountForm.fillYourAddress(user);
        return this;
    }

    public MyAccountPage register() {
        LOGGER.trace("Clicking REGISTER button");
        createAccountForm.register();
        return LoadingPageFactory.get(MyAccountPage.class);
    }
}
