package pages;

import com.codeborne.selenide.WebDriverRunner;
import forms.HeaderForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LoadingPageFactory;
import utils.Verify;

@Verify(title = "My Store")
public class IndexPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexPage.class.getSimpleName());
    private final WebDriver webDriver;

    @FindBy(id = "header")
    private HeaderForm headerForm;

    private IndexPage() {
        webDriver = WebDriverRunner.getWebDriver();
    }

    public void verifyTopMenu() {
        LOGGER.trace("Verifying Top Menu block");
        headerForm.verifyLinkArePresent();
    }

    public WomenCategoryPage navigateToWomenCategory() {
        LOGGER.trace("Navigating to WOMEN category");
        headerForm.clickWomenCategory();
        return LoadingPageFactory.get(webDriver, WomenCategoryPage.class);
    }

    public DressesCategoryPage navigateToDressesCategory() {
        LOGGER.trace("Navigating to DRESSES category");
        headerForm.clickDressesCategory();
        return LoadingPageFactory.get(webDriver, DressesCategoryPage.class);
    }

    public TShirtsCategoryPage navigateToTShirtsCategory() {
        LOGGER.trace("Navigating to T-SHIRTS category");
        headerForm.clickTShirtsCategory();
        return LoadingPageFactory.get(webDriver, TShirtsCategoryPage.class);
    }

    public AuthenticationPage navigateToAuthenticationPage() {
        LOGGER.trace("Navigating to Authentication page");
        headerForm.clickSignInButton();
        return LoadingPageFactory.get(webDriver, AuthenticationPage.class);
    }
}
