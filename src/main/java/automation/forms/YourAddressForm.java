package automation.forms;

import automation.entities.Address;
import automation.entities.User;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class YourAddressForm extends ElementsContainer {
    @FindBy(id = "address1")
    private SelenideElement line1Input;

    @FindBy(id = "address2")
    private SelenideElement line2Input;

    @FindBy(id = "city")
    private SelenideElement cityInput;

    @FindBy(id = "id_state")
    private SelenideElement stateDropdown;

    @FindBy(id = "postcode")
    private SelenideElement zipInput;

    @FindBy(id = "id_country")
    private SelenideElement countryDropdown;

    @FindBy(id = "phone_mobile")
    private SelenideElement mobilePhoneInput;

    public void fill(User user) {
        Address address = user.getAddress();
        line1Input.setValue(address.getLine1());
        line2Input.setValue(address.getLine2());
        cityInput.setValue(address.getCity());
        stateDropdown.selectOption(address.getState());
        zipInput.setValue(address.getZip());
        countryDropdown.selectOption(address.getCountry());
        mobilePhoneInput.setValue(user.getMobilePhone());
    }
}
