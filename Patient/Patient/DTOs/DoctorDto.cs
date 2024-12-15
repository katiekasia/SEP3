namespace Patient.DTOs;

public class DoctorDto
{
    public string name { get; set; }
    public string surname { get; set; }
    public string id { get; set; }
    public string specialization { get; set; }

    public DoctorDto(string id, string name, string surname, string specialization)
    {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.specialization = specialization;
    }
}