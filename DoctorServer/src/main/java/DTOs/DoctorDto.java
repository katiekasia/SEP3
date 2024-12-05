package DTOs;

public class DoctorDto
{
    public String id;
    public String name;
    public String surname;
    public String specialisation;
    public DoctorDto(String firstname, String lastname, String specialisation, String id) {
        this.name = firstname;
        this.surname = lastname;
        this.specialisation = specialisation;
        this.id = id;
    }

    public String getFirstname() {
        return name;
    }

    public String getLastname() {
        return surname;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setFirstname(String firstname) {
        this.name = firstname;
    }

    public void setLastname(String lastname) {
        this.surname = lastname;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
