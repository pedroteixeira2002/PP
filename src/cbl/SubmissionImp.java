/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package cbl;

import ma02_resources.participants.Student;
import ma02_resources.project.Submission;

import java.time.LocalDateTime;

/**
 * this class represents a submission.
 */
public class SubmissionImp implements Submission {
    private LocalDateTime date;
    private Student student;
    private String text;

    /**
     * constructor of the class
     * @param date the date of the submission
     * @param student the student that made the submission
     * @param text the text of the submission
     */
    public SubmissionImp(LocalDateTime date, Student student, String text) {
        this.date = date;
        this.student = student;
        this.text = text;
    }

    /**
     * this method returns the date of the submission.
     * @return date of the submission
     */
    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    /**
     * this method returns the student that made the submission.
     * @return student that made the submission
     */
    @Override
    public Student getStudent() {
        return this.student;
    }

    /**
     * this method returns the text of the submission.
     * @return text of the submission
     */
    @Override
    public String getText() {
        return this.text;
    }

    /**
     * this method compares two submissions.
     * @param submission the object to be compared.
     * @return 0 if the objects are equal, 1 if the object is greater than the argument and -1 if the object is less than the argument.
     */
    @Override
    public int compareTo(Submission submission) {
        return this.date.compareTo(submission.getDate());
    }

    @Override
    public String toString() {
        return  "\n--------Submission--------" +
                "\n Date: " + date +
                "\n Student: " + student.getName() +
                "\n Text: " + text +
                "\n--------------------------";
    }
}
