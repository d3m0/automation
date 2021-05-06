package automation.entities.browser;

import automation.utils.PropertiesReader;
import com.codeborne.selenide.Browsers;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class FirefoxBrowser implements Browser {
    @Override
    public String getType() {
        return Browsers.FIREFOX;
    }

    @Override
    public String getVersion() {
        Map<String, String> properties = PropertiesReader.getProperties();
        String firefoxVersion = properties.get("firefox.version");

        return StringUtils.defaultString(firefoxVersion, "87.0");
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}