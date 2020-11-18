package entities.browser;

import com.codeborne.selenide.Browsers;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser implements Browser {
    @Override
    public String getType() {
        return Browsers.CHROME;
    }

    @Override
    public String getVersion() {
        return StringUtils.defaultIfEmpty(System.getProperty("browser.version"), "84.0");
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}
