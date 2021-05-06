package automation.entities.browser;

import com.codeborne.selenide.Browsers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

@Slf4j
public class ChromeBrowser implements Browser {
    @Override
    public String getType() {
        return Browsers.CHROME;
    }

    @Override
    public String getVersion() {
        return StringUtils.defaultIfEmpty(System.getProperty("browser.version"), "88.0");
    }

    @Override
    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}
