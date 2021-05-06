package automation.utils;

import automation.pages.IndexPage;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Slf4j
public class BaseTest extends BrowserConfiguration {
    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browserName) {
        setupBrowser(browserName);
    }

    @AfterMethod
    public void teardown() {
        Selenide.closeWebDriver();
    }

    public IndexPage openStartPage() {
        Selenide.open();
        String url = System.getProperty("url.address");
        log.info("Navigating to {}", url);
        Selenide.open(url);
        return LoadingPageFactory.get(IndexPage.class);
    }

}