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


import ma02_resources.participants.*;
import ma02_resources.project.*;
import participants.ContactImp;
import participants.InstitutionImp;
import participants.StudentImp;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class that tests the implementation of the project statically
 */
public class TEST {
    public static void main(String[] args) {
        EditionImp edition = new EditionImp("ED001", LocalDate.now(), LocalDate.of(2023, 12, 23), "json_files//project_template.json");
        Contact cont0 = new ContactImp("Rua Doutor Joaquim Manuel Costa 194", "Gondomar", "Porto", "4420-437", "913844167", "Portugal");
        Instituition i1 = new InstitutionImp("ESTG", cont0, "sa@estg.ipp.pt", InstituitionType.UNIVERSITY, "Escola Superior de Tecnologia e Gestão", "www.estg.ipp.pt");
        Participant p1 = new StudentImp("Pedro Teixeira", "jpedroteixeira59@gmail.com", cont0, i1, 8200489);


        //tags
        String tag0 = "CARS";
        String tag1 = "EXHAUSTS";
        String tag2 = "TURBOCHARGER";
        String tag3 = "RATATA";
        //string of tags
        String[] tags = {tag0, tag1, tag2, tag3};

        //submissions
        Submission sub1 = new SubmissionImp(LocalDateTime.now(), (Student) p1, "feito");
        //project info
        String name = "Honda";
        String description = "Honda is a Japanese public multinational conglomerate corporation primarily known as a manufacturer of automobiles";
        try {
            edition.addProject(name, description, tags);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        Project project = edition.getProject("Honda");
        Task[] tasks = project.getTasks();
        tasks[0].addSubmission(sub1);
        tasks[1].addSubmission(sub1);
        System.out.println(edition.getProgress());


        System.out.println(((ProjectImp) project).getProgress());

    }
}
