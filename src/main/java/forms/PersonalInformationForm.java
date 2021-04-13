package forms;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import entities.User;
import enums.Title;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class PersonalInformationForm extends ElementsContainer {
    @FindBy(xpath = ".//label[normalize-space()='Mr.']")
    private SelenideElement titleMrRadio;

    @FindBy(xpath = ".//label[normalize-space()='Mrs.']")
    private SelenideElement titleMrsRadio;

    @FindBy(id = "customer_firstname")
    private SelenideElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private SelenideElement lastNameInput;

    @FindBy(id = "email")
    private SelenideElement emailInput;

    @FindBy(id = "passwd")
    private SelenideElement passwordInput;

    @FindBy(id = "days")
    private SelenideElement dobDaysDropdown;

    @FindBy(id = "months")
    private SelenideElement dobMonthsDropdown;

    @FindBy(id = "years")
    private SelenideElement dobYearsDropdown;

    public void fill(User user) {
        if (Title.MR == user.getTitle()) {
            titleMrRadio.click();
        } else {
            titleMrsRadio.click();
        }

        firstNameInput.setValue(user.getFirstName());
        lastNameInput.setValue(user.getLastName());
        emailInput.setValue(user.getEmail());
        passwordInput.setValue(user.getPassword());
        fillDateOfBirth(user.getDateOfBirth());
    }

    private void fillDateOfBirth(LocalDate dateOfBirth) {
        int day = dateOfBirth.getDayOfMonth();
        int month = dateOfBirth.getMonthValue();
        int year = dateOfBirth.getYear();

        dobDaysDropdown.selectOptionByValue(String.valueOf(day));
        dobMonthsDropdown.selectOptionByValue(String.valueOf(month));
        dobYearsDropdown.selectOptionByValue(String.valueOf(year));
    }
}