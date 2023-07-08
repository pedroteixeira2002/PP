package cbl;


import Interfaces.Evaluation;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;

import cbl.ProjectImp;
import participants.readInfo.Utils;

import java.io.IOException;

import static participants.readInfo.Utils.readString;


public abstract class EvaluationImp implements Evaluation {
    private static final int TEAM = 4;
    private double selfGrade;
    private double[] peerGrade;
    private Participant student;
    private Project project;

    public EvaluationImp(double selfGrade, double[] peerGrade, Participant student, Project project) {
        this.selfGrade = selfGrade;
        this.peerGrade = new double[TEAM];
        this.student = student;
        this.project = project;
    }

    public void setSelfGrade(double selfGrade) {
        this.selfGrade = selfGrade;
    }

    public void setPeerGrade(double[] peerGrade) {
        this.peerGrade = peerGrade;
    }

    public double getSelfGrade() {
        return selfGrade;
    }

    public double[] getPeerGrade() {
        return peerGrade;
    }

    public Participant getStudent() {
        return student;
    }

    public Project getProject() {
        return project;
    }

    public void selfEvaluation(Project project) throws IOException {
        System.out.println("Enter the project name: ");
        String projectName = readString();

        System.out.println("Enter your email: ");
        String email = readString();

        Participant participant = project.getParticipant(email);

        if (participant instanceof Student) {
            for (Participant p : ((ProjectImp) project).getParticipants()) {
                if (p instanceof Student) {
                    System.out.println("Enter the grade for " + p.getName() + ": ");
                    setSelfGrade(Utils.readDouble());
                }
            }
        }
    }

    public void peerEvaluation(Project project) {

    }
}