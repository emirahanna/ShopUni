package edu.psu.ist.usermanagement.model;

import java.sql.*;

public class UserAccount {
    private String userID;
    private String username;
    private String password;
    private UserRole role;
    private boolean hasSavedPayment;
    private boolean hasCartItems;

    //constructor for logging in
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //constructor for registering an account
    public UserAccount(String username, String password, UserRole role) {
        this.userID = UserIDGenerator.createID().toString();
        this.username = username;
        this.password = password;
        this.role = role;
        this.hasSavedPayment = false;
        this.hasCartItems = false;
    }

    public UserRole verifyUser() {
        String databaseURL = "jdbc:ucanaccess://src/ProductList.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM user_database";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String user = result.getString("username");
                String pwd = result.getString("password");
                String role = result.getString("role").toUpperCase();
                if (user.equals(username) && pwd.equals(password)) {
                    this.role = Enum.valueOf(UserRole.class, role);
                    this.hasSavedPayment = result.getBoolean("hasSavedPayment");
                    this.hasCartItems = result.getBoolean("hasItemInCart");
                    UserSession.getInstance().setUserID(result.getString("ID"));
                    //returns the corresponding role as an enum
                    return Enum.valueOf(UserRole.class, role);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //not a registered user, so it has no role
        return UserRole.NONE;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setHasCartItems(boolean hasCartItems) {
        this.hasCartItems = hasCartItems;
    }

    public boolean isHasSavedPayment() {
        return hasSavedPayment;
    }

    public boolean isHasCartItems() {
        return hasCartItems;
    }

}
