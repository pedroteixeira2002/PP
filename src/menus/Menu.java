package menus;

import Interfaces.Portfolio;
import cbl.*;
import cbl.readInfo.ReadProjectInfo;
import cbl.readInfo.ReadSubmissionInfo;
import cbl.readInfo.ReadTaskInfo;
import data_persistance.WriteJSON;
import data_persistance.WriteYAML;
import exceptions.SubmissionsUpToDate;
import ma02_resources.participants.Participant;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;
import participants.StudentImp;
import participants.readInfo.ReadFacilitatorInfo;
import participants.readInfo.ReadPartnerInfo;
import participants.readInfo.ReadStudentInfo;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

import static cbl.readInfo.ReadEditionInfo.readEdition;
import static participants.readInfo.Utils.readInt;
import static participants.readInfo.Utils.readString;


public class Menu {
    /**
     * this method is responsible for getting the option chosen by the user
     *
     * @return the option chosen by the user
     */
    private int getOption() {
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        return option;
    }

    /**
     * this method is responsible for displaying the menu of the edition
     */
    private void displayMainMenu() {
        System.out.println("\n___________Welcome to the Main Menu_______________");
        System.out.println("\n| 1 - Create Edition                             |");
        System.out.println("\n| 2 - Remove Edition                             |");
        System.out.println("\n| 3 - List Editions                              |");
        System.out.println("\n| 4 - Manipulate Edition                         |");
        System.out.println("\n| 5 - Editions with late submissions in Projects |");
        System.out.println("\n| 6 - Check number of editions                   |");
        System.out.println("\n| 7 - Save Portfolio                             |");
        System.out.println("\n| 0 - Exit                                       |");
        System.out.println("\n--------------------------------------------------");
    }


