package edu.psu.ist.usermanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDAO {

    public static void insertUser(UserAccount userAccount) {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://path_to_db.accdb")) {
            String sql = "INSERT INTO user_database (ID, username, password, role, hasSavedPayment, hasItemInCart ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql); //better performance than Statement, but mainly to pass parameters at runtime
            pstmt.setString(1, UserSession.getInstance().getUserID());
            pstmt.setString(2, userAccount.getUsername());
            pstmt.setString(3, userAccount.getPassword());
            pstmt.setString(4, userAccount.getRole().toString());
            pstmt.setBoolean(5, userAccount.isHasSavedPayment());
            pstmt.setBoolean(6, userAccount.isHasCartItems());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
