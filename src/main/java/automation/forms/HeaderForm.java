package automation.forms;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class HeaderForm extends ElementsContainer {
    @FindBy(xpath = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='Women']")
    private SelenideElement womenButton;

    @FindBy(xpath = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='Dresses']")
    private SelenideElement dressesButton;

    @FindBy(xpath = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='T-shirts']")
    private SelenideElement tShirtsButton;

    @FindBy(xpath = ".//nav//a[@class='login']")
    private SelenideElement signInButton;

    public void verifyLinkArePresent() {
        womenButton.shouldBe(visible);
        dressesButton.shouldBe(visible);
        tShirtsButton.shouldBe(visible);
    }

    public void clickWomenCategory() {
        womenButton.click();
    }

    public void clickDressesCategory() {
        dressesButton.click();
    }

    public void clickTShirtsCategory() {
        tShirtsButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}