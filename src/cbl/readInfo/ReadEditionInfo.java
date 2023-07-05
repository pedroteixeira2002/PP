package cbl.readInfo;

import cbl.EditionImp;
import ma02_resources.project.Edition;

import java.time.LocalDate;

import static participants.readInfo.Utils.readLocalDate;
import static participants.readInfo.Utils.readString;

public class ReadEditionInfo {
    public static Edition readEdition() {
        String name = readName();
        System.out.println("Enter the start date:\n");
        LocalDate startDate = readLocalDate();
        System.out.println("Enter the end date:\n");
        LocalDate endDate = readLocalDate();
        String projectTemplate = readProjectTemplate();
        return  new EditionImp(name, startDate, endDate, projectTemplate);
    }

    private static String readName() {
        String name;
        do {
            try {
                System.out.println("Enter the name:\n");
                name = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                name = null;
            }
        } while (name == null);
        return name;
    }

    private static String readProjectTemplate() {
        String projectTemplate;
        do {
            try {
                System.out.println("Enter the project template:\n");
                projectTemplate = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                projectTemplate = null;
            }
        } while (projectTemplate == null);
        return projectTemplate;
    }
}
