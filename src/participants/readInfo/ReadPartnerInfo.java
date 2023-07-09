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
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Partner;
import participants.PartnerImp;

import static participants.readInfo.ReadInstitutionInfo.readInstitution;
import static participants.readInfo.ReadContactInfo.readContact;
import static participants.readInfo.ReadParticipantInfo.readEmail;
import static participants.readInfo.ReadParticipantInfo.readName;
import static participants.readInfo.Utils.readString;

/**
 * This class is used to read the partner information from the keyboard.
 */
public class ReadPartnerInfo {
    /**
     * This method reads the information of a partner.
     *
     * @return The partner that was read from the keyboard.
     */
    public static Partner readPartner() {
        String name = readName();
        String email = readEmail();
        Contact contact = readContact();
        Instituition instituition = readInstitution();
        String website = readWebsite();
        String vat = readVat();
        return new PartnerImp(name, email, contact, instituition, website, vat);

    }

    /**
     * This method returns the institution's website.
     *
     * @return The institution website that was read from the keyboard.
     */
    private static String readWebsite() {
        String website;
        do {
            try {
                System.out.println("Enter the website:\n");
                website = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                website = null;
            }
        } while (website == null);
        return website;
    }

    /**
     * This method returns the institution's vat.
     *
     * @return The institution vat that was read from the keyboard.
     */
    private static String readVat() {
        String vat;
        do {
            try {
                System.out.println("Enter the vat:\n");
                vat = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                vat = null;
            }
        } while (vat == null);
        return vat;
    }
}
