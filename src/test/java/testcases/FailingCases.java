package testcases;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class FailingCases extends BaseTest {
   @Test
    public void testShouldFailBecauseElementIsNotPresentOnAPage() {
        openStartPage();
        SelenideElement tShirtsButton = Selenide.$(By.xpath(".//ul[not(contains(@style, 'display: none'))]/li/a[@title='T-shirts']/span"));
        Assert.assertTrue(tShirtsButton.isDisplayed(), "T-SHIRTS button is present on page");
    }

    @Test
    public void testShouldFailWhenTryingToClickAbsentElement() {
        openStartPage();
        SelenideElement tShirtsButton = Selenide.$(By.xpath(".//ul[not(contains(@style, 'display: none'))]/li/a[@title='T-shirts']/span"));
        tShirtsButton.click();
    }

    @Test
    public void testShouldFailBecauseOfIncorrectBrowser() {
        openStartPage();
    }
}
