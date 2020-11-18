package entities.browser;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface Browser {
    String getType();

    String getVersion();

    DesiredCapabilities getCapabilities();

    default String getResolution() {
        return StringUtils.defaultIfEmpty(System.getProperty("browser.resolution"), "1920x1080");
    }
}
