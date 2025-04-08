package usermanagement.controller;

public class UpdatePasswordController {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    public UpdatePasswordController(String username, String oldPassword, String newPassword, String confirmPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public void updatePassword() {
        if (newPassword.equals(confirmPassword)) {
            System.out.println("Password updated successfully for user: " + username);
        } 
        else {
            System.out.println("New passwords do not match. Please try again.");
        }
    }

    public String getUsername() {
        return username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
