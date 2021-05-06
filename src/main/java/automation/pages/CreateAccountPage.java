package automation.pages;

import automation.entities.User;
import automation.forms.CreateAccountForm;
import automation.utils.LoadingPageFactory;
import automation.utils.Verify;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.FindBy;

@Slf4j
@Verify(title = "Login - My Store")
public class CreateAccountPage {

    @FindBy(id = "account-creation_form")
    private CreateAccountForm createAccountForm;

    public CreateAccountPage fillAccountInfo(User user) {
        log.info("Filling user information {}", user.toString());
        createAccountForm.fillPersonalInformation(user);
        createAccountForm.fillYourAddress(user);
        return this;
    }

    public MyAccountPage register() {
        log.info("Clicking REGISTER button");
        createAccountForm.register();
        return LoadingPageFactory.get(MyAccountPage.class);
    }
}
