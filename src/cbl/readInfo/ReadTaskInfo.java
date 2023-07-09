/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */


package cbl.readInfo;

import cbl.TaskImp;
import ma02_resources.project.Task;

import java.time.LocalDate;

import static participants.readInfo.Utils.*;

/**
 * This class is responsible for reading the information of a task.
 */
public class ReadTaskInfo {

    /**
     * This method reads the information of a task.
     *
     * @return The task that was read from the keyboard.
     */
    public static Task readTask() {
        String title = readTitle();
        String description = readDescription();
        System.out.println("Enter the start date:\n");
        LocalDate startDate = readLocalDate();

        int duration = readDuration();

        LocalDate endDate = startDate.plusDays(duration);

        return new TaskImp(title, description, startDate, endDate, duration);
    }


    /**
     * This method returns the task duration.
     *
     * @return The task duration that was read from the keyboard.
     */
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
                System.out.println("Enter the description:\n");
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
