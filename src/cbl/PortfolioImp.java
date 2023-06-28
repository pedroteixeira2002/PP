package cbl;

import Interfaces.Portfolio;
import exceptions.SubmissionsUpToDate;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Task;

/**
 * This class represents a portfolio
 */
public class PortfolioImp implements Portfolio {
    private static final int SIZE = 10;
    private Edition[] editions;
    private int numberOfEditions;

    /**
     * Constructor of class PortfolioImp
     *
     * @param numberOfEditions
     */
    public PortfolioImp(int numberOfEditions) {
        this.editions = new Edition[SIZE];
        this.numberOfEditions = numberOfEditions;
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
            if (edition1.equals(edition)) {
                throw new IllegalArgumentException("Edition already exists");
            }
        }
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
        for (Edition edition : editions) {
            if (edition.getName().equals(name)) {
                return edition;
            }
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

        if (index != -1) {
            throw new IllegalArgumentException("Edition does not exist");
        }
        editions[index] = null;

        for (int i = index; i < numberOfEditions - 1; i++) {
            editions[i] = editions[i + 1];
        }
        this.numberOfEditions--;

        return true;
    }

    /**
     * this method checks the all missing submissions
     *
     * @return the edition
     * @throws SubmissionsUpToDate if all submissions are up-to-date
     */
    public Edition allMissingSubmissions() throws SubmissionsUpToDate {
        for (Edition edition : this.editions) {
            for (Project project : edition.getProjects()) {
                for (Task task : project.getTasks()) {
                    if (task.getNumberOfSubmissions() != project.getNumberOfStudents()) {
                        return edition;
                    }
                }
            }
        }
        throw new SubmissionsUpToDate("All submissions are up to date");
    }
}
