package entities;

import enums.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeBrowser implements Browser {
    @Override
    public BrowserType getType() {
        return BrowserType.CHROME;
    }

    @Override
    public ChromeOptions getBrowserOptions() {
        return new ChromeOptions();
    }

    @Override
    public RemoteWebDriver getDriver() {
        return new ChromeDriver(getBrowserOptions());
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("84.0");
        capabilities.setCapability(ChromeOptions.CAPABILITY, getBrowserOptions());
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}
