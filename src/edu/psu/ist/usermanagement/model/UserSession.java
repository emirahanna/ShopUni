package edu.psu.ist.usermanagement.model;

public class UserSession {
    private static UserSession instance;
    private String userID;

    private UserSession() {}// private to prevent instantiation

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void clearSession() {
        userID = null;
    }

    public boolean isLoggedIn() {
        return userID != null;
    }
}
