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
import ma02_resources.participants.Student;
import participants.StudentImp;

import static participants.readInfo.ReadInstitutionInfo.readInstitution;
import static participants.readInfo.ReadContactInfo.readContact;
import static participants.readInfo.ReadParticipantInfo.readEmail;
import static participants.readInfo.ReadParticipantInfo.readName;
import static participants.readInfo.Utils.readInt;

/**
 * this class is used to read the student information
 */
public class ReadStudentInfo {
    public static Student readStudent() {
        String name = readName();
        String email = readEmail();
        Contact contact = readContact();
        Instituition institution = readInstitution();
        int number = readNumber();

        return new StudentImp(name, email, contact, institution, number);
    }

    /**
     * this method is used to read the number of the student
     * @return the number of the student
     */
    private static int readNumber() {
        int number = 0;
        do {
            try {
                System.out.println("Enter the number of student:\n");
                number = readInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (number < 0);
        return number;
    }
}
