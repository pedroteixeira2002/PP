/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;

/**
 * This class represents a instituition.
 */
public class InstitutionImp implements Instituition {
    private final String name;
    private Contact contact;
    private final String email;
    private InstituitionType type;
    private String description;
    private String website;

    /**
     * This constructor creates a InstituitionImp object with the following parameters.
     *
     * @param name        The name of the instituition.
     * @param contact     The contact of the instituition.
     * @param email       The email of the instituition.
     * @param type        The type of the instituition.
     * @param description The description of the instituition.
     * @param website     The website of the instituition.
     */
    public InstitutionImp(String name, Contact contact, String email, InstituitionType type, String description, String website) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.type = type;
        this.description = description;
        this.website = website;
    }

    /**
     * This method compares two InstituitionImp objects.
     *
     * @param obj The object to be compared.
     * @return True if the objects are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        InstitutionImp that = (InstitutionImp) obj;

        return email.equals(that.email) && name.equals(that.name) && website.equals(that.website);
    }

    /**
     * This method returns the name of the instituition.
     *
     * @return The name of the instituition.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * This method returns the email of the instituition.
     *
     * @return The email of the instituition.
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * This method returns the type of the instituition.
     *
     * @return The type of the instituition.
     */
    @Override
    public InstituitionType getType() {
        return this.type;
    }

    /**
     * This method returns the contact of the instituition.
     *
     * @return The contact of the instituition.
     */
    @Override
    public Contact getContact() {
        return this.contact;
    }

    /**
     * This method returns the website of the instituition.
     *
     * @return The website of the instituition.
     */
    @Override
    public String getWebsite() {
        return this.website;
    }

    /**
     * This method returns the description of the instituition.
     *
     * @return The description of the instituition.
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * This method sets the website of the instituition.
     *
     * @param s The website of the instituition.
     */
    @Override
    public void setWebsite(String s) {
        this.website = s;
    }

    /**
     * This method sets the description of the instituition.
     *
     * @param s The description of the instituition.
     */
    @Override
    public void setDescription(String s) {
        this.description = s;
    }

    /**
     * This method sets the contact of the instituition.
     *
     * @param contact The contact of the instituition.
     */
    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * This method sets the type of the instituition.
     *
     * @param instituitionType The type of the instituition.
     */
    @Override
    public void setType(InstituitionType instituitionType) {
        this.type = instituitionType;
    }

    /**
     * This method returns the string representation of the instituition.
     * @return The string representation of the instituition.
     */
    @Override
    public String toString() {
        return ("\n -------Institution-------" +
                "\n Name: " + name + contact.toString() +
                "\n Email: " + email +
                "\n Type: " + type.toString() +
                "\n Description: " + description +
                "\n Website: " + website) +
                "\n --------------------------";
    }
}
