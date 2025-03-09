package UserManagement.model;

public class UserAccount {
    private String username;
    private String password;
    private String email;
    private boolean hasSavedPayment;

    public UserAccount(String username, String password) {
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

    public UserRole verifyUser(){
        if (username.equals("buyer") && password.equals("pwd")) {
            return UserRole.BUYER;
        }
        else if (username.equals("seller") && password.equals("pwd")) {
            return UserRole.SELLER;
        }
        else if (username.equals("admin") && password.equals("pwd")) {
            return UserRole.ADMIN;
        }
        throw new IllegalArgumentException("Not a valid user");
    }

}
