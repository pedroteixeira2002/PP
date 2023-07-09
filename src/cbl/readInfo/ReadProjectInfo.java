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

import static participants.readInfo.Utils.readString;

/**
 *  class responsible for reading the information of a project
 */
public class ReadProjectInfo {

    /**
     * method responsible for reading the information of a project
     * @return description
     */
    public static String readDescription() {
        String description = null;
        do {
            try {
                System.out.println("Enter the description:\n");
                description = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (description == null);
        return description;
    }

    /**
     * method responsible for reading the name of a project
     * @return name
     */
    public static String readName() {
        String name = null;
        do {
            try {
                System.out.println("Enter the name:\n");
                name = readString();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (name == null);
        return name;
    }

    /**
     * method responsible for reading the tags of a project
     * @return tags
     */
    public static String[] readTags() {

        String[] tags = null;
        do {
            try {
                System.out.println("Enter the tags (separate them by using space):\n");
                tags = readString().split(" ");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (tags == null);
        return tags;
    }
}
