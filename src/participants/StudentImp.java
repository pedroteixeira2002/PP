package participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Student;

public class StudentImp extends ParticipantImp implements Student {
    private final int number;

    public StudentImp(String name, String email, Contact contact, Instituition instituition, int number) {
        super(name, email, contact, instituition);
        this.number = number;
    }

    /**
     * @return the number of the student
     */
    @Override
    public int getNumber() {
        return this.number;
    }

    /**
     * @return the name of the student
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * @return the email of the student
     */
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    /**
     * @return the contact of the student
     */
    @Override
    public Contact getContact() {
        return super.getContact();
    }

    /**
     * @return the instituition of the student
     */
    @Override
    public Instituition getInstituition() {
        return super.getInstituition();
    }

    /**
     * @param instituition the instituition to set
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * @param contact the contact to set
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);
    }

    /**
     * toString method
     *
     * @param
     */
    @Override
    public String toString() {
        return ("\n" + super.toString() +
                "\n -------Student-------" +
                "\n Student Number: " + number);
    }
}
