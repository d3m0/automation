package automation.forms.women;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class CatalogBlock extends ElementsContainer {
    @FindBy(xpath = ".//*[@class='title_block']")
    private SelenideElement catalogBlock;
}
