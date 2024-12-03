package via.pro3.mainserver.DTOs;

public class DoctorDto {
    public String firstname;
    public String lastname;
    public String specialisation;
    public DoctorDto(String firstname, String lastname, String specialisation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialisation = specialisation;
    }

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
