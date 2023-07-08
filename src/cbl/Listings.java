package cbl;

import Interfaces.Evaluation;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;

public class Listings {

    public static Project getProjectWithMostStudents(Project[] projects) {
        if (projects == null || projects.length == 0) {
            return null;
        }

        Project projectWithMostStudents = null;
        int maxStudents = -1;

        for (Project project : projects) {
            int numberOfStudents = project.getNumberOfStudents();
            if (numberOfStudents > maxStudents) {
                maxStudents = numberOfStudents;
                projectWithMostStudents = project;
            }
        }

        return projectWithMostStudents;
    }


    public static Participant findStudentWithHighestAppreciation(Project project) {
        Participant studentWithHighestAppreciation = null;
        double highestAppreciation = 0.0;

        Participant[] participants = project.getParticipants();

        for (int i = 0; i < project.getNumberOfParticipants(); i++) {
            Participant participant = participants[i];
            if (participant instanceof Student) {
                Student student = (Student) participant;
                Evaluation evaluation = student.getEvaluation(project);
                double finalEvaluation = evaluation.calculateFinalEvaluation();

                if (finalEvaluation > highestAppreciation) {
                    highestAppreciation = finalEvaluation;
                    studentWithHighestAppreciation = student;
                }
            }
        }

        return studentWithHighestAppreciation;
    }

}
