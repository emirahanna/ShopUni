package UserManagement.controller;

public class UserSessionController {
    private String username;
    private String password;
    private String email;
    private boolean hasSavedPayment;

    public UserSessionController(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.hasSavedPayment = false;
    }

    public void toggleHasSavedPayment() {
        hasSavedPayment = !hasSavedPayment;
    }

    public boolean isHasSavedPayment() {
        return hasSavedPayment;
    }
}
