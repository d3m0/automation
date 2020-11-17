package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import entities.Browser;
import entities.ChromeBrowser;
import entities.FirefoxBrowser;
import org.openqa.selenium.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.IndexPage;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getSimpleName());

    @BeforeMethod()
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browserName) {
        LOGGER.trace("Setting up {} driver", browserName);
        try {
            switch (browserName) {
                case "chrome":
                    setupDriver(new ChromeBrowser());
                    break;
                case "firefox":
                    setupDriver(new FirefoxBrowser());
                    break;
            }
        } catch (IllegalArgumentException exception) {
            LOGGER.error("BROWSER NOT FOUND");
            throw new NotFoundException(String.format("Browser '%s' not found. Please add", browserName));
        }
    }

    @AfterMethod
    public void teardown() {
        WebDriverRunner.closeWebDriver();
    }

    public IndexPage openStartPage() {
        String url = System.getProperty("url.address");
        LOGGER.trace("Navigating to {}", url);
        Selenide.open(url);
        return LoadingPageFactory.get(IndexPage.class);
    }

    private void setupDriver(Browser browser) {
        if (Boolean.parseBoolean(System.getProperty("selenoid.enabled"))) {
            setupWebDriverWithSelenoid(browser);
        } else {
            setupWebDriverWithWebDriverManager(browser);
        }
    }

    private void setupWebDriverWithWebDriverManager(Browser browser) {
        LOGGER.trace("Setting up driver with WebDriverManager");
        Configuration.browser = browser.getType();
        Configuration.browserSize = browser.getResolution();
    }

    private void setupWebDriverWithSelenoid(Browser browser) {
        LOGGER.trace("Setting up driver with Selenoid");
        String selenoidHubAddress = System.getProperty("selenoid.hub.address");
        Configuration.remote = selenoidHubAddress + "/wd/hub";
        Configuration.browser = browser.getType();
        Configuration.browserVersion = browser.getVersion();
        Configuration.browserSize = browser.getResolution();
        Configuration.browserCapabilities = browser.getCapabilities();
    }
}