import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.IndexPage;
import utils.BaseTest;

public class IndexPageTest extends BaseTest {
    @BeforeMethod()
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        super.setup(browser);
    }

    @Test
    public void verifyIndexPageOpened() {
        openStartPage();
    }

    @Test
    public void verifyTopMenu() {
        IndexPage indexPage = openStartPage();
        indexPage.verifyTopMenu();
    }

    @Test
    public void userIsAbleToNavigateToWomenCategory() {
        IndexPage indexPage = openStartPage();
        indexPage.navigateToWomenCategory();
    }

    @Test
    public void userIsAbleToNavigateToDressesCategory() {
        IndexPage indexPage = openStartPage();
        indexPage.navigateToDressesCategory();
    }

    @Test
    public void userIsAbleToNavigateToTShirtsCategory() {
        IndexPage indexPage = openStartPage();
        indexPage.navigateToTShirtsCategory();
    }
}