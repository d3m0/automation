package entities;

import builders.UserBuilder;
import enums.Title;

import java.util.Date;

public class User {
    private final Title title;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final Date dateOfBirth;
    private final Address address;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public User(UserBuilder builder) {
        this.title = builder.getTitle();
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.email = builder.getEmail();
        this.password = builder.getPassword();
        this.dateOfBirth = builder.getDateOfBirth();
        this.address = builder.getAddress();
    }
}