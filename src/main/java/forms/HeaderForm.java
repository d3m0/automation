package forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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
        womenButton.shouldBe(Condition.visible);
        dressesButton.shouldBe(Condition.visible);
        tShirtsButton.shouldBe(Condition.visible);
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