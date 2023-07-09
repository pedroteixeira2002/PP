package participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.Participant;

import java.util.Objects;

public abstract class ParticipantImp implements Participant {

    private final String name;
    private final String email;
    private Contact contact;
    private Instituition instituition;

    /**
     * This constructor creates a ParticipantImp object with the following parameters.
     *
     * @param name         The name of the participant.
     * @param email        The email of the participant.
     * @param contact      The contact of the participant.
     * @param instituition The instituition of the participant.
     */
    public ParticipantImp(String name, String email, Contact contact, Instituition instituition) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.instituition = instituition;
    }

    /**
     * this method returns the name of the participant.
     *
     * @return The name of the participant.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * this method returns the email of the participant.
     *
     * @return The email of the participant.
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * this method returns the contact of the participant.
     *
     * @return The contact of the participant.
     */
    @Override
    public Contact getContact() {
        return contact;
    }

    /**
     * this method returns the instituition of the participant.
     *
     * @return The instituition of the participant.
     */
    public Instituition getInstituition() {
        return instituition;
    }

    /**
     * this method sets the contact of the participant.
     *
     * @param contact The contact of the participant.
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * this method sets the instituition of the participant.
     *
     * @param instituition The instituition of the participant.
     */
    public void setInstituition(Instituition instituition) {
        this.instituition = instituition;
    }

    /**
     * this method returns the participant information.
     *
     * @return The participant information.
     */
    @Override
    public String toString() {
        return ("\n -------Participant-------" +
                "\n Name: " + name +
                "\n Email: " + email + contact.toString() + instituition.toString());
    }

/**
     * this method compares two participants.
     *
     * @param participant The participant to be compared.
     * @return True if the participants are equal, false otherwise.
     */
    @Override
    public boolean equals(Object participant) {
        if (this == participant) {
            return true;
        }
        if (participant == null) {
            return false;
        }
        if (!(participant instanceof ParticipantImp)) {
            return false;
        }
        final ParticipantImp other = (ParticipantImp) participant;
        return Objects.equals(this.email, other.email);
    }
}
