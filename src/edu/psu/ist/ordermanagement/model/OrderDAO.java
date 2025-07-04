package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.model.CartSnapshot;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductDAO;
import edu.psu.ist.usermanagement.model.UserSession;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderDAO {

    //inserting them into the db
    public static void insertOrder(Order order) {
        try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "INSERT INTO orders (ID, paymentID, OrderTotal, OrderDate, ShippingID, StatusID, UserID) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql); //better performance than Statement, but mainly to pass parameters at runtime owo
            pstmt.setString(1, order.getOrderID());
            pstmt.setString(2, order.getPaymentID());
            pstmt.setDouble(3, order.getOrderTotal());
            pstmt.setDate(4, java.sql.Date.valueOf(order.getOrderDate()));

            //shipping id
            ShippingDAO.insertShipping(order.getShippingDetails());
            pstmt.setString(5, order.getShippingDetails().getID());

            //status id
            insertOrderStatus(order.getOrderStatusManager());
            pstmt.setString(6, order.getOrderStatusManager().getID());
            pstmt.setString(7, UserSession.getInstance().getUserID());

            pstmt.executeUpdate();

            insertOrderItems(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertOrderItems(Order order) {
        try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "INSERT INTO order_items ( ProductID, Quantity, OrderID) VALUES (?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            for (HashMap.Entry<Product, Integer> entry : order.getCartSnapshot().getItems().entrySet()) {
                stmt.setString(1, entry.getKey().getID());
                stmt.setInt(2, entry.getValue());
                stmt.setString(3, order.getOrderID());
                stmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Order> returnAsArrayList() {
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT * FROM orders WHERE UserID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UserSession.getInstance().getUserID());
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String id = result.getString("ID");
                String paymentID = result.getString("PaymentID");
                LocalDate orderDate = result.getDate("OrderDate").toLocalDate();
                String shippingID = result.getString("ShippingID");
                String statusID = result.getString("StatusID");

                orderArrayList.add(new Order(id, paymentID, orderDate, remakeCartSnapshot(id), ShippingDAO.findShippingByID(shippingID), findOrderStatusByID(statusID)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderArrayList;
    }

    private static CartSnapshot remakeCartSnapshot(String orderID) {
        HashMap<Product, Integer> orderItems = new HashMap<>();
        try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT productID, quantity FROM order_items WHERE OrderID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderID);
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                Product p = ProductDAO.findProductByID(result.getString("productID"));
                if (p != null) orderItems.put(p, result.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CartManager.getInstance().createSnapshot(orderItems);
    }

    public static void insertOrderStatus(OrderStatusManager osm) {
        try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "INSERT INTO order_status (ID, Status, Location, LastUpdatedTime ) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, osm.getID());
            pstmt.setString(2, osm.getOrderStatus().toString());
            pstmt.setString(3, osm.getLocation());
            pstmt.setDate(4, java.sql.Date.valueOf(osm.getLastUpdatedTime()));

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static OrderStatusManager findOrderStatusByID(String id) {
        OrderStatusManager osm = null;

        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT * FROM order_status WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                String osmID = result.getString("ID");
                String status = result.getString("Status");
                String location = result.getString("Location");
                LocalDate lastUpdatedTime = result.getDate("LastUpdatedTime").toLocalDate();

                osm = new OrderStatusManager(osmID, OrderStatusManager.OrderStatus.valueOf(status.toUpperCase()), location, lastUpdatedTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return osm;
    }
}