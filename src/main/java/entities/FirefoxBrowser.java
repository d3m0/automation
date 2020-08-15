package entities;

import enums.BrowserType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.OptionsManager;

public class FirefoxBrowser implements Browser {
    @Override
    public BrowserType getType() {
        return BrowserType.FIREFOX;
    }

    @Override
    public FirefoxOptions getBrowserOptions() {
        return OptionsManager.getFirefoxOptions();
    }

    @Override
    public RemoteWebDriver getDriver() {
        return new FirefoxDriver();
    }
}
