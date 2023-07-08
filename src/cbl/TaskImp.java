package cbl;

import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Status;
import ma02_resources.project.Submission;
import ma02_resources.project.Task;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class TaskImp implements Task {
    private static int SIZE = 10;
    private final int FACTOR = 2;
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private int duration;
    private int extendDeadline;
    private Submission[] submissions;
    private int numberOfSubmissions;

    /**
     * constructor of the class
     *
     * @param EditionStart the start date of the edition
     * @param title        the title of the task
     * @param description  the description of the task
     * @param start        the start date of the task
     * @param duration     the duration of the task
     */
    public TaskImp(LocalDate EditionStart, String title, String description, int start, int duration) {
        this.title = title;
        this.description = description;
        this.start = EditionStart.plusDays(start);
        this.end = EditionStart.plusDays(duration);
        this.duration = duration;
        this.extendDeadline = 0;
        this.submissions = new Submission[SIZE];
        this.numberOfSubmissions = 0;
    }

    public TaskImp(String title, String description, LocalDate start, LocalDate end, int duration) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.submissions = new Submission[SIZE];
        this.numberOfSubmissions = 0;
        this.extendDeadline = 0;

    }

    /**
     * this method return the start date of the task
     *
     * @return the start date of the task
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * this method return the end date of the task
     *
     * @return the end date of the task
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * this method return the duration of the task
     *
     * @return the duration of the task
     */
    @Override
    public int getDuration() {
        return this.duration;
    }

    /**
     * this method return the title of the task
     *
     * @return
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * this method return the description of the task
     *
     * @return the description of the task
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * this method return the submission of the task
     *
     * @return the submission of the task
     */
    @Override
    public Submission[] getSubmissions() {
        return this.submissions;
    }

    /**
     * this method return the number of submissions of the task
     *
     * @return the number of submissions of the task
     */
    @Override
    public int getNumberOfSubmissions() {
        return this.numberOfSubmissions;
    }

    /**
     * this method add a submission to the task
     *
     * @param submission the submission to be added
     * @throws IllegalArgumentException if the submission is null or if the submission already exists
     */
    public void addSubmission(Submission submission) throws IllegalArgumentException {
        if (submission == null) {
            throw new IllegalArgumentException("Submission is null");
        }

        // Check if the project's edition is active
        if (!isActiveEdition()) {
            System.out.println("Cannot add submission. The project's edition is not active.");
            return;
        }

        // Access the project participants
        Student[] projectStudents = getProjectStudents();

        // Check if the submitting participant is a student and belongs to the project
        if (submission.getParticipant() instanceof Student) {
            Student submittingStudent = (Student) submission.getParticipant();
            if (!containsStudent(projectStudents, submittingStudent)) {
                System.out.println("Cannot add submission. The submitting student is not part of the project.");
                return;
            }
        } else {
            System.out.println("Cannot add submission. Only students are allowed to submit for this project.");
            return;
        }

        // Continue with the submission process
        try {
            hasSubmission(submission);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (this.numberOfSubmissions == this.submissions.length) {
            expandSubmissions();
        }

        this.submissions[numberOfSubmissions] = submission;
        this.numberOfSubmissions++;
    }


    /**
     * this method expand the submissions array
     */
    private void expandSubmissions() {

        Submission[] temp = new Submission[this.submissions.length * FACTOR];

        for (int i = 0; i < numberOfSubmissions; i++) {
            temp[i] = this.submissions[i];
        }

        this.submissions = temp;
    }

    /**
     * this method check if the submission already exists
     *
     * @param submission the submission to be checked
     * @throws IllegalArgumentException if the submission already exists
     */
    public void hasSubmission(Submission submission) throws IllegalArgumentException {
        for (int i = 0; i < numberOfSubmissions; i++) {
            if (this.submissions[i].equals(submission)) {
                throw new IllegalArgumentException("Submission already exists");
            }
        }
    }

    /**
     * this method return the extenddeadline of the task
     *
     * @return the extenddeadline of the task
     */
    @Override
    public void extendDeadline(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid number of days");
        } else {
            this.end = this.end.plusDays(i);
        }
    }

    public void listSubmissions(){
        for(Submission submission : this.submissions){
            if (submission == null)
                break;
            System.out.println(submission);
        }
    }

    private boolean containsStudent(Student[] students, Student student) {
        for (Student s : students) {
            if (s != null && s.equals(student)) {
                return true;
            }
        }
        return false;
    }

    private boolean isActiveEdition(Edition edition) {
        return edition.getStatus() == Status.ACTIVE;
    }


    /**
     * this method compare two tasks
     *
     * @param task the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Task task) {
        return this.start.compareTo(task.getStart());
    }

    /**
     * this method check if two tasks are equal
     *
     * @param obj the object to be compared.
     * @return true if the tasks are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        return Objects.equals(this.title, other.getTitle());
    }

    /**
     * this method return the string representation of the task
     *
     * @return the string representation of the task
     */
    @Override
    public String toString() {
        return  "\n -------Task-------" +
                "\n Title: " + title +
                "\n Description: " + description +
                "\n Start: " + start +
                "\n End: " + end +
                "\n Duration: " + duration +
                "\n Deadline extended by " + extendDeadline + " days" +
                "\n Number Of Submissions: " + numberOfSubmissions +
                "\n Submissions: " + Arrays.toString(submissions);
    }

}
