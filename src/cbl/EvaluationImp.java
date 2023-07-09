package cbl;

import Interfaces.Evaluation;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;
import participants.readInfo.Utils;

import java.io.IOException;

import static participants.readInfo.ReadParticipantInfo.readEmail;
import static participants.readInfo.Utils.readDouble;

public class EvaluationImp implements Evaluation {
    private static final int TEAM_SIZE = 4;
    private double selfGrade;
    private double[] peerGrades;
    private Participant student;
    private String email;
    private Project project;
    private double finalEvaluation;

    public EvaluationImp(double selfGrade, double[] peerGrades, Project project, String email) {
        this.selfGrade = selfGrade;
        this.peerGrades = peerGrades;
        this.student = project.getParticipant(email);
        this.email = email;
        this.project = project;
        this.finalEvaluation = calculateFinalEvaluation();
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

    public EvaluationImp readEvaluationInfo(Project project) throws IOException {
        double[] peerGrades;
        String email = readEmail();
        double selfGrade = selfEvaluation(project);
        peerGrades = peerEvaluation(project);

        return new EvaluationImp(selfGrade, peerGrades, project, email);
    }


    /**
     * this method allows the student to evaluate himself
     *
     * @param project the project to evaluate
     * @throws IOException
     */
    public double selfEvaluation(Project project) throws IOException {
        System.out.println("Enter your email: ");
        String email = Utils.readString();
        Participant participant = project.getParticipant(email);

        if (participant instanceof Student) {
            for (Participant p : ((ProjectImp) project).getParticipants()) {
                if (p == null)
                    break;
                if (p instanceof Student && p.getEmail().equals(email)) {
                    System.out.println("Enter your self evaluation: ");
                    double grade = readDouble();
                    return grade;
                }
            }
        }
        throw new IOException("Only students can evaluate themselves");
    }

    /**
     * This method allows a student to evaluate a teammate
     *
     * @param project the project to evaluate
     * @throws IOException if an error occurs while reading the participant
     */
    public double[] peerEvaluation(Project project) throws IOException {
        double[] tempGrades = new double[TEAM_SIZE];
        System.out.println("Enter your email: ");
        String email = Utils.readString();
        Participant participant = project.getParticipant(email);

        System.out.println("Enter the email of your team mate: ");
        String emailTeam = Utils.readString();
        Participant participantToEvaluate = project.getParticipant(emailTeam);

        if (participant instanceof Student && participantToEvaluate instanceof Student) {
            for (int i = 0; i < tempGrades.length; i++) {
                System.out.println("Student" + (i + 1) + ": Enter the classification: ");
                tempGrades[i] = readDouble();
            }
        }
        return tempGrades;
    }

    public double calculateFinalEvaluation() {
        double finalEvaluation = 0;
        double sumGrades = selfGrade;

        for (double grade : peerGrades) {
            sumGrades += grade;
        }
        finalEvaluation = sumGrades / (peerGrades.length + 1);

        return finalEvaluation; // Adding 1 to account for the self-grade
    }
}
