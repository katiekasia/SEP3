namespace Patient.DTOs;

public class ClinicDto
{
    public string id { get; set; }
    public string name { get; set; }
    public string address { get; set; }
    
    public ClinicDto (string id, string name, string address)
    {
        this.id = id;
        this.name = name;
        this.address = address;
    }

}