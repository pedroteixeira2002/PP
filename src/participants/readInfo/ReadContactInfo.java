/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package participants.readInfo;

import ma02_resources.participants.Contact;
import participants.ContactImp;

import java.io.IOException;

import static participants.readInfo.Utils.readString;

/**
 * This class reads the contact information
 */
public class ReadContactInfo {
    /**
     * Reads all elements of a contacts
     * @return a new contact
     */
    protected static Contact readContact() {
        System.out.println("----------Contact Information----------");
        String street = readStreet();
        String city = readCity();
        String state = readState();
        String zipCode = readZipCode();
        String country = readCountry();
        String phone = readPhone();
        return new ContactImp(street, city, state, zipCode, phone, country);
    }

    /**
     * This method returns the contact's street.
     *
     * @return The Contact that was read from the keyboard.
     */
    private static String readStreet() {
        String street;
        do {
            try {
                System.out.println("Enter the street's name:\n");
                street = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                street = null;
            }
        } while (street == null);
        return street;
    }

    /**
     * This method returns the contact's city.
     *
     * @return The Contact that was read from the keyboard.
     */
    private static String readCity() {
        String city;
        do {
            try {
                System.out.println("Enter the city's name:\n");
                city = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                city = null;
            }
        } while (city == null);
        return city;
    }

    /**
     * This method returns the contact's state.
     *
     * @return The Contact that was read from the keyboard.
     */
    private static String readState() {
        String state;
        do {
            try {
                System.out.println("Enter the state's name:\n");
                state = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                state = null;
            }
        } while (state == null);
        return state;
    }

    /**
     * This method returns the contact's zip code.
     *
     * @return The Contact that was read from the keyboard.
     */
    private static String readZipCode() {
        String zipCode;
        do {
            try {
                System.out.println("Enter the Zip Code:\n");
                zipCode = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                zipCode = null;
            }
        } while (zipCode == null);
        return zipCode;
    }

    /**
     * This method returns the contact's country.
     *
     * @return The Contact that was read from the keyboard.
     */
    private static String readCountry() {
        String country;
        do {
            try {
                System.out.println("Enter the country's name:\n");
                country = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                country = null;
            }
        } while (country == null);
        return country;
    }

    /**
     * This method returns the contact's phone number.
     *
     * @return The Contact that was read from the keyboard.
     */
    private static String readPhone() {
        String phone;
        do {
            try {
                System.out.println("Enter the Phone number:\n");
                phone = readString();
                if (!phone.matches("[0-9]+")) {
                    System.err.println("Phone number cannot contain letters.");
                    throw new IOException();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
                phone = null;
            }
        } while (phone == null);
        return phone;
    }

}
