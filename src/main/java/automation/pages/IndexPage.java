package automation.pages;

import automation.forms.HeaderForm;
import automation.utils.LoadingPageFactory;
import automation.utils.Verify;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.FindBy;

@Slf4j
@Verify(title = "My Store")
public class IndexPage {

    @FindBy(id = "header")
    private HeaderForm headerForm;

    public void verifyTopMenu() {
        log.info("Verifying Top Menu block");
        headerForm.verifyLinkArePresent();
    }

    public WomenCategoryPage navigateToWomenCategory() {
        log.info("Navigating to WOMEN category");
        headerForm.clickWomenCategory();
        return LoadingPageFactory.get(WomenCategoryPage.class);
    }

    public DressesCategoryPage navigateToDressesCategory() {
        log.info("Navigating to DRESSES category");
        headerForm.clickDressesCategory();
        return LoadingPageFactory.get(DressesCategoryPage.class);
    }

    public TShirtsCategoryPage navigateToTShirtsCategory() {
        log.info("Navigating to T-SHIRTS category");
        headerForm.clickTShirtsCategory();
        return LoadingPageFactory.get(TShirtsCategoryPage.class);
    }

    public AuthenticationPage navigateToAuthenticationPage() {
        log.info("Navigating to Authentication page");
        headerForm.clickSignInButton();
        return LoadingPageFactory.get(AuthenticationPage.class);
    }
}