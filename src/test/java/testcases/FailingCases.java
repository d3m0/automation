package testcases;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class FailingCases extends BaseTest {
    @BeforeMethod()
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        super.setup(browser);
    }

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
}
