package pages;

import forms.TopMenu;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Verify;

@Verify(title = "My Store")
public class IndexPage {
    public static final Logger LOGGER = LoggerFactory.getLogger(IndexPage.class);
    @FindBy(xpath = "//div[@id='block_top_menu']")
    private TopMenu topMenu;

    public void verifyTopMenu() {
        LOGGER.trace("Verifying Top Menu block");
        topMenu.verifyLinkArePresent();
    }
}
