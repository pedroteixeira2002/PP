package data_persistance;

import cbl.TaskImp;
import ma02_resources.project.Task;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

public class ReadJSON {
    private static ReadJSON instance;

    public ReadJSON() {

    }

    public static ReadJSON getInstance() {
        if (instance == null) {
            instance = new ReadJSON();
        }
        return instance;
    }


    public Template readTemplate(LocalDate editionStart, String path) throws IOException, java.text.ParseException {


        try {
            Reader reader = new FileReader(path);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(reader);

            long number_of_facilitators = (Long) object.get("number_of_facilitators");
            long number_of_students = (Long) object.get("number_of_students");
            long number_of_partners = (Long) object.get("number_of_partners");

            JSONArray tasks = (JSONArray) object.get("tasks");
            Task[] task = new Task[tasks.size()];

            for (int i = 0; i < tasks.size(); i++) {

                JSONObject taskTmp = (JSONObject) tasks.get(i);

                String task_title = (String) taskTmp.get("title");
                String task_description = (String) taskTmp.get("description");
                long start_at = (Long) taskTmp.get("start_at");
                long duration = (Long) taskTmp.get("duration");

                task[i] = new TaskImp(editionStart, task_title, task_description, (int) start_at, (int) duration);
            }
            return new Template( number_of_facilitators, number_of_students, number_of_partners, task);

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (ParseException e) {
            throw new java.text.ParseException("msg", e.getPosition());
        }
        return null;
    }
}