package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.IndexPage;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    public void setup(String browser) {
        LOGGER.trace("Setting up {} driver", browser);
        setupDriver(Browser.valueOf(browser.toUpperCase()));
    }

    public void setupDriver(Browser browser) {
        WebDriver webDriver = null;

        MutableCapabilities browserOptions = OptionsManager.getOptions(browser);

        if (Boolean.parseBoolean(System.getProperty("selenoid.enabled"))) {
            DesiredCapabilities capabilities = CapabilitiesManager.getCapabilities(browserOptions);
            String selenoidHubAddress = System.getProperty("selenoid.hub.address");
            try {
                webDriver = new RemoteWebDriver(URI.create(selenoidHubAddress + "/wd/hub").toURL(), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver((ChromeOptions) browserOptions);
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver((FirefoxOptions) browserOptions);
            }
        }

        driver.set(webDriver);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    public void terminate() {
        //Remove the ThreadLocalMap element
        driver.remove();
    }

    public IndexPage openStartPage() {
        WebDriver driver = getDriver();
        WebDriverRunner.setWebDriver(driver);
        String url = System.getProperty("url.address");
        LOGGER.trace("Navigating to {}", url);
        Selenide.open(url);
        return LoadingPageFactory.get(driver, IndexPage.class);
    }

    private WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
}