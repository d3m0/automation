package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utils.LoadingPageFactory;
import utils.Verify;

@Verify(title = "Login - My Store")
public class AuthenticationPage {
    private final WebDriver webDriver;

    @FindBy(id = "email_create")
    private SelenideElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    private SelenideElement createAccountButton;

    private AuthenticationPage() {
        webDriver = WebDriverRunner.getWebDriver();
    }

    public CreateAccountPage navigateToCreateAccountPage(String email) {
        emailAddressInput.setValue(email);
        createAccountButton.click();
        return LoadingPageFactory.get(webDriver, CreateAccountPage.class);
    }
}
