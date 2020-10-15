package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Verify;

import static java.lang.invoke.MethodHandles.lookup;

@Verify(title = "My account - My Store")
public class MyAccountPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());
}
