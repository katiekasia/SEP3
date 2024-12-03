namespace Doctor.DTOs;

public class LoginDto
{
    public string cpr {get;set;}
    public string password{get;set;}

    public LoginDto(string cpr, string password)
    {
        this.cpr = cpr;
        this.password = password;
    }
}