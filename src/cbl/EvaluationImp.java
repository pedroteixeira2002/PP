package cbl;


import Interfaces.Evaluation;
import ma02_resources.project.Project;

public abstract class EvaluationImp implements Evaluation {


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

}
