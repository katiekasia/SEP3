package DTOs;

public class UpdatePatientDto
{
    private String CPR;
    private String surname;
    private String phone;
    private String email;
    private String oldPassword;
    private String newPassword;

    public String getCPR() { return CPR; }
    public String getSurname()
    {
        return surname ;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getOldPassword() {return oldPassword;}

    public String getNewPassword()
    {
        return newPassword;
    }


    public void setCPR(String CPR) {this.CPR = CPR;}
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    public UpdatePatientDto(String CPR, String surname, String phone, String email, String oldPassword, String newPassword)
    {
        this.CPR = CPR;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

}
