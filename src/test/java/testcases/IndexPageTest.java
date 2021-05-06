package testcases;

import automation.pages.IndexPage;
import automation.utils.BaseTest;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseTest {
    @Test(description = "Verify that starting page opens")
    public void verifyIndexPageOpened() {
        openStartPage();
    }

    @Test
    public void verifyTopMenu() {
        openStartPage().verifyTopMenu();
    }

    @Test
    public void userIsAbleToNavigateToWomenCategory() {
        openStartPage().navigateToWomenCategory();
    }

    @Test(dependsOnMethods = "userIsAbleToNavigateToWomenCategory")
    public void verifyWomenCategoryPageContainsAllBlocks() {
        openStartPage().navigateToWomenCategory().verifyBlocksPresent();
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