package entities;

import enums.BrowserType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxBrowser implements Browser {
    @Override
    public BrowserType getType() {
        return BrowserType.FIREFOX;
    }

    @Override
    public FirefoxOptions getBrowserOptions() {
        return new FirefoxOptions();
    }

    @Override
    public RemoteWebDriver getDriver() {
        return new FirefoxDriver(getBrowserOptions());
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("79.0");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getBrowserOptions());
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}