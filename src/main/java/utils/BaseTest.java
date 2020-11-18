package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import entities.browser.Browser;
import entities.browser.ChromeBrowser;
import entities.browser.FirefoxBrowser;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.IndexPage;

import static java.lang.invoke.MethodHandles.lookup;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browserName) {
        setupBrowser(browserName);
    }

    public void setupBrowser(String browserName) {
        LOGGER.info("Setting up {} driver", browserName);
        Browser browser;
        switch (browserName) {
            case "chrome":
                browser = new ChromeBrowser();
                break;
            case "firefox":
                browser = new FirefoxBrowser();
                break;
            default:
                LOGGER.error("BROWSER NOT FOUND");
                throw new NotImplementedException(String.format("Browser '%s' not found. Please implement", browserName));
        }
        setupDriver(browser);
    }

    @AfterMethod
    public void teardown() {
        WebDriverRunner.closeWebDriver();
    }

    public IndexPage openStartPage() {
        String url = System.getProperty("url.address");
        LOGGER.info("Navigating to {}", url);
        Selenide.open(url);
        return LoadingPageFactory.get(IndexPage.class);
    }

    private void setupDriver(Browser browser) {
        if (Boolean.parseBoolean(System.getProperty("selenoid.enabled"))) {
            setupWebDriver(browser);
        } else {
            setupRemoteWebDriver(browser);
        }
    }

    private void setupRemoteWebDriver(Browser browser) {
        LOGGER.info("Setting up local WebDriver");
        Configuration.browser = browser.getType();
        Configuration.browserSize = browser.getResolution();
    }

    private void setupWebDriver(Browser browser) {
        LOGGER.info("Setting up remote WebDriver for Selenoid");
        String selenoidHubAddress = System.getProperty("selenoid.hub.address");
        Configuration.remote = selenoidHubAddress + "/wd/hub";
        Configuration.browser = browser.getType();
        Configuration.browserVersion = browser.getVersion();
        Configuration.browserSize = browser.getResolution();
        Configuration.browserCapabilities = browser.getCapabilities();
    }
}