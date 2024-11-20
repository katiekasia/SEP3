package DTOs;

public class RegisterDto {
    public String name;
    public String surname;
    public String email;
    public String phone;
    public String password;
    public String cprno;

    public RegisterDto(String name, String surname, String email, String phone, String password, String cprno) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.cprno = cprno;
    }

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

    public String getCprNo() {
        return cprno;
    }
}