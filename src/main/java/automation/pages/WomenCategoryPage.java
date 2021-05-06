package automation.pages;

import automation.forms.women.CatalogBlock;
import automation.forms.women.CategoriesBlock;
import automation.forms.women.InformationBlock;
import automation.utils.Verify;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

@Slf4j
@Verify(title = "Women - My Store")
public class WomenCategoryPage {
    @FindBy(id = "categories_block_left")
    private CategoriesBlock categoriesBlock;

    @FindBy(id = "layered_block_left")
    public CatalogBlock catalogBlock;

    @FindBy(id = "informations_block_left_1")
    public InformationBlock informationBlock;

    public WomenCategoryPage verifyBlocksPresent() {
        log.info("Verifying blocks are present on a page");
        categoriesBlock.getSelf().shouldBe(visible);
        catalogBlock.getSelf().shouldBe(visible);
        informationBlock.getSelf().shouldBe(visible);
        return this;
    }
}
