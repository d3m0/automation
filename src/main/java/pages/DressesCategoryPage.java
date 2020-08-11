package pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Verify;

@Verify(title = "Dresses - My Store")
public class DressesCategoryPage {
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexPage.class.getSimpleName());
    private final WebDriver webDriver;

    private DressesCategoryPage() {
        webDriver = WebDriverRunner.getWebDriver();
    }
}
