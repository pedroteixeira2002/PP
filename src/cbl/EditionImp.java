package cbl;

import data_persistance.ReadJSON;
import data_persistance.Template;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

public class EditionImp implements Edition {
    private static final int SIZE = 10;
    private static final int FACTOR = 2;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private final String projectTemplate;
    private Status status;
    private int numberOfProjects;
    private Project[] projects;

    /**
     * constructor of the class
     *
     * @param name            the name of the edition
     * @param start           the start date of the edition
     * @param end             the end date of the edition
     * @param projectTemplate the project template of the edition
     */
    public EditionImp(String name, LocalDate start, LocalDate end, String projectTemplate) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("msg");
        }
        if (start == null || start.compareTo(LocalDate.now()) < 0) {
            throw new IllegalArgumentException("msg");
        }
        if (projectTemplate == null || projectTemplate.isEmpty()) {
            throw new IllegalArgumentException("msg");
        }
        this.name = name;
        this.start = start;
        this.end = end;
        this.projectTemplate = projectTemplate;
        this.status = Status.INACTIVE;
        this.numberOfProjects = 0;
        this.projects = new Project[SIZE];
    }

    /**
     * this method gets the name of the edition
     *
     * @return the name of the edition
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * this name gets the start date of the edition
     *
     * @return the start date of the edition
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * this method gets the end date
     *
     * @return the end date
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * this method gets the project template
     *
     * @return the project template
     */
    @Override
    public String getProjectTemplate() {
        return this.projectTemplate;
    }


    /**
     * this method gets the number of projects
     *
     * @return the number of projects
     */
    @Override
    public int getNumberOfProjects() {
        return this.numberOfProjects;
    }

    /**
     * this method gets the status of the edition
     *
     * @return the status of the edition
     */
    @Override
    public Status getStatus() {
        return this.status;
    }

    /**
     * this method sets the status of the edition
     *
     * @param status the status of the edition
     */
    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * this method gets the index of the project
     *
     * @param project the project
     * @return the index of the project
     */
    private int getIndex(Project project) {
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] == project)
                return i;
        }
        return -1;
    }

    @Override
    public void addProject(String name, String description, String[] tags) throws IOException, ParseException {
        if (name == null || description == null || tags == null || tags.length == 0)
            throw new IllegalArgumentException("Arguments illegible");

        ReadJSON read = ReadJSON.getInstance();

        Template template = read.readTemplate(this.start, this.projectTemplate);
        Task[] tasks = template.getTasks();
        Project project = new ProjectImp(name, description, tasks.length, (int) template.getNumber_of_students(), (int) template.getNumber_of_partners(), (int) template.getNumber_of_facilitators(), tags);
        for (Task task : tasks) {
            try {
                project.addTask(task);
            } catch (IllegalNumberOfTasks | TaskAlreadyInProject exception) {
                System.out.println(exception.getMessage());
            }
        }
        if (numberOfProjects == this.projects.length)
            expandProjects();
        this.projects[numberOfProjects] = project;
        this.numberOfProjects++;
    }

    /**
     * this method remove a project from the edition
     *
     * @param s the name of the project
     */
    @Override
    public void removeProject(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Project name is empty");
        }
        Project that = getProject(s);
        int index = getIndex(that);
        if (index == -1) {
            throw new IllegalArgumentException("Project not exists");
        }
        projects[index] = null;
        for (int i = index; i < numberOfProjects - 1; i++) {
            projects[i] = projects[i + 1];
        }
        System.out.println("Project removed with success");
    }

    /**
     * this method expand the projects array
     */
    private void expandProjects() {
        Project[] temp = new Project[this.projects.length * FACTOR];

        for (int i = 0; i < numberOfProjects; i++) {
            temp[i] = this.projects[i];
        }
        this.projects = temp.clone();
    }

    /**
     * this method gets the number of projects
     *
     * @return
     */
    @Override
    public Project[] getProjects() {
        return this.projects;
    }

    /**
     * this method gets the project
     */
    @Override
    public Project getProject(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Project name is empty");
        }
        for (Project project : projects) {
            if (project == null)
                throw new IllegalArgumentException("Project not found");
            if (project.getName().equals(s)) {
                return project;
            }
        }
        throw new IllegalArgumentException("Project not found");
    }

    /**
     * this method gets the projects by tag
     *
     * @param s the tag
     * @return the projects by tag
     */
    @Override
    public Project[] getProjectsByTag(String s) {
        int index = 0;
        Project[] array = new Project[20];
        for (Project project : projects) {
            if (project == null)
                break;
            for (String tag : project.getTags()) {
                if (tag == null)
                    break;
                if (tag.equals(s))
                    array[index] = project;
                index++;
            }
        }
        return array;
    }

    /**
     * this method gets the projects of a participant
     *
     * @param s the participant
     * @return the projects of a participant
     */
    @Override
    public Project[] getProjectsOf(String s) {
        int index = 0;
        Project[] array = new Project[20];
        for (Project project : projects) {
            if (project == null)
                break;
            try {
                project.getParticipant(s);
            } catch (NullPointerException exception) {
                System.out.println("Participant not found");
            }
            array[index] = project;
            index++;
        }
        return array;
    }

    /**
     * this method gets the progress of the edition
     *
     * @return the progress
     */
    public String getProgress() {
        int completedTasks = 0;
        int countTasks = 0;

        for (Project project : this.projects) {
            if (project == null)
                break;
            for (Task task : project.getTasks()) {
                if (task == null)
                    break;
                countTasks++;
                if (task.getNumberOfSubmissions() != 0) {
                    completedTasks++;
                }
            }
        }
        return ("\nCompleted: " + completedTasks +
                "\nTotal Tasks: " + countTasks +
                "\nThe Edition is: " + (completedTasks * 100) / countTasks + "% completed");
    }

    public void listProjects() {
        for (Project project : this.projects) {
            if (project == null)
                break;
            System.out.println(project);
        }
    }

    /**
     * this method gives the information of the edition
     *
     * @return the information
     */
    @Override
    public String toString() {
        return "\n---------------------Edition-------------------" +
                "\n Name: " + name +
                "\n Start Date: " + start +
                "\n End Date: " + end +
                "\n Status: " + status +
                "\n Number Of Projects: " + numberOfProjects +
                "\n Projects: " + Arrays.toString(projects) +
                "\n---------------------------------------------";
    }
}
