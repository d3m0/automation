package automation.builders;

import automation.entities.Address;
import automation.entities.User;
import automation.enums.Title;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;

public class UserBuilder {
    private Title title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private Address address;
    private String mobilePhone;

    public UserBuilder() {
        Faker faker = new Faker();
        this.title = (faker.name().prefix().length() > 3) ? Title.MRS : Title.MR;
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password();
        this.dateOfBirth = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.address = new AddressBuilder().build();
        this.mobilePhone = faker.phoneNumber().cellPhone();
    }

    public Title getTitle() {
        return title;
    }

    public UserBuilder setTitle(Title title) {
        this.title = title;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public UserBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public UserBuilder setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public User build() {
        return new User(this);
    }
}