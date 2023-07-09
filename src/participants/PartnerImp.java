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
import ma02_resources.participants.Partner;

/**
 * This class represents a partner.
 */
public class PartnerImp extends ParticipantImp implements Partner {
    private final String website;
    private final String vat;

    /**
     * Constructor of the class PartnerImp
     * @param name of the partner
     * @param email of the partner
     * @param contact of the partner
     * @param instituition of the partner
     * @param website of the partner
     * @param vat of the partner
     */
    public PartnerImp(String name, String email, Contact contact, Instituition instituition, String website, String vat) {
        super(name, email, contact, instituition);
        this.website = website;
        this.vat = vat;
    }

    /**
     * this method returns the vat of the partner.
     * @return vat number of the partner
     */
    @Override
    public String getVat() {return this.vat;
    }

    /**
     * this method returns the website of the partner.
     * @return website of the partner
     */
    @Override
    public String getWebsite() {
        return this.website;
    }

    /**
     * this method returns the name of the partner.
     * @return name of the partner
     */
    @Override
    public String getName() {return super.getName();
    }

    /**
     * this method returns the email of the partner.
     * @return email of the partner
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * this method returns the contact of the partner.
     * @return contact of the partner
     */
    @Override
    public Contact getContact() {return super.getContact();
    }

    /**
     * this method returns the instituition of the partner.
     * @return instituition of the partner
     */
    @Override
    public Instituition getInstituition() {
        return super.getInstituition();
    }

    /**
     * this method sets the instituition of the partner.
     * @param instituition of the partner to be set
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * this method sets the contact of the partner.
     * @param contact of the partner to be set
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);

    }

    /**
     * this method returns the information of the partner.
     * @return information of the partner
     */
    @Override
    public String toString() {
        return ("\n " + super.toString() +
                "\n -------Partner-------" +
                "\n Website: " + website +
                "\n Vat: " + vat);
    }
}
