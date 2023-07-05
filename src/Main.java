import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;
import menus.Menu;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        try {
            menu.mainMenu();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (TaskAlreadyInProject e) {
            throw new RuntimeException(e);
        } catch (IllegalNumberOfTasks e) {
            throw new RuntimeException(e);
        } catch (ParticipantAlreadyInProject e) {
            throw new RuntimeException(e);
        } catch (IllegalNumberOfParticipantType e) {
            throw new RuntimeException(e);
        }
    }
}