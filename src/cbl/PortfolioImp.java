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

    private void activeEditionWithLateSubmissions() throws SubmissionsUpToDate {
        for (Edition edition : this.editions) {
            if (edition.getStatus().equals(Status.ACTIVE)) {
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
            if (edition == null) {
                break;
            }
        }
        throw new SubmissionsUpToDate("Active Edition has all submissions up to date");
    }

    /**
     * This method sets all Active editions to Closed.
     */
    public void setAllToInactive() {
        for (Edition edition : this.editions) {
            if (edition == null)
                break;

            if (edition.getStatus() == Status.ACTIVE)
                edition.setStatus(Status.CLOSED);
        }
    }

    public void editionWithMissingSubmission(String editionName) throws SubmissionsUpToDate {
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
                    System.out.println(edition);
                }
            }
        }
        throw new SubmissionsUpToDate("All submissions are up to date");

    }

    /**
     * this method checks the all missing submissions
     *
     * @return the edition
     * @throws SubmissionsUpToDate if all submissions are up-to-date
     */
    public void editionsWithMissingSubmissions() throws SubmissionsUpToDate {
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
        throw new SubmissionsUpToDate("All submissions are up to date");
    }

}
