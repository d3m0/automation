package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Verify;

import static java.lang.invoke.MethodHandles.lookup;

@Verify(title = "T-shirts - My Store")
public class TShirtsCategoryPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());
}
