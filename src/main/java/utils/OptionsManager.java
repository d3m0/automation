package utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
    public static MutableCapabilities getOptions(Browser browser) {
        MutableCapabilities browserOptions;
        switch (browser) {
            case CHROME:
            default:
                browserOptions = OptionsManager.getChromeOptions();
                break;
            case FIREFOX:
                browserOptions = OptionsManager.getFirefoxOptions();
                break;
        }
        return browserOptions;
    }

    private static ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

    private static FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions();
    }

}