    public void mainMenu() throws IOException, ParseException, TaskAlreadyInProject, IllegalNumberOfTasks, ParticipantAlreadyInProject, IllegalNumberOfParticipantType, SubmissionsUpToDate {
        PortfolioImp portfolio = new PortfolioImp();
        Evaluations evaluations= new Evaluations();
        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            int option = getOption();
            switch (option) {
                case 1:
                    try {
                        portfolio.addEdition(readEdition());
                        System.out.println("Edition created successfully");
                    } catch (Exception e) {
                        System.out.println("Edition creation failed");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the edition you want to remove");
                    portfolio.removeEdition(readString());
                    break;
                case 3:
                    portfolio.listEditions();
                    break;
                case 4:
                    System.out.println("Enter the name of the edition you want to manipulate");
                    editionMenu(portfolio.getEdition(readString()), portfolio);
                    break;
                case 5:
                    portfolio.editionsWithMissingSubmissions();
                    break;
                case 6:
                    System.out.println("There are " + portfolio.getNumberOfEditions() + "editions!");
                    break;
                case 7:
                    exportMenu(portfolio);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }
    }

    private void displayEditionMenu() {
        System.out.println("\n_______Welcome_to_the_Edition_Manager_Menu____");
        System.out.println("\n| 1 - Set Edition as Active                  |");
        System.out.println("\n| 2 - Create new Project for Edition         |");
        System.out.println("\n| 3 - Remove project from Edition            |");
        System.out.println("\n| 4 - Manage Project                         |");
        System.out.println("\n| 5 - Check Edition progress                 |");
        System.out.println("\n| 6 - Check number of projects               |");
        System.out.println("\n| 7 - List Projects                          |");
        System.out.println("\n| 8 - List Projects by Tag                   |");
        System.out.println("\n| 9 - List Projects by Participant           |");
        System.out.println("\n| 0 - Exit                                   |");
        System.out.println("\n----------------------------------------------");
    }

    private void editionMenu(Edition edition, Portfolio portfolio) throws IOException, ParseException, TaskAlreadyInProject, IllegalNumberOfTasks, ParticipantAlreadyInProject, IllegalNumberOfParticipantType {
        EditionImp tempEdition = (EditionImp) edition;

        boolean isRunning = true;
        while (isRunning) {
            displayEditionMenu();
            int option = getOption();
            switch (option) {
                case 1:
                    ((PortfolioImp) portfolio).setAllToInactive();
                    edition.setStatus(Status.ACTIVE);
                    System.out.println("Edition set as active");
                    break;
                case 2:
                    if (edition.getStatus().equals(Status.INACTIVE) || edition.getStatus().equals(Status.ACTIVE))
                        edition.addProject(ReadProjectInfo.readName(), ReadProjectInfo.readDescription(), ReadProjectInfo.readTags());
                    else
                        System.out.println("Edition is not illegible for new projects");
                    break;
                case 3:
                    System.out.println("Enter the name of the project you want to remove");
                    edition.removeProject(readString());
                    break;
                case 4:
                    System.out.println("Enter the name of the project you want to manage");
                    projectMenu(edition.getProject(readString()), edition, evaluations);
                    break;
                case 5:
                    System.out.println(tempEdition.getProgress());
                    break;
                case 6:
                    System.out.println("There are " + edition.getNumberOfProjects() + "projects!");
                    break;

                case 7:
                    ((EditionImp) edition).listProjects();
                    break;
                case 8:
                    System.out.println("Enter the tag you want to search for");
                    Project[] temp = edition.getProjectsByTag(readString());
                    System.out.println(Arrays.toString(temp));
                    break;
                case 9:
                    System.out.println("Enter the name of the participant you want to search for");
                    edition.getProjectsOf(readString());
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void displayProjectMenu() {
        System.out.println("\n____Welcome_to_the_Project_Manager_Menu____");
        System.out.println("\n| 1 - Add Participant to Project           |");
        System.out.println("\n| 2 - Remove Participant from Project      |");
        System.out.println("\n| 3 - Add Task to Project                  |");
        System.out.println("\n| 4 - List all Tasks of Project            |");
        System.out.println("\n| 5 - Get project progress                 |");
        System.out.println("\n| 6 - Get participant                      |");
        System.out.println("\n| 7 - Manage task                          |");
        System.out.println("\n| 8 - Add Evaluation                       |");
        System.out.println("\n| 0 - Exit                                 |");
        System.out.println("\n--------------------------------------------");
    }

    private void projectMenu(Project project, Edition edition, Evaluations evaluations) throws TaskAlreadyInProject, IllegalNumberOfTasks, IOException, ParticipantAlreadyInProject, IllegalNumberOfParticipantType {
        boolean isRunning = true;
        while (isRunning) {
            displayProjectMenu();
            int option = getOption();
            switch (option) {
                case 1:
                    project.addParticipant(participantSelect());
                    break;
                case 2:
                    System.out.println("Enter the name of the participant you want to remove");
                    project.removeParticipant(readString());
                    break;
                case 3:
                    if (edition.getStatus().equals(Status.ACTIVE)) {
                        System.out.println("Enter your email");
                        String email = readString();
                        Participant participant = project.getParticipant(email);
                        for (Participant pTemp : ((ProjectImp) project).getParticipants()) {
                            if (pTemp == null)
                                break;
                            if (pTemp == participant && participant instanceof StudentImp) {
                                project.addTask(ReadTaskInfo.readTask());
                            }
                        }
                    } else
                        System.out.println("Edition is not illegible for new tasks");
                    break;
                case 4:
                    ((ProjectImp) project).listTasks();
                    break;
                case 5:
                    System.out.println(((ProjectImp) project).getProgress());
                    break;
                case 6:
                    System.out.println("Enter the email of the participant you want to search for");
                    Participant temp = project.getParticipant(readString());
                    System.out.println(temp.toString());
                    break;
                case 7:
                    System.out.println("Enter the name of the task you want to manage for");
                    taskMenu(project.getTask(readString()));
                    break;
                case 8:
                    evaluations.addEvaluation();
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private Participant participantSelect() {
        System.out.println("\n Which type of participant do you want to select?");
        System.out.println("\n  1 - Student");
        System.out.println("\n  2 - Facilitator");
        System.out.println("\n  3 - Partner");
        int option = getOption();
        boolean isRunning = true;
        while (isRunning) {
            switch (option) {
                case 1:
                    return ReadStudentInfo.readStudent();
                case 2:
                    return ReadFacilitatorInfo.readFacilitator();
                case 3:
                    return ReadPartnerInfo.readPartner();
                default:
                    System.out.println("Invalid option");
            }
        }
        return null;
    }

    private void displayTask() {
        System.out.println("\n____Welcome_to_the_Task_Manager_Menu_____");
        System.out.println("\n| 1 - Add submission                     |");
        System.out.println("\n| 2 - Extend Deadline                    |");
        System.out.println("\n| 3 - Obtain Number of Submissions       |");
        System.out.println("\n| 4 - List Submissions                   |");
        System.out.println("\n| 0 - Exit                               |");
        System.out.println("\n------------------------------------------");
    }

    private void taskMenu(Task task) {
        boolean isRunning = true;
        while (isRunning) {
            displayTask();
            int option = getOption();
            switch (option) {
                case 1:
                    task.addSubmission(ReadSubmissionInfo.readSubmission());
                    break;
                case 2:
                    System.out.println("Enter the number of days you want to extend the deadline");
                    task.extendDeadline(readInt());
                    break;
                case 3:
                    System.out.println(task.getNumberOfSubmissions());
                    break;
                case 4:
                    ((TaskImp) task).listSubmissions();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void displayExportMenu() {
        System.out.println("\n____Welcome_to_the_Export_Menu_____");
        System.out.println("\n| 1 - Export to JSON               |");
        System.out.println("\n| 2 - Export to YAML               |");
        System.out.println("\n| 3 - Export to all                |");
        System.out.println("\n| 0 - Exit                         |");
        System.out.println("\n------------------------------------");
    }

    private void exportMenu(PortfolioImp portfolio) throws IOException {
        WriteJSON json = new WriteJSON();
        WriteYAML yaml = new WriteYAML();
        boolean isRunning = true;
        while (isRunning) {
            displayExportMenu();
            int option = getOption();
            switch (option) {
                case 1:
                    json.writeJSON(portfolio);
                    break;
                case 2:
                    yaml.writeYAML(portfolio);
                    break;
                case 3:
                    json.writeJSON(portfolio);
                    yaml.writeYAML(portfolio);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }
    }

    public void displayChooseTemplate() {
        System.out.println("\n____Welcome_to_the_Template_Menu_____");
        System.out.println("\n| 1 - Provided Template             |");
        System.out.println("\n| 0 - Exit                          |");
        System.out.println("\n------------------------------------");
    }


    public void displayEvaluation() {
        System.out.println("\n____Welcome_to_the_Evaluation_Menu_______");
        System.out.println("\n| 1 - Evaluate Teammate                  |");
        System.out.println("\n| 2 - Evaluate Yourself                  |");
        System.out.println("\n| 0 - Exit                               |");
        System.out.println("\n-----------------------------------------");
    }

}

