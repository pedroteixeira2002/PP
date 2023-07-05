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

public class ReadStudentInfo {
    public static Student readStudent() {
        String name = readName();
        String email = readEmail();
        Contact contact = readContact();
        Instituition institution = readInstitution();
        int number = readNumber();

        return new StudentImp(name, email, contact, institution, number);
    }

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
