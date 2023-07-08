package cbl;

import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;
import participants.readInfo.Utils;

import java.io.IOException;
import java.util.Scanner;

public class EvaluationImp implements Evaluation {
    private static final int TEAM_SIZE = 4;
    private double selfGrade;
    private double[] peerGrades;
    private Participant student;
    private Project project;

    public EvaluationImp(double selfGrade, double[] peerGrades, Participant student, Project project) {
        this.selfGrade = selfGrade;
        this.peerGrades = new double[TEAM_SIZE];
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

    public void selfEvaluation(Project project) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        Participant participant = project.getParticipant(email);

        if (participant instanceof Student) {
            for (Participant p : project.getParticipants()) {
                if (p instanceof Student) {
                    System.out.println("Enter the grade for " + p.getName() + ": ");
                    double grade = Utils.readDouble();
                    setSelfGrade(grade);
                }
            }
        }
    }

    public void peerEvaluation(Project project) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String email = scanner.nextLine();

        Participant participant = project.getParticipant(email);

        System.out.println("Enter the student you want to evaluate: ");
        String studentName = scanner.nextLine();

        if (participant instanceof Student) {
            for (Participant p : project.getParticipants()) {
                if (p instanceof Student && p.getName().equals(studentName)) {
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
