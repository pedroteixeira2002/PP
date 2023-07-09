/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */


package cbl.readInfo;

import cbl.EditionImp;
import ma02_resources.project.Edition;
import menus.Menu;

import java.time.LocalDate;
import java.util.Scanner;

import static participants.readInfo.Utils.readLocalDate;
import static participants.readInfo.Utils.readString;

/**
 *  class responsible for reading the information of an edition
 */
public class ReadEditionInfo {

    /**
     * method responsible for reading the information of an edition
     * @return Edition
     */
    public static Edition readEdition() {
        String name = readName();
        System.out.println("Enter the start date:\n");
        LocalDate startDate = readLocalDate();
        LocalDate endDate;
        do {
            System.out.println("Enter the end date:\n");
            endDate = readLocalDate();

            if (endDate.isBefore(startDate)) {
                System.out.println("End date cannot be before the start date. Please try again.");
            }
        } while (endDate.isBefore(startDate));

        String projectTemplate = chooseTemplate();
        return new EditionImp(name, startDate, endDate, projectTemplate);
    }

    /**
     * method responsible for reading the name of an edition
     * @return name
     */
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

    /**
     * method responsible for reading the project template
     * @return project template
     */
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

    /**
     * method responsible for choosing the project template
     * @return project template
     */
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

    /**
     * method responsible for getting the option
     * @return option
     */
    private static int getOption() {
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        return option;
    }
}
