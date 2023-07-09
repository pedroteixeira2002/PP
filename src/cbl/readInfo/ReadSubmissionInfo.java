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

import cbl.SubmissionImp;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Submission;
import participants.ParticipantImp;

import java.time.LocalDateTime;

import static participants.readInfo.ReadStudentInfo.readStudent;
import static participants.readInfo.Utils.readLocalDateTime;
import static participants.readInfo.Utils.readString;

/**
 *  class responsible for reading the information of a submission
 */
public class ReadSubmissionInfo {

    /**
     * method responsible for reading the information of a submission
     * @return Submission
     */
    public static Submission readSubmission() {
        LocalDateTime date = readLocalDateTime();
        String text = readText();
        Student student = readStudent();

        return new SubmissionImp(date, student, text);
    }

    /**
     * method responsible for reading the text of a submission
     * @return text
     */
    private static String readText() {
        String text = null;
        do {
            try {
                System.out.println("Enter the text:\n");
                text = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (text == null);
        return text;
    }
}
