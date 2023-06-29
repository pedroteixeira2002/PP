package data_persistance;

import ma02_resources.project.Task;

public class Template {
    private final long number_of_facilitators;
    private final long number_of_students;
    private final long number_of_partners;
    private final Task[] tasks;

    public Template(long number_of_facilitators, long number_of_students, long number_of_partners, Task[] tasks) {
        this.number_of_facilitators = number_of_facilitators;
        this.number_of_students = number_of_students;
        this.number_of_partners = number_of_partners;
        this.tasks = tasks;
    }

    public final long getNumber_of_facilitators() {
        return number_of_facilitators;
    }

    public final long  getNumber_of_students() {
        return number_of_students;
    }

    public final long  getNumber_of_partners() {
        return number_of_partners;
    }

    public Task[] getTasks() {
        return tasks;
    }
}