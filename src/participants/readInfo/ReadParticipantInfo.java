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

import static participants.readInfo.Utils.readString;

/**
 * This class is used to read the participant information from the keyboard.
 */
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
    public static String readEmail() {
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
