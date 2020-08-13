package pages;

import entities.User;
import forms.CreateAccountForm;
import org.openqa.selenium.support.FindBy;
import utils.Verify;

@Verify(title = "Login - My Store")
public class CreateAccountPage {
    @FindBy(id = "account-creation_form")
    private CreateAccountForm createAccountForm;

    public void fillAccountInfo(User user) {
        createAccountForm.fillPersonalInformation(user);
    }
}
