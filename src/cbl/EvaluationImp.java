package cbl;


import Interfaces.Evaluation;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;

import cbl.ProjectImp;

import java.io.IOException;

import static participants.readInfo.Utils.readString;


public abstract class EvaluationImp implements Evaluation {
    private double selfGrade;
    private double[] peerGrade;
    private Participant student;
    private Project project;


    @Override
    public Project getProject(String s) {
        return null;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getNumberOfStudents() {
        return 0;
    }

    @Override
    public void setGrade(double grade) {

    }
/*
    public void selfEvaluation(Project project) throws IOException {

        System.out.println("Enter your email: ");
        String email = readString();
        Participant participant = project.getParticipant(email);
        if (participant instanceof Student) {
            for (Participant p : ((ProjectImp) project).getParticipants()) {
                if (p instanceof Student) {
                    System.out.println("Enter the grade for " + p.getName() + ": ");
                    double grade = UserInput.getDouble();
                    ((Student) p).setGrade(grade);
                }
            }
        }
    }*/
}