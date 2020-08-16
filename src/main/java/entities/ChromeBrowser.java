package entities;

import enums.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.OptionsManager;

public class ChromeBrowser implements Browser {
    @Override
    public BrowserType getType() {
        return BrowserType.CHROME;
    }

    @Override
    public ChromeOptions getBrowserOptions() {
        return OptionsManager.getChromeOptions();
    }

    @Override
    public RemoteWebDriver getDriver() {
        return new ChromeDriver(getBrowserOptions());
    }
}
