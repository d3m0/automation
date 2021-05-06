package automation.utils;

import automation.entities.browser.Browser;
import automation.entities.browser.ChromeBrowser;
import automation.entities.browser.FirefoxBrowser;
import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;

/**
 * @author Andrii Mogyla
 * @since 19.04.2021
 */
@Slf4j
public class BrowserConfiguration {
    public void setupBrowser(String browserName) {
        log.info("Setting up {} driver", browserName);
        Browser browser;
        switch (browserName) {
            case "chrome":
                browser = new ChromeBrowser();
                break;
            case "firefox":
                browser = new FirefoxBrowser();
                break;
            default:
                log.error("BROWSER NOT FOUND");
                throw new NotImplementedException(String.format("Browser '%s' not found. Please implement", browserName));
        }
        setupDriver(browser);
    }

    private void setupDriver(Browser browser) {
        if (Boolean.parseBoolean(System.getProperty("selenoid.enabled"))) {
            log.info("Setting up remote WebDriver for Selenoid");
            String selenoidHubAddress = System.getProperty("selenoid.hub.address");
            Configuration.remote = selenoidHubAddress + "/wd/hub";
            Configuration.browser = browser.getType();
            Configuration.browserVersion = browser.getVersion();
            Configuration.browserSize = browser.getResolution();
            Configuration.browserCapabilities = browser.getCapabilities();
        } else {
            log.info("Setting up local WebDriver");
            Configuration.browser = browser.getType();
            Configuration.browserSize = browser.getResolution();
        }
    }
}