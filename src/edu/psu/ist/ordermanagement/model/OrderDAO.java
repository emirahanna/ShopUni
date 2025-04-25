package edu.psu.ist.ordermanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OrderDAO {

    public static void insertOrder(Order order) {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "INSERT INTO orders (ID, paymentID, orderTotal, orderDate, orderStatusManager, shippingID ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql); //better performance than Statement, but mainly to pass parameters at runtime owo
            pstmt.setString(1, order.getOrderID());
            pstmt.setString(2, order.getPaymentID());
            pstmt.setDouble(3, order.getOrderTotal());
            pstmt.setDate(4, java.sql.Date.valueOf(order.getOrderDate()));
            pstmt.setString(5, order.getOrderStatusManager().getOrderStatus().toString());
            pstmt.setString(6, order.getShippingDetails().getID());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}