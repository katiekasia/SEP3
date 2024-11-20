package via.pro3.mainserver.DTOs;

public class RegisterPatientDto {
    public String name;
    public String surname;
    public String email;
    public String phone;
    public String password;
    public String CprNo;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getCPRNo() {
        return CprNo;
    }
}
