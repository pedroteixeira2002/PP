package cbl;

import Interfaces.Evaluation;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;
import participants.readInfo.Utils;

import java.io.IOException;
import java.util.Arrays;

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

    public static EvaluationImp readEvaluationInfo(Project project) throws IOException {
        double[] peerGrades;

        System.out.println("Enter your email: ");
        String email = Utils.readString();
        Participant participant = project.getParticipant(email);

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
    public static double selfEvaluation(Project project) throws IOException {

        for (Participant p : ((ProjectImp) project).getParticipants()) {
            if (p == null)
                break;

            System.out.println("Enter the self evaluation: ");
            double grade = readDouble();
            return grade;
        }
        throw new IOException("Only students can evaluate themselves");
    }

    /**
     * This method allows a student to evaluate a teammate
     *
     * @param project the project to evaluate
     * @throws IOException if an error occurs while reading the participant
     */
    public static double[] peerEvaluation(Project project) throws IOException {
        double[] tempGrades = new double[TEAM_SIZE];

        for (int i = 0; i < tempGrades.length; i++) {
            System.out.println("Student" + (i + 1) + ": Enter the classification: ");
            tempGrades[i] = readDouble();
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

    @Override
    public String toString() {
        return "\n--------- Evaluation ------------" +
                "\n SelfGrade=" + selfGrade +
                "\n PeerGrades=" + Arrays.toString(peerGrades) +
                "\n Student=" + student.getName() +
                "\n Email='" + email  +
                "\n Project=" + project.getName() +
                "\n FinalEvaluation=" + finalEvaluation;
    }
}
