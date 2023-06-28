package participants;

import ma02_resources.participants.Contact;

public class ContactImp implements Contact {
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phone;
    private final String country;

    /**
     * Constructor of ContactImp
     * @param street the street of the contact
     * @param city the city of the contact
     * @param state the state of the contact
     * @param zipCode the zipCode of the contact
     * @param phone the phone of the contact
     * @param country the country of the contact
     */
    public ContactImp(String street, String city, String state, String zipCode, String phone, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phone = phone;
        this.country = country;
    }

    /**
     * this method returns the street of the contact.
     * @return street of the contact
     */
    @Override
    public String getStreet() {return this.street;
    }

    /**
     * this method returns the city of the contact.
     * @return city of the contact
     */
    @Override
    public String getCity() {
        return this.city;
    }

    /**
     * this method returns the state of the contact.
     * @return state of the contact
     */
    @Override
    public String getState() {
        return this.state;
    }

    /**
     * this method returns the zipCode of the contact.
     * @return zipCode of the contact
     */
    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * this method returns the country of the contact.
     * @return country of the contact
     */
    @Override
    public String getCountry() {
        return this.country;
    }

    /**
     * this method returns the phone of the contact.
     * @return phone of the contact
     */
    @Override
    public String getPhone() {
        return this.phone;
    }

    /**
     * this method returns the string representation of the contact.
     * @return string representation of the contact
     */
    @Override
    public String toString() {
        return ("\n -------Contact-------" +
                "\n Phone: " + phone +
                "\n Street: " + street +
                "\n Zip Code: " + zipCode +
                "\n City: " + city +
                "\n State: " + state +
                "\n Country: " + country +
                "\n -----------------------");
    }
}
