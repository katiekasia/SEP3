namespace Doctor.DTOs;

public class ResetPasswordDto
{
    public String id{get; set;}
    public String currentPassword {get;set;}
    public String newPassword{get;set;}
}