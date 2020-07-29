package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import forms.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LoadingPageFactory;
import utils.Verify;

import static com.codeborne.selenide.Selenide.$;

@Verify(title = "React App")
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

    public void verifyNameDisplayed() {
        LOGGER.info("Verifying 'Name' field is visible");
        nameInput.shouldBe(Condition.visible);
    }

    public void verifyRoomNameDisplayed() {
        LOGGER.info("Verifying 'Room name' field is visible");
        roomNameInput.shouldBe(Condition.visible);
    }

    public void verifySubmitButtonDisplayed() {
        LOGGER.info("Verifying 'Submit' button is visible");
        submitButton.shouldBe(Condition.visible);
    }

    public RoomPage login(String name, String roomName) {
        LOGGER.trace("Logging in as '{}' to room '{}'", name, roomName);
        nameInput.setValue(name);
        roomNameInput.setValue(roomName);
        submitButton.click();
        return LoadingPageFactory.get(driver, RoomPage.class);
    }

    public void verifyLoginFormVisible() {
        LOGGER.info("Verifying login form is visible");
        $(loginForm.getSelf()).shouldBe(Condition.visible);
    }
}
