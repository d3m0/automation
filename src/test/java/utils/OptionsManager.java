package utils;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("use-fake-ui-for-media-stream");
        chromeOptions.addArguments("use-fake-device-for-media-stream");
        return chromeOptions;
    }

    public static ChromeOptions getChromeOptions(ChromeOptions options) {
        return options == null ? getChromeOptions() : options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("media.navigator.streams.fake", true);
        firefoxOptions.addPreference("media.navigator.permission.disabled", false);
        return firefoxOptions;
    }

    public static FirefoxOptions getFirefoxOptions(FirefoxOptions options) {
        return options == null ? getFirefoxOptions() : options;
    }

    public static MutableCapabilities getOptions(Browser browser, boolean useFakeVideoStream) {
        MutableCapabilities browserOptions;
        switch (browser) {
            case CHROME:
            default:
                browserOptions = (useFakeVideoStream) ? OptionsManager.getChromeOptions() : OptionsManager.getChromeOptions(new ChromeOptions());
                break;
            case FIREFOX:
                browserOptions = (useFakeVideoStream) ? OptionsManager.getFirefoxOptions() : OptionsManager.getFirefoxOptions(new FirefoxOptions());
                break;
        }
        return browserOptions;
    }
}
