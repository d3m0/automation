package forms;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends ElementsContainer {
    @FindBy(xpath = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='Women']")
    private SelenideElement womenButton;

    @FindBy(xpath = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='Dresses']")
    private SelenideElement dressesButton;

    @FindBy(xpath = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='T-shirts']")
    private SelenideElement tShirtsButton;

    public void verifyLinkArePresent() {
        assert womenButton.isDisplayed();
        assert dressesButton.isDisplayed();
        assert tShirtsButton.isDisplayed();
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
}
