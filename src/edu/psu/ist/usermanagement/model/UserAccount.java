package edu.psu.ist.usermanagement.model;

public class UserAccount {
    private String username;
    private String password;
    private boolean hasSavedPayment;
    private boolean hasCartItems;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.hasSavedPayment = false;
        this.hasCartItems = false;
    }

    public void toggleHasSavedPayment() {
        hasSavedPayment = !hasSavedPayment;
    }

    public boolean isHasSavedPayment() {
        return hasSavedPayment;
    }

    public boolean isHasCartItems() { return hasCartItems; }

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

    public String getUsername() {
        return username;
    }

    public void setHasCartItems(boolean hasCartItems) {
        this.hasCartItems = hasCartItems;
    }

}
