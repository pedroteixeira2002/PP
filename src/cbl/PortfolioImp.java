package cbl;

import Interfaces.Portfolio;
import exceptions.NoActveEdition;
import exceptions.SubmissionsUpToDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import ma02_resources.project.Task;

import java.util.IllegalFormatCodePointException;

/**
 * This class represents a portfolio
 */
public class PortfolioImp implements Portfolio {
    private static final int SIZE = 10;
    private Edition[] editions;
    private int numberOfEditions;
    private int counter;

    /**
     * Constructor of class PortfolioImp
     */
    public PortfolioImp() {
        this.editions = new Edition[SIZE];
        this.numberOfEditions = 0;
    }

    /**
     * this method lists all editions in the portfolio
     */
    public void listEditions() {
        for (Edition edition : this.editions) {
            if (edition != null)
                System.out.println(edition);
        }
    }

    /**
     * @return the editions in the portfolio
     */
    public Edition[] getEditions() {
        return editions;
    }

    /**
     * @return the number of editions in the portfolio
     */
    public int getNumberOfEditions() {
        return numberOfEditions;
    }

    /**
     * this method checks if the edition already exists
     *
     * @param edition the edition to be checked
     * @throws IllegalArgumentException if the edition already exists
     */
    private void hasEdition(Edition edition) throws IllegalArgumentException {
        if (edition == null) {
            throw new IllegalArgumentException("Edition is null");
        }
        for (Edition edition1 : this.editions) {
            if (edition1 == null) {
                break;
            }
            if (edition1.equals(edition)) {
                throw new IllegalArgumentException("Edition already exists");
            }
        }
    }

    private int findActiveEdition() throws NoActveEdition {
        int i = 0;
        while (i < this.numberOfEditions) {
            if (this.editions[i].getStatus() == Status.ACTIVE) {
                return i;
            }
            i++;
        }
        throw new NoActveEdition("No active edition");
    }

    /**
     * this method gets the index of the edition
     *
     * @param edition the edition to be checked
     * @return the index of the edition
     */
    public int getIndex(Edition edition) {
        for (int i = 0; i < editions.length; i++) {
            if (editions[i] == edition)
                return i;
        }
        return -1;
    }

    /**
     * this method gets the edition
     *
     * @param name the name of the edition
     * @return the edition
     */
    public Edition getEdition(String name) {
        for (Edition edition : this.editions) {
            if (edition.getName().equals(name))
                return edition;
        }
        throw new IllegalArgumentException("Edition does not exist");

    }

    public int numberOfDoneTasks(String editionName, String projectName) {
        int pos = find(editionName);
        Project project = this.editions[pos].getProject(projectName);
        Task[] tasks = project.getTasks();

        int i = 0;
        int num = 0;
        while (i < project.getNumberOfTasks()) {
            if (tasks[i].getNumberOfSubmissions() > 0) {
                num++;
            }
            i++;
        }

        return num;
    }

    private int find(String editionName) {
        if (editionName == null || editionName.isEmpty()) {
            throw new IllegalArgumentException("msg");
        }

        int i = 0;
        while (i < this.counter) {
            if (editionName.equals(this.editions[i].getName())) {
                return i;
            }
            i++;
        }
        throw new IllegalArgumentException("msg");
    }

    public int numberOfDoneProjects(String editionName) {
        int pos = find(editionName);
        Project[] projects = this.editions[pos].getProjects();

        int i = 0;
        int num = 0;
        while (i < this.editions[pos].getNumberOfProjects()) {
            if (projects[i].isCompleted()) {
                num++;
            }
            i++;
        }
        return num;
    }

    /**
     * this method adds an edition to the portfolio
     *
     * @param edition
     */
    public void addEdition(Edition edition) {
        try {
            hasEdition(edition);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        this.editions[numberOfEditions] = edition;
        this.numberOfEditions++;
    }

    /**
     * this method removes the edition
     *
     * @param name the name of the edition to be removed
     * @return true if the edition was removed
     */
    public boolean removeEdition(String name) {
        Edition that = getEdition(name);
        int index = getIndex(that);

        if (index == -1) {
            throw new IllegalArgumentException("Edition does not exist");
        }
        editions[index] = null;

        for (int i = index; i < numberOfEditions - 1; i++) {
            editions[i] = editions[i + 1];
        }
        this.numberOfEditions--;
        System.out.println("Edition removed with success");
        return true;
    }

    /**
     * This method sets all Active editions to Closed.
     */
    public void setAllToClosed() {

        for (Edition edition : this.editions) {
            if (edition == null)
                break;

            if (edition.getStatus() == Status.ACTIVE)
                edition.setStatus(Status.CLOSED);
        }
    }

    public void editionWithMissingSubmissionInProjects(String editionName) {
        Edition edition = getEdition(editionName);
        for (Project project : edition.getProjects()) {
            if (project == null) {
                break;
            }
            for (Task task : project.getTasks()) {
                if (task == null) {
                    break;
                }
                if (task.getNumberOfSubmissions() != project.getNumberOfStudents()) {
                    System.out.println(project);
                    break;
                }
            }
        }
        System.out.println("All submissions are up to date");

    }

    /**
     * this method checks the all missing submissions
     *
     * @return the edition
     * @throws SubmissionsUpToDate if all submissions are up-to-date
     */
    public void editionsWithMissingSubmissions() {
        for (Edition edition : this.editions) {
            if (edition == null) {
                break;
            }
            for (Project project : edition.getProjects()) {
                if (project == null) {
                    break;
                }
                for (Task task : project.getTasks()) {
                    if (task == null) {
                        break;
                    }
                    if (task.getNumberOfSubmissions() != project.getNumberOfStudents()) {
                        System.out.println(edition);
                    }
                }
            }
        }
        System.out.println("All submissions are up to date");
    }
}
