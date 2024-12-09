package via.pro3.mainserver.DTOs;
public class DoctorDto
{
    private String id;
    private String name;
    private String surname;
    private String specialization;
    public DoctorDto(String id, String name, String surname, String specialization) {
        this.id= id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String firstname) {
        this.name = firstname;
    }

    public void setSurname(String lastname) {
        this.surname = lastname;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
