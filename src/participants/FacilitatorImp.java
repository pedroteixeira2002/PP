package participants;

import ma02_resources.participants.Contact;
import ma02_resources.participants.Facilitator;
import ma02_resources.participants.Instituition;

public class FacilitatorImp extends ParticipantImp implements Facilitator {
    private String areaOfExpertise;

    /**
     * Constructor of FacilitatorImp
     * @param name the name of the facilitator
     * @param email the email of the facilitator
     * @param contact the contact of the facilitator
     * @param institution the institution of the facilitator
     * @param areaOfExpertise the area of expertise of the facilitator
     */
    public FacilitatorImp(String name, String email, Contact contact, Instituition institution, String areaOfExpertise) {
        super(name, email, contact, institution);
        this.areaOfExpertise = areaOfExpertise;
    }

    /**
     * this method returns the area of expertise of the facilitator.
     * @return areaOfExpertise of the facilitator
     */
    @Override
    public String getAreaOfExpertise() {
        return this.areaOfExpertise;
    }

    /**
     * this method sets the area of expertise of the facilitator.
     * @param s areaOfExpertise of the facilitator
     */
    @Override
    public void setAreaOfExpertise(String s) {
        this.areaOfExpertise = s;
    }

    /**
     * this method returns the name of the facilitator.
     * @return  name of the facilitator
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * this method returns the email of the facilitator.
     * @return email of the facilitator
     */
    @Override
    public String getEmail() {
        return super.getEmail() ;
    }

    /**
     * this method returns the contact of the facilitator.
     * @return contact of the facilitator
     */
    @Override
    public Contact getContact() {
        return super.getContact();
    }

    /**
     * this method returns the instituition of the facilitator.
     * @return instituition of the facilitator
     */
    @Override
    public Instituition getInstituition() {
        return super.getInstituition();
    }

    /**
     * this method sets the instituition of the facilitator.
     * @param instituition instituition of the facilitator
     */
    @Override
    public void setInstituition(Instituition instituition) {
        super.setInstituition(instituition);
    }

    /**
     * this method sets the name of the facilitator.
     * @param contact contact of the facilitator
     */
    @Override
    public void setContact(Contact contact) {
        super.setContact(contact);
    }

    /**
     * this method toString of the facilitator.
     * @param
     */
    @Override
    public String toString() {
        return ("\n " + super.toString() +
                "\n -------Facilitator-------" +
                "\n Area Of Expertise: " + areaOfExpertise);
    }
}
