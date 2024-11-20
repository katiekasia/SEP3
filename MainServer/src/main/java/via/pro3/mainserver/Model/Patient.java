package via.pro3.mainserver.Model;

public class Patient {
    private String name;
    private String surname;
    private String password;
    private String CPRNo;
    private String phone;
    private String email;

    public Patient(String name, String surname, String password, String CPRNo, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.CPRNo = CPRNo;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getCPRNo() {
        return CPRNo;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCPRNo(String CPRNo) {
        this.CPRNo = CPRNo;
    }
}
