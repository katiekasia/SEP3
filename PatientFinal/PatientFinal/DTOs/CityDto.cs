namespace PatientFinal.DTOs;

public class CityDto
{
    public string name { get; set; }
    public string code { get; set; }
    
    public CityDto() {}
    
    public CityDto(string name, string code) {

        this.name = name;
        this.code = code;
    }
}
