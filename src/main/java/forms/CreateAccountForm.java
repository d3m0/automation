package forms;

import com.codeborne.selenide.ElementsContainer;
import entities.User;
import org.openqa.selenium.support.FindBy;

public class CreateAccountForm extends ElementsContainer {
    @FindBy(xpath = ".//h3[text()='Your personal information']/ancestor::div[1]")
    private PersonalInformationForm personalInformationForm;

    @FindBy(xpath = "//h3[text()='Your address']/ancestor::div[1]")
    private YourAddressForm yourAddressForm;

    public void fillPersonalInformation(User user) {
        personalInformationForm.fill(user);
    }

    public void fillYourAddress(User user) {
        yourAddressForm.fill(user);
    }
}