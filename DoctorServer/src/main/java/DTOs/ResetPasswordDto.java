package DTOs;

public class ResetPasswordDto {
    public String id;
    public String currentPassword;
    public String newPassword;

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
