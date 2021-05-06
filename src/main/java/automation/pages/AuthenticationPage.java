package automation.pages;

import automation.utils.LoadingPageFactory;
import automation.utils.Verify;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.FindBy;

@Slf4j
@Verify(title = "Login - My Store")
public class AuthenticationPage {
    @FindBy(id = "email_create")
    private SelenideElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    private SelenideElement createAccountButton;

    public CreateAccountPage navigateToCreateAccountPage(String email) {
        log.info("Logging in with email {}", email);
        emailAddressInput.setValue(email);
        createAccountButton.click();
        return LoadingPageFactory.get(CreateAccountPage.class);
    }
}
