package edu.psu.ist.ordermanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//guys this is not funny haha anymore. this is painful
public class ShippingDAO {

    public static void insertShipping(Shipping shipping) {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "INSERT INTO shipping (ID, orderID, address, deliveryOption, orderDate ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql); //better performance than Statement, but mainly to pass parameters at runtime owo
            pstmt.setString(1, shipping.getID());
            pstmt.setString(2, shipping.getOrderID());
            pstmt.setString(3, shipping.getAddress());
            pstmt.setString(4, shipping.getDeliveryOption().toString());
            pstmt.setDate(5, java.sql.Date.valueOf(shipping.getOrderDate()));

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}