package builders;

import com.github.javafaker.Faker;
import entities.Address;
import entities.User;
import enums.Title;

import java.util.Date;

public class UserBuilder {
    private Title title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;
    private Address address;
    private String mobilePhone;

    public UserBuilder() {
        Faker faker = new Faker();
        this.title = (faker.name().prefix().length() > 3) ? Title.MRS : Title.MR;
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password();
        this.dateOfBirth = faker.date().birthday();
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public UserBuilder setDateOfBirth(Date dateOfBirth) {
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