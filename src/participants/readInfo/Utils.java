package participants.readInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Utils {
    /**
     * This method returns a string that is read from the keyboard.
     *
     * @return The string that was read from the keyboard.
     * @throws IOException If the string is null, empty or blank.
     */
    public static String readString() throws IOException {
        String string;
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();
        if (string == null || string.isEmpty() || string.isBlank()) {
            throw new IOException("String can't be Null, Empty or Blank");
        }
        return string;
    }

    /**
     * This method returns an integer that is read from the keyboard.
     *
     * @return The integer that was read from the keyboard.
     */
    public static int readInt() {
        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        return num;
    }

    /**
     * This method returns a LocalDate that is read from the keyboard.
     *
     * @return The LocalDate that was read from the keyboard.
     */
    public static LocalDate readLocalDate() {
        LocalDate date = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            date = LocalDate.parse(input);
        } catch (Exception e) {
            System.err.println("Invalid date format. Please enter a date in the format YYYY-MM-DD.");
        }
        return date;
    }

    /**
     * This method returns a LocalDate that is read from the keyboard.
     *
     * @return The LocalDate that was read from the keyboard.
     */
    public static LocalDateTime readLocalDateTime() {
        LocalDateTime date = LocalDateTime.now();

        return date;
    }
}
