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

public class ReadSubmissionInfo {
    public static Submission readSubmission() {
        LocalDateTime date = readLocalDateTime();
        String text = readText();
        Student student = readStudent();

        return new SubmissionImp(date, student, text);
    }

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
