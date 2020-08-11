package utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadingPageFactory {
    public static <T> T get(WebDriver driver, Class<T> pageObjectClass) {
        String simpleName = pageObjectClass.getSimpleName();
        Logger logger = LoggerFactory.getLogger(simpleName);
        logger.trace("Initializing page");
        Verify verify = pageObjectClass.getAnnotation(Verify.class);

        String expectedPageTitle;
        try {
            expectedPageTitle = verify.title();
        } catch (NullPointerException exception) {
            throw new ElementNotVisibleException(String.format("Please use @Verify annotation for %s page", simpleName));
        }

        if (!expectedPageTitle.equals(Verify.INVALID_TITLE)) {
            String actualPageTitle = driver.getTitle();
            if (!expectedPageTitle.equals(actualPageTitle)) {
                throw new IllegalStateException(String.format("Expected page title '%s' but was '%s'", expectedPageTitle, actualPageTitle));
            }
        }

        String xpath = verify.xpath();
        if (!xpath.equals(Verify.INVALID_XPATH)) {
            if (driver.findElements(By.xpath(xpath)).isEmpty()) {
                throw new IllegalStateException(String.format("expected XPath %s", xpath));
            }
        }

        return Selenide.page(pageObjectClass);
    }
}