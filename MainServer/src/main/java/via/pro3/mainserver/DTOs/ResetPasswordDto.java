package via.pro3.mainserver.DTOs;

public class ResetPasswordDto {
    public String id;
    public String currentPassword;
    public String newPassword;

    public ResetPasswordDto(String id, String currentPassword, String newPassword) {
        this.id = id;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getId() {
        return id;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
