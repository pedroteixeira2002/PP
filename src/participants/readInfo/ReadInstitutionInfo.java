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
import ma02_resources.participants.InstituitionType;
import participants.InstitutionImp;

import java.util.Scanner;

import static participants.readInfo.ReadContactInfo.readContact;
import static participants.readInfo.Utils.readString;

public class ReadInstitutionInfo {
    protected static Instituition readInstitution() {
        System.out.println("---------Institution Information---------");
        String name = readName();
        String email = readEmail();
        Contact contact = readContact();
        InstituitionType type = readInstitutionType();
        String description = readDescription();
        String website = readWebsite();
        return new InstitutionImp(name, contact, email, type, description, website);
    }

    /**
     * This method returns the institution's name.
     *
     * @return The instution name that was read from the keyboard.
     */
    private static String readName() {
        String name;
        do {
            try {
                System.out.println("Enter the name:\n");
                name = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                name = null;
            }
        } while (name == null);
        return name;
    }

    /**
     * this method reads the email from the keyboard about the institution.
     * @return The institution email that was read from the keyboard.
     */
    private static String readEmail() {
        String email;
        do {
            try {
                System.out.println("Enter the email:\n");
                email = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                email = null;
            }
        } while (email == null);
        return email;
    }

    /**
     * This method returns the institution's description.
     * @return The institution description that was read from the keyboard.
     */
    private static String readDescription() {
        String description;
        do {
            try {
                System.out.println("Enter the description:\n");
                description = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                description = null;
            }
        } while (description == null);
        return description;
    }

    /**
     * This method returns the institution's website.
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
     * This method returns the institution's type.
     * @return The institution type that was read from the keyboard.
     */
    private static InstituitionType readInstitutionType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the institution type:\n" +
                "1 - NGO\n" +
                "2 - Company\n" +
                "3 - University\n" +
                "4 - Other\n");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                return InstituitionType.NGO;
            case 2:
                return InstituitionType.COMPANY;
            case 3:
                return InstituitionType.UNIVERSITY;
            case 4:
                return InstituitionType.OTHER;
            default:
                return null;
        }
    }
}
