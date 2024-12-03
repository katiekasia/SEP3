namespace PatientFinal.DTOs;

public class LoginDto
{
    public LoginDto(string cpr, string password)
    {
        this.cpr = cpr;
        this.password = password;
    }
    public String cpr { get; set; }
    public String password {get; set;}
}