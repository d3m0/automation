package automation.builders;

import automation.entities.Address;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddressBuilder {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public AddressBuilder() {
        Faker faker = new Faker(new Locale("en", "US"));
        this.line1 = faker.address().streetAddress();
        this.line2 = faker.address().secondaryAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        String stateAbbreviation = getStateAbbreviation(state);
        this.zip = faker.address().zipCodeByState(stateAbbreviation);
        this.country = "United States";
    }

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

    public Address build() {
        return new Address(this);
    }

    private String getStateAbbreviation(String state) {
        Map<String, String> states = new HashMap<>();
        states.put("Alabama", "AL");
        states.put("Alaska", "AK");
        states.put("Alberta", "AB");
        states.put("American Samoa", "AS");
        states.put("Arizona", "AZ");
        states.put("Arkansas", "AR");
        states.put("Armed Forces (AE)", "AE");
        states.put("Armed Forces Americas", "AA");
        states.put("Armed Forces Pacific", "AP");
        states.put("British Columbia", "BC");
        states.put("California", "CA");
        states.put("Colorado", "CO");
        states.put("Connecticut", "CT");
        states.put("Delaware", "DE");
        states.put("District Of Columbia", "DC");
        states.put("Florida", "FL");
        states.put("Georgia", "GA");
        states.put("Guam", "GU");
        states.put("Hawaii", "HI");
        states.put("Idaho", "ID");
        states.put("Illinois", "IL");
        states.put("Indiana", "IN");
        states.put("Iowa", "IA");
        states.put("Kansas", "KS");
        states.put("Kentucky", "KY");
        states.put("Louisiana", "LA");
        states.put("Maine", "ME");
        states.put("Manitoba", "MB");
        states.put("Maryland", "MD");
        states.put("Massachusetts", "MA");
        states.put("Michigan", "MI");
        states.put("Minnesota", "MN");
        states.put("Mississippi", "MS");
        states.put("Missouri", "MO");
        states.put("Montana", "MT");
        states.put("Nebraska", "NE");
        states.put("Nevada", "NV");
        states.put("New Brunswick", "NB");
        states.put("New Hampshire", "NH");
        states.put("New Jersey", "NJ");
        states.put("New Mexico", "NM");
        states.put("New York", "NY");
        states.put("Newfoundland", "NF");
        states.put("North Carolina", "NC");
        states.put("North Dakota", "ND");
        states.put("Northwest Territories", "NT");
        states.put("Nova Scotia", "NS");
        states.put("Nunavut", "NU");
        states.put("Ohio", "OH");
        states.put("Oklahoma", "OK");
        states.put("Ontario", "ON");
        states.put("Oregon", "OR");
        states.put("Pennsylvania", "PA");
        states.put("Prince Edward Island", "PE");
        states.put("Puerto Rico", "PR");
        states.put("Quebec", "QC");
        states.put("Rhode Island", "RI");
        states.put("Saskatchewan", "SK");
        states.put("South Carolina", "SC");
        states.put("South Dakota", "SD");
        states.put("Tennessee", "TN");
        states.put("Texas", "TX");
        states.put("Utah", "UT");
        states.put("Vermont", "VT");
        states.put("Virgin Islands", "VI");
        states.put("Virginia", "VA");
        states.put("Washington", "WA");
        states.put("West Virginia", "WV");
        states.put("Wisconsin", "WI");
        states.put("Wyoming", "WY");
        states.put("Yukon Territory", "YT");

        return states.get(state);
    }
}