package participants.readInfo;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Instituition;
import participants.FacilitatorImp;

import static participants.readInfo.ReadInstitutionInfo.readInstitution;
import static participants.readInfo.ReadContactInfo.readContact;
import static participants.readInfo.ReadParticipantInfo.readEmail;
import static participants.readInfo.ReadParticipantInfo.readName;
import static participants.readInfo.Utils.readString;

public class ReadFacilitatorInfo {
    /**
     * This method reads the facilitator's information.
     *
     * @return the facilitator's information
     */
    public static Facilitator readFacilitator() {
        String name = readName();
        String email = readEmail();
        Contact contact = readContact();
        Instituition instituition = readInstitution();
        String areaOfExpertise = readAreaOfExpertise();
        return new FacilitatorImp(name, email, contact, instituition, areaOfExpertise);
    }

    /**
     * This method returns the facilitator's area of expertise.
     *
     * @return The facilitator's name that was read from the keyboard.
     */
    private static String readAreaOfExpertise() {
        String areaOfExpertise;
        do {
            try {
                System.out.println("Enter the area of expertise:\n");
                areaOfExpertise = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                areaOfExpertise = null;
            }
        } while (areaOfExpertise == null);
        return areaOfExpertise;
    }
}
