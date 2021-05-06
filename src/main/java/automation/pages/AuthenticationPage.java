package automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LoadingPageFactory;
import utils.Verify;

import static java.lang.invoke.MethodHandles.lookup;

@Verify(title = "Login - My Store")
public class AuthenticationPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());

    @FindBy(id = "email_create")
    private SelenideElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    private SelenideElement createAccountButton;

    public CreateAccountPage navigateToCreateAccountPage(String email) {
        LOGGER.info("Logging in with email {}", email);
        emailAddressInput.setValue(email);
        createAccountButton.click();
        return LoadingPageFactory.get(CreateAccountPage.class);
    }
}
