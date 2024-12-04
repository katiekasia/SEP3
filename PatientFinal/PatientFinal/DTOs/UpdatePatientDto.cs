namespace PatientFinal.DTOs;

public class UpdatePatientDto
{
    public string cpr { get; set; }
    public string surname { get; set; }
    public string phone { get; set; }
    public string email { get; set; }
    public string oldPassword { get; set; }
    public string newPassword { get; set; }
}