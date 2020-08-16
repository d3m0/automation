package forms;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
        Assert.assertTrue(womenButton.isDisplayed(), "WOMEN button is present on page");
        Assert.assertTrue(dressesButton.isDisplayed(), "DRESSES button is present on page");
        Assert.assertTrue(tShirtsButton.isDisplayed(), "T-SHIRTS button is present on page");
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