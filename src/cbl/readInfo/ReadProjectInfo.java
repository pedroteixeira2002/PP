package cbl.readInfo;

import static participants.readInfo.Utils.readString;

public class ReadProjectInfo {
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
