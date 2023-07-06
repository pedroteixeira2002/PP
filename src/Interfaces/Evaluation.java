package Interfaces;

import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;

public interface Evaluation extends Student, Edition, Project {

    void setGrade(double grade);

    @Override
    Project getProject(String s);

    @Override
    int getNumber();

    @Override
    int getNumberOfStudents();
}
