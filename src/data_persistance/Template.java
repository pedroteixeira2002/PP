/*
 * Nome: João Pedro Ferreira Teixeira
 * Número: 8200489
 * Turma: LEI12T3
 *
 * Nome: Rómulo César Marinho Leite
 * Número: 8200593
 * Turma: LEI12T2
 */

package data_persistance;

import ma02_resources.project.Task;

/**
 * Class that represents a template
 */
public class Template {
    private final long number_of_facilitators;
    private final long number_of_students;
    private final long number_of_partners;
    private final Task[] tasks;

    /**
     * Constructor of the class
     * @param number_of_facilitators number of facilitators
     * @param number_of_students number of students
     * @param number_of_partners number of partners
     * @param tasks array of tasks
     */
    public Template(long number_of_facilitators, long number_of_students, long number_of_partners, Task[] tasks) {
        this.number_of_facilitators = number_of_facilitators;
        this.number_of_students = number_of_students;
        this.number_of_partners = number_of_partners;
        this.tasks = tasks;
    }

    /**
     * Method that returns the number of facilitators
     * @return number of facilitators
     */
    public final long getNumber_of_facilitators() {
        return number_of_facilitators;
    }

    /**
     * Method that returns the number of students
     * @return number of students
     */
    public final long  getNumber_of_students() {
        return number_of_students;
    }

    /**
     * Method that returns the number of partners
     * @return number of partners
     */
    public final long  getNumber_of_partners() {
        return number_of_partners;
    }

    /**
     * Method that returns the array of tasks
     * @return array of tasks
     */
    public Task[] getTasks() {
        return tasks;
    }
}