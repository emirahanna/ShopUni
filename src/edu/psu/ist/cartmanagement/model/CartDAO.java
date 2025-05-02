package edu.psu.ist.cartmanagement.model;

import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.usermanagement.model.UserSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//data access objects my beloved... <3
public class CartDAO {
    public static void insertCart(CartManager cart, Product specProduct) {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            //check if product exists in the database
            String checkSql = "SELECT quantity FROM cart_items WHERE userID = ? AND productID = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, UserSession.getInstance().getUserID());
            checkStmt.setString(2, specProduct.getID());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                //  If already exist, update quantity

                String updateSql = "UPDATE cart_items SET quantity = ? WHERE userID = ? AND productID = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setInt(1, cart.getItems().get(specProduct));
                updateStmt.setString(2,UserSession.getInstance().getUserID());
                updateStmt.setString(3, specProduct.getID());
                updateStmt.executeUpdate();

            } else {
                // If not exists, insert new row
                String insertSql = "INSERT INTO cart_items (userID, productID, quantity, price) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1,UserSession.getInstance().getUserID());
                insertStmt.setString(2, specProduct.getID());
                insertStmt.setInt(3, cart.getItems().get(specProduct));
                insertStmt.setDouble(4, specProduct.getPrice());
                insertStmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<CartItemRecord> getCartItemsForUser(String userID) {
        List<CartItemRecord> items = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT productID, quantity FROM cart_items WHERE userID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String productId = rs.getString("productID");
                int quantity = rs.getInt("quantity");
                items.add(new CartItemRecord(productId, quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void deleteCartItemsForUser(String userID) {
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "DELETE FROM cart_items WHERE userID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}