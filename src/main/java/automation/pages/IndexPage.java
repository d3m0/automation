package automation.pages;

import forms.HeaderForm;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LoadingPageFactory;
import utils.Verify;

import static java.lang.invoke.MethodHandles.lookup;

@Verify(title = "My Store")
public class IndexPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());

    @FindBy(id = "header")
    private HeaderForm headerForm;

    public void verifyTopMenu() {
        LOGGER.info("Verifying Top Menu block");
        headerForm.verifyLinkArePresent();
    }

    public WomenCategoryPage navigateToWomenCategory() {
        LOGGER.info("Navigating to WOMEN category");
        headerForm.clickWomenCategory();
        return LoadingPageFactory.get(WomenCategoryPage.class);
    }

    public DressesCategoryPage navigateToDressesCategory() {
        LOGGER.info("Navigating to DRESSES category");
        headerForm.clickDressesCategory();
        return LoadingPageFactory.get(DressesCategoryPage.class);
    }

    public TShirtsCategoryPage navigateToTShirtsCategory() {
        LOGGER.info("Navigating to T-SHIRTS category");
        headerForm.clickTShirtsCategory();
        return LoadingPageFactory.get(TShirtsCategoryPage.class);
    }

    public AuthenticationPage navigateToAuthenticationPage() {
        LOGGER.info("Navigating to Authentication page");
        headerForm.clickSignInButton();
        return LoadingPageFactory.get(AuthenticationPage.class);
    }
}