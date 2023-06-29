package cbl.readInfo;

import cbl.TaskImp;
import ma02_resources.project.Task;

import java.time.LocalDate;

import static participants.readInfo.Utils.*;

public class ReadTaskInfo {
    public static Task readTask() {
        String title = readTitle();
        String description = readDescription();

        LocalDate startDate = readLocalDate();

        int duration = readDuration();

        LocalDate endDate = startDate.plusDays(duration);


        return new TaskImp(title, description, startDate, endDate, duration);
    }

    private static int readExtendedDeadline() {
        int extendedDeadline = 0;
        do {
            try {
                System.out.println("For how many days you want to extend deadline:\n");
                extendedDeadline = readInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (extendedDeadline == 0);
        return extendedDeadline;
    }

    private static int readDuration() {
        int duration = 0;
        do {
            try {
                System.out.println("Enter the duration:\n");
                duration = readInt();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (duration == 0);
        return duration;
    }


    /**
     * This method returns the task description.
     *
     * @return The task description that was read from the keyboard.
     */
    private static String readDescription() {
        String description = null;
        do {
            try {
                System.out.println("Enter the title:\n");
                description = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (description == null);
        return description;
    }

    /**
     * This method returns the task title.
     *
     * @return The task title that was read from the keyboard.
     */
    private static String readTitle() {
        String title = null;
        do {
            try {
                System.out.println("Enter the title:\n");
                title = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (title == null);
        return title;
    }
}
