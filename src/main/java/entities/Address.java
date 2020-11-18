package entities;

import builders.AddressBuilder;

public class Address {
    private final String line1;
    private final String line2;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;

    public Address(AddressBuilder addressBuilder) {
        this.line1 = addressBuilder.getLine1();
        this.line2 = addressBuilder.getLine2();
        this.city = addressBuilder.getCity();
        this.state = addressBuilder.getState();
        this.zip = addressBuilder.getZip();
        this.country = addressBuilder.getCountry();
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}