package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
 * This class is dedicated for setting custom options if needed
 */
public class OptionsManager {
    public static ChromeOptions getChromeOptions() {
        return new ChromeOptions();
    }

    public static FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions();
    }
}