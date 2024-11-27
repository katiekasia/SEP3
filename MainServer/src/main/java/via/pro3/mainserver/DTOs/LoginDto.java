package via.pro3.mainserver.DTOs;

public class LoginDto {

    public LoginDto(String cpr, String password) {
        this.cpr = cpr;
        this.password = password;
    }

    public String cpr;
    public String password;

    public String getPassword() {
        return password;
    }

    public String getcpr() {
        return cpr;
    }
}
