package automation.entities;

import automation.builders.UserBuilder;
import automation.enums.Title;

import java.time.LocalDate;

public class User {
    private final Title title;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final LocalDate dateOfBirth;
    private final Address address;
    private final String mobilePhone;

    public User(UserBuilder builder) {
        this.title = builder.getTitle();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.email = builder.getEmail();
        this.password = builder.getPassword();
        this.dateOfBirth = builder.getDateOfBirth();
        this.address = builder.getAddress();
        this.mobilePhone = builder.getMobilePhone();
    }

    public Title getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "title=" + title +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}