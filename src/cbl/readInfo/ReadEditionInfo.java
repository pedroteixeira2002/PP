package cbl.readInfo;

import cbl.EditionImp;
import ma02_resources.project.Edition;
import menus.Menu;

import java.time.LocalDate;
import java.util.Scanner;

import static participants.readInfo.Utils.readLocalDate;
import static participants.readInfo.Utils.readString;

public class ReadEditionInfo {
    public static Edition readEdition() {
        String name = readName();
        System.out.println("Enter the start date:\n");
        LocalDate startDate = readLocalDate();
        System.out.println("Enter the end date:\n");
        LocalDate endDate = readLocalDate();
        String projectTemplate = chooseTemplate();
        return new EditionImp(name, startDate, endDate, projectTemplate);
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

    private static String chooseTemplate() {
        Menu menu = new Menu();
        boolean isRunning = true;
        while (isRunning) {
            menu.displayChooseTemplate();
            int option = getOption();
            switch (option) {
                case 1:
                    return "json_files//project_template.json";
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        return null;
    }

    private static int getOption() {
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        return option;
    }
}
