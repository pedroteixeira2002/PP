package participants.readInfo;

import static participants.readInfo.Utils.readString;

public class ReadParticipantInfo {
    /**
     * This method returns the participant name.
     *
     * @return The participant name that was read from the keyboard.
     */
    protected static String readName() {
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
     * This method returns the participant email.
     *
     * @return The participant email that was read from the keyboard.
     */
    protected static String readEmail() {
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

}
