package edu.psu.ist.paymentmanagement.model;

import edu.psu.ist.usermanagement.model.UserSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PaymentDAO {

    public static void insertPayment(Payment payment) {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "INSERT INTO payments (ID, paymentOption, amountPaid, transactionDate, userID ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql); //better performance than Statement, but mainly to pass parameters at runtime owo
            pstmt.setString(1, payment.getPaymentID());
            pstmt.setString(2, payment.getPaymentOption().toString());
            pstmt.setDouble(3, payment.getAmountPaid());
            pstmt.setDate(4, java.sql.Date.valueOf(payment.getTransactionDate()));
            pstmt.setString(5, UserSession.getInstance().getUserID());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
