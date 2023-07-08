package cbl;

import Interfaces.Evaluation;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;
import participants.readInfo.Utils;

import java.io.IOException;

public class EvaluationImp implements Evaluation {
    private static final int TEAM_SIZE = 4;
    private double selfGrade;
    private double[] peerGrades;
    private Participant student;
    private String email;
    private Project project;

    public EvaluationImp(double selfGrade, Participant student, Project project) {
        this.selfGrade = selfGrade;
        this.peerGrades = new double[TEAM_SIZE];
        this.email = student.getEmail();
        this.student = student;
        this.project = project;
    }

    public void setSelfGrade(double selfGrade) {
        this.selfGrade = selfGrade;
    }

    public void setPeerGrades(double[] peerGrades) {
        this.peerGrades = peerGrades;
    }

    public double getSelfGrade() {
        return selfGrade;
    }

    public double[] getPeerGrades() {
        return peerGrades;
    }

    public Participant getStudent() {
        return student;
    }

    public Project getProject() {
        return project;
    }

    /**
     * this method allows the student to evaluate himself
     *
     * @param project the project to evaluate
     * @throws IOException
     */
    public void selfEvaluation(Project project) throws IOException {

        System.out.println("Enter your email: ");
        String email = Utils.readString();
        Participant participant = project.getParticipant(email);

        if (participant instanceof Student) {
            for (Participant p : ((ProjectImp) project).getParticipants()) {
                if (p == null)
                    break;
                if (p instanceof Student && p.getEmail().equals(email)) {
                    System.out.println("Enter your self evaluation: ");
                    double grade = Utils.readDouble();
                    setSelfGrade(grade);
                }
            }
        } else
            System.out.println("Only students can evaluate themselves");
    }

    /**
     * This method allows a student to evaluate a teammate
     *
     * @param project the project to evaluate
     * @throws IOException if an error occurs while reading the participant
     */
    public void peerEvaluation(Project project) throws IOException {

        System.out.println("Enter your email: ");
        String email = Utils.readString();
        Participant participant = project.getParticipant(email);

        System.out.println("Enter the email of your team mate: ");
        String emailTeam = Utils.readString();
        Participant participantToEvaluate = project.getParticipant(email);


        if (participant instanceof Student && participantToEvaluate instanceof Student) {
            for (Participant p : ((ProjectImp) project).getParticipants()) {

                if (p instanceof Student && p.getEmail().equals(emailTeam)) {
                    System.out.println("Enter the grade for " + p.getName() + ": ");
                    double grade = Utils.readDouble();
                    setPeerGrades(new double[]{grade});
                }
            }
        }
    }

    public double calculateFinalEvaluation() {
        double sumGrades = selfGrade;

        for (double grade : peerGrades) {
            sumGrades += grade;
        }

        return sumGrades / (peerGrades.length + 1); // Adding 1 to account for the self-grade
    }
}
