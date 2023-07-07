package data_persistence;

import cbl.TaskImp;
import data_persistance.Template;
import ma02_resources.project.Task;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

public class ReadYAML {
    private static ReadYAML instance;

    public ReadYAML() {

    }

    public static ReadYAML getInstance() {
        if (instance == null) {
            instance = new ReadYAML();
        }
        return instance;
    }

    public Template readTemplate(LocalDate editionStart, String path) throws IOException, java.text.ParseException {
        try {
            Reader reader = new FileReader(path);
            Yaml yaml = new Yaml();
            Template template = yaml.loadAs(reader, Template.class);

            return template;
        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return null;
    }
}
