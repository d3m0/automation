package builders;

import com.github.javafaker.Faker;
import entities.Address;

import java.util.Locale;

public class AddressBuilder {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public String getLine1() {
        return line1;
    }

    public AddressBuilder setLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public String getLine2() {
        return line2;
    }

    public AddressBuilder setLine2(String line2) {
        this.line2 = line2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public AddressBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public AddressBuilder setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public AddressBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder() {
        Faker faker = new Faker(new Locale("en-US"));
        this.line1 = faker.address().streetAddress();
        this.line2 = faker.address().secondaryAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.zip = faker.address().zipCode();
        this.country = faker.address().country();
    }

    public Address build() {
        return new Address(this);
    }
}