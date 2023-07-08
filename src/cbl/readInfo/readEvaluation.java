package cbl.readInfo;

import static participants.readInfo.Utils.readString;

public class readEvaluation {






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
