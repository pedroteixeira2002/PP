package cbl;


import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class TEST {
    public static void main(String[] args)  {
        Edition edition = new EditionImp("ED001", LocalDate.now(), LocalDate.of(2023, 12, 23), "json_files//project_template.json");
        //tags
        String tag0 = "CARS";
        String tag1 = "EXHAUSTS";
        String tag2 = "TURBOCHARGER";
        String tag3 = "RATATA";
        //string of tags
        String[] tags = {tag0, tag1, tag2, tag3};

        //project info
        String name= "Honda";
        String description = "Honda is a Japanese public multinational conglomerate corporation primarily known as a manufacturer of automobiles";
        try {
            edition.addProject(name, description, tags);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
