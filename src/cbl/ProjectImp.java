package cbl;

import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Participant;
import ma02_resources.participants.Partner;
import ma02_resources.participants.Student;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.IllegalNumberOfParticipantType;
import ma02_resources.project.exceptions.IllegalNumberOfTasks;
import ma02_resources.project.exceptions.ParticipantAlreadyInProject;
import ma02_resources.project.exceptions.TaskAlreadyInProject;

import java.util.Arrays;

public class ProjectImp implements Project {
    private static final int FACTOR = 2;
    private final String name;
    private final String description;
    private int numberOfParticipants;
    private int numberOfStudents;
    private int numberOfPartners;
    private int numberOfFacilitators;
    private int numberOfTasks;
    private final int maximumNumberOfTasks;
    private final int maximumNumberOfParticipants;
    private final int maximumNumberOfStudents;
    private final int maximumNumberOfPartners;
    private final int maximumNumberOfFacilitators;
    private Participant[] participants;
    private Task[] tasks;
    private String[] tags;

    /**
     * constructor of the class
     *
     * @param name
     * @param description
     * @param maximumNumberOfTasks
     * @param maximumNumberOfStudents
     * @param maximumNumberOfPartners
     * @param maximumNumberOfFacilitators
     * @param tags
     */
    public ProjectImp(String name, String description, int maximumNumberOfTasks, int maximumNumberOfStudents, int maximumNumberOfPartners, int maximumNumberOfFacilitators, String[] tags) {
        this.name = name;
        this.description = description;
        this.maximumNumberOfParticipants = maximumNumberOfStudents
                + maximumNumberOfPartners + maximumNumberOfFacilitators;
        this.maximumNumberOfTasks = maximumNumberOfTasks;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.maximumNumberOfPartners = maximumNumberOfPartners;
        this.maximumNumberOfFacilitators = maximumNumberOfFacilitators;
        this.tags = tags;
        this.tasks = new Task[maximumNumberOfTasks];
        this.participants = new Participant[maximumNumberOfFacilitators + maximumNumberOfPartners + maximumNumberOfStudents];
    }

    /**
     * this method gets the name of the project
     *
     * @return the name of the project
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * this method gets the description of the project
     *
     * @return the description of the project
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * this method get the number of participants of the project
     *
     * @return the number of participants of the project
     */
    @Override
    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    /**
     * this method gets the number of students of the project
     *
     * @return the number of students of the project
     */
    @Override
    public int getNumberOfStudents() {
        return this.numberOfStudents;
    }

    /**
     * this method gets the number of partners of the project
     *
     * @return the number of partners of the project
     */
    @Override
    public int getNumberOfPartners() {
        return this.numberOfPartners;
    }

    /**
     * this method gets the number of facilitators of the project
     *
     * @return the number of facilitators of the project
     */
    @Override
    public int getNumberOfFacilitators() {
        return this.numberOfFacilitators;
    }

    /**
     * this method gets the number of tasks of the project
     *
     * @return true if the participant was added, false otherwise
     */
    @Override
    public int getNumberOfTasks() {
        return this.numberOfTasks;
    }

    /**
     * this method gets the number of tags of the project
     *
     * @return the number of tags of the project
     */
    @Override
    public int getMaximumNumberOfTasks() {
        return this.maximumNumberOfTasks;
    }

    /**
     * this method gets the maximum number of participants of the project
     *
     * @return the number of participants of the project
     */
    @Override
    public long getMaximumNumberOfParticipants() {
        return this.maximumNumberOfParticipants;
    }

    /**
     * this method gets the maximum number of tags of the project
     *
     * @return the number of students of the project
     */
    @Override
    public int getMaximumNumberOfStudents() {
        return this.maximumNumberOfStudents;
    }

    /**
     * this method gets the maximum number of partners of the project
     *
     * @return the number of partners of the project
     */
    @Override
    public int getMaximumNumberOfPartners() {
        return this.maximumNumberOfPartners;
    }

    /**
     * this method gets the maximum number of facilitators of the project
     *
     * @return the number of facilitators of the project
     */
    @Override
    public int getMaximumNumberOfFacilitators() {
        return this.maximumNumberOfFacilitators;
    }

    /**
     * this method gets the tasks of the project
     *
     * @return the tasks of the project
     */
    @Override
    public Task[] getTasks() {
        return this.tasks;
    }

    /**
     * this method gets the tasks of the project
     *
     * @param s the title of the task
     * @return the task
     */
    @Override
    public Task getTask(String s) {
        for (Task task : this.tasks) {
            if (task == null)
                throw new IllegalArgumentException("Task not found");
            if (task.getTitle().equals(s)) {
                return task;
            }
        }
        return null;
    }

    /**
     * this method gets the tags of the project
     *
     * @return the tags of the project
     */
    @Override
    public String[] getTags() {
        return this.tags;
    }

    /**
     * this method returns the array of participants of the project
     */
    public Participant[] getParticipants() {
        return this.participants;
    }

    /**
     * this method gets the participants of the project by email
     *
     * @param email the email of the participant
     * @return the participant
     * @throws NullPointerException if the participant is not found
     */
    @Override
    public Participant getParticipant(String email) throws IllegalArgumentException {
        for (Participant participant : this.participants) {
            if (participant == null)
                throw new IllegalArgumentException("Participant not found");
            if (participant.getEmail().equals(email)) {
                return participant;
            }
        }
        throw new IllegalArgumentException("Participant not found");
    }

    /**
     * this method gets the index of the participant
     *
     * @param participant the participant
     * @return the index of the participant
     */

