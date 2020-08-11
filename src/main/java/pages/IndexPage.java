package pages;

import com.codeborne.selenide.WebDriverRunner;
import forms.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LoadingPageFactory;
import utils.Verify;

@Verify(title = "My Store")
public class IndexPage {
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexPage.class.getSimpleName());
    private final WebDriver webDriver;
    @FindBy(xpath = "//div[@id='block_top_menu']")
    private TopMenu topMenu;

    private IndexPage() {
        webDriver = WebDriverRunner.getWebDriver();
    }

    public void verifyTopMenu() {
        LOGGER.trace("Verifying Top Menu block");
        topMenu.verifyLinkArePresent();
    }

    public WomenCategoryPage navigateToWomenCategory() {
        LOGGER.trace("Navigating to WOMEN category");
        topMenu.clickWomenCategory();
        return LoadingPageFactory.get(webDriver, WomenCategoryPage.class);
    }

    public DressesCategoryPage navigateToDressesCategory() {
        LOGGER.trace("Navigating to DRESSES category");
        topMenu.clickDressesCategory();
        return LoadingPageFactory.get(webDriver, DressesCategoryPage.class);
    }

    public TShirtsCategoryPage navigateToTShirtsCategory() {
        LOGGER.trace("Navigating to T-SHIRTS category");
        topMenu.clickTShirtsCategory();
        return LoadingPageFactory.get(webDriver, TShirtsCategoryPage.class);
    }
}
