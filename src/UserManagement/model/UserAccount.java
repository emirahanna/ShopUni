package UserManagement.model;

public class UserAccount {
    private String username;
    private String password;
    private String email;
    private boolean hasSavedPayment;

    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.hasSavedPayment = false;
    }

    public void toggledHasSavedPayment(){
        hasSavedPayment = !hasSavedPayment;
    }


}