    private int getIndex(Participant participant) {
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] == participant)
                return i;
        }
        return -1;
    }

    /**
     * this method checks if the participant is already in the project
     *
     * @param participant the participant
     * @return true if the participant is in the project, false otherwise
     */
    private boolean hasParticipant(Participant participant) {
        if (participant == null)
            return false;
        for (Participant p : participants) {
            if (p == null)
                return false;
            if (p.equals(participant))
                return true;
        }
        return false;
    }

    /**
     * this method adds a participant to the project
     *
     * @param participant the participant
     * @throws IllegalNumberOfParticipantType if the number of participants is reached
     * @throws ParticipantAlreadyInProject    if the participant is already in the project
     */
    @Override
    public void addParticipant(Participant participant) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {
        if (hasParticipant(participant) == true)
            throw new ParticipantAlreadyInProject("Participant already in project");

        if (numberOfParticipants == maximumNumberOfParticipants) {
            throw new IllegalNumberOfParticipantType("Maximum number of participants reached");
        }

        if (numberOfStudents == maximumNumberOfStudents) {
            throw new IllegalNumberOfParticipantType("Maximum number of students reached");
        }
        if (numberOfPartners == maximumNumberOfPartners) {
            throw new IllegalNumberOfParticipantType("Maximum number of partners reached");
        }
        if (numberOfFacilitators == maximumNumberOfFacilitators) {
            throw new IllegalNumberOfParticipantType("Maximum number of facilitators reached");
        }

        this.participants[numberOfParticipants] = participant;

        if (participant instanceof Student) {
            this.numberOfStudents++;
        } else if (participant instanceof Partner) {
            this.numberOfPartners++;
        } else if (participant instanceof Facilitator) {
            this.numberOfFacilitators++;
        }
        this.numberOfParticipants++;
    }

    /**
     * this method removes a participant from the project
     *
     * @param s the email of the participant
     * @return the participant
     */
    public Participant removeParticipant(String s) {
        Participant that = getParticipant(s);
        int index = getIndex(that);
        if (index == -1)
            throw new IllegalArgumentException("Participant not found");

        participants[index] = null;

        for (int i = index; i < numberOfParticipants - 1; i++) {
            participants[i] = participants[i + 1];
        }
        this.numberOfParticipants--;

        if (that instanceof Student) {
            this.numberOfStudents--;
        } else if (that instanceof Partner) {
            this.numberOfPartners--;
        } else if (that instanceof Facilitator) {
            this.numberOfFacilitators--;
        }
        return that;
    }


    /**
     * this method checks if the project has a tag
     *
     * @param s the tag
     * @return true if the project has the tag, false otherwise
     */
    @Override
    public boolean hasTag(String s) {
        for (String tag : this.tags) {
            if (tag.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * this method checks the tasks of the project
     *
     * @return the tasks of the project
     */
    private void hasTask(Task task) throws TaskAlreadyInProject, IllegalArgumentException {
        if (task == null) {
            throw new IllegalArgumentException("Task don't exists");
        }
        for (int i = 0; i < numberOfTasks; i++) {
            if (this.tasks[i].equals(task)) {
                throw new TaskAlreadyInProject("Task already in project");
            }
        }
    }

    /**
     * this method expand the tags
     */
    private void expandTasks() {
        Task[] temp = new Task[this.tasks.length * FACTOR];

        for (int i = 0; i < numberOfTasks; i++) {
            temp[i] = this.tasks[i];
        }
        this.tasks = temp;
    }

    /**
     * this method gets the number of tags of the project
     *
     * @return the number of tags of the project
     */
    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks {

        if (numberOfTasks == maximumNumberOfTasks)
            expandTasks();
        try {
            hasTask(task);
        } catch (TaskAlreadyInProject e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        this.tasks[this.numberOfTasks++] = task;
    }


    /**
     * this method check if the task is completed
     *
     * @return true if the task is completed, false otherwise
     */
    @Override
    public boolean isCompleted() {
        for (Task task : this.tasks) {
            if (task.getNumberOfSubmissions() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * this method display a textual representation of the project progress
     *
     * @return the progress of the project
     */
    public String getProgress() {
        int completedTasks = 0;
        for (Task task : this.tasks) {
            if (task == null)
                break;
            if (task.getNumberOfSubmissions() != 0) {
                completedTasks++;
            }
        }
        return ("\n------PROJECT PROGRESS-------" +
                "\nCompleted: " + completedTasks +
                "\nTotal Tasks: " + numberOfTasks +
                "\nThe project is: " + (completedTasks * 100) / numberOfTasks + "% completed");
    }

    public void listTasks() {
        for (Task task : this.tasks) {
            if (task == null)
                break;
            System.out.println(task);
        }
    }

    /**
     * this method return the information of the project
     *
     * @return the tasks of the project
     */
    @Override
    public String toString() {
        return "\n--------- Project------------" +
                "\n Name:" + name +
                "\n Description=: " + description + '\'' +
                "\n Participants: " + numberOfParticipants + "\t Max. Participants: " + maximumNumberOfParticipants +
                "\n Students: " + numberOfStudents + "\t Max. Students: " + maximumNumberOfStudents +
                "\n Partners: " + numberOfPartners + "\t Max. Partners: " + maximumNumberOfPartners +
                "\n Facilitators: " + numberOfFacilitators + "\t Max. Facilitators: " + maximumNumberOfFacilitators +
                "\n Tags: " + Arrays.toString(tags) +
                "\n Participants: " + Arrays.toString(participants) + Arrays.toString(tasks);
    }
}
