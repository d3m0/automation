package pages;

import forms.women.CatalogBlock;
import forms.women.CategoriesBlock;
import forms.women.InformationBlock;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Verify;

import static com.codeborne.selenide.Condition.visible;
import static java.lang.invoke.MethodHandles.lookup;

@Verify(title = "Women - My Store")
public class WomenCategoryPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());

    @FindBy(id = "categories_block_left")
    private CategoriesBlock categoriesBlock;

    @FindBy(id = "layered_block_left")
    public CatalogBlock catalogBlock;

    @FindBy(id = "informations_block_left_1")
    public InformationBlock informationBlock;

    public WomenCategoryPage verifyBlocksPresent() {
        LOGGER.trace("Verifying blocks are present on a page");
        categoriesBlock.getSelf().shouldBe(visible);
        catalogBlock.getSelf().shouldBe(visible);
        informationBlock.getSelf().shouldBe(visible);
        return this;
    }
}
