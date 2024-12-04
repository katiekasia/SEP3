package via.pro3.mainserver.DTOs;

public class ResetPasswordDto {
    public String id;
    public String newPassword;

    public ResetPasswordDto(String id, String newPassword) {
        this.id = id;
        this.newPassword = newPassword;
    }


    public String getId() {
        return id;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
