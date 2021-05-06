package testcases;

import automation.utils.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.testng.annotations.*;

@Slf4j
public class FailingCases extends BaseTest {
    private static final String INCORRECT_XPATH = ".//ul[not(contains(@style, 'display: none'))]/li/a[@title='T-shirts']/span";

    @BeforeSuite
    public void setup(@Optional("chrome") String browserName) {
    }

    @BeforeTest
    public void setup1(@Optional("chrome") String browserName) {
        log.debug("Setting up browser for test elementIsNotPresentOnAPage");
        setupBrowser(browserName);
    }

    @Test(description = "Verify test fails because of element is not present on a page", expectedExceptions = ElementNotFound.class)
    public void elementIsNotPresentOnAPage() {
        openStartPage();
        SelenideElement tShirtsButton = Selenide.$(By.xpath(INCORRECT_XPATH));
        tShirtsButton.shouldBe(Condition.visible);
    }

    @BeforeTest
    public void setup2(@Optional("chrome") String browserName) {
        log.debug("Setting up browser for test clickNonexistentElement");
        setupBrowser(browserName);
    }

    @Test(description = "Verify test fails when trying to click nonexistent element", expectedExceptions = ElementNotFound.class)
    public void clickNonexistentElement() {
        openStartPage();
        SelenideElement tShirtsButton = Selenide.$(By.xpath(INCORRECT_XPATH));
        tShirtsButton.click();
    }

    @Test(description = "Verify incorrect browser behaviour", expectedExceptions = NotImplementedException.class)
    @Parameters({"IncorrectBrowser"})
    public void incorrectBrowser(@Optional("IncorrectBrowser") String browser) {
        setupBrowser(browser);
        openStartPage();
    }
}