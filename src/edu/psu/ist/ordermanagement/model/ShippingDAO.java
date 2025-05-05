package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.productmanagement.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

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

    public static Shipping findShippingByID(String shippingID) {
        Shipping foundShipping = null;

        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT * FROM shipping WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, Long.parseLong(shippingID));

            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                String id = result.getString("ID");
                String orderID = result.getString("OrderID");
                String address = result.getString("address");
                Shipping.DeliveryOption deliveryOption = Shipping.DeliveryOption.valueOf(result.getString("deliveryOption").toUpperCase());
                LocalDate orderDate =  result.getDate("orderDate").toLocalDate();

                foundShipping = new Shipping(id, orderID, address, deliveryOption, orderDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundShipping;
    }


}
