package forms;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import entities.User;
import org.openqa.selenium.support.FindBy;

public class CreateAccountForm extends ElementsContainer {
    @FindBy(xpath = ".//h3[text()='Your personal information']/ancestor::div[1]")
    private PersonalInformationForm personalInformationForm;

    @FindBy(xpath = ".//h3[text()='Your address']/ancestor::div[1]")
    private YourAddressForm yourAddressForm;

    @FindBy(id = "submitAccount")
    private SelenideElement registerButton;

    public void fillPersonalInformation(User user) {
        personalInformationForm.fill(user);
    }

    public void fillYourAddress(User user) {
        yourAddressForm.fill(user);
    }

    public void register() {
        registerButton.click();
    }
}