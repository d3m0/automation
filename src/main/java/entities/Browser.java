package entities;

import enums.BrowserType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Browser {
    BrowserType getType();

    MutableCapabilities getBrowserOptions();

    RemoteWebDriver getDriver();
}
