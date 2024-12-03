package DTOs;

public class DoctorDto {
    public String firstname;
    public String lastname;
    public String specialisation;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
