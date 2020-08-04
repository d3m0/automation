package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import forms.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Verify;

@Verify(title = "My Store")
public class IndexPage {
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexPage.class);
    private final WebDriver driver;
    @FindBy(xpath = "//h2[normalize-space()='Enter a room']/ancestor::form")
    private LoginForm loginForm;

    @FindBy(id = "field")
    private SelenideElement nameInput;

    @FindBy(id = "room")
    private SelenideElement roomNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    private SelenideElement submitButton;

    IndexPage() {
        driver = WebDriverRunner.getWebDriver();
    }
}
