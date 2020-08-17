package utils;

import enums.BrowserType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {
    public static DesiredCapabilities getCapabilities(MutableCapabilities browserOptions) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        BrowserType browserType = BrowserType.valueOf(browserOptions.getBrowserName().toUpperCase());
        switch (browserType) {
            case CHROME:
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("84.0");
                capabilities.setCapability(ChromeOptions.CAPABILITY, browserOptions);
                break;
            case FIREFOX:
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("79.0");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, browserOptions);
        }
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}
