package utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {
    public static DesiredCapabilities getCapabilities(MutableCapabilities browserOptions) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Browser browser = Browser.valueOf(browserOptions.getBrowserName().toUpperCase());
        switch (browser) {
            case CHROME:
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("81.0");
                break;
            case FIREFOX:
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("75.0");
        }
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability(ChromeOptions.CAPABILITY, browserOptions);
        return capabilities;
    }
}
