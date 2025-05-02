package edu.psu.ist.productmanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductDAO {

    public static Product findProductByID(String productID) {
        Product foundProduct = null;

        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT * FROM products WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, Long.parseLong(productID));

            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                String id = result.getString("ID");
                String title = result.getString("title");
                String description = result.getString("description");
                String imageID = result.getString("imageID");
                String sellerID = result.getString("sellerID");
                Date date = result.getDate("dateListed");
                String productCategory = result.getString("productCategory");
                double price = result.getDouble("price");

                foundProduct = new Product(title, description, id, imageID, sellerID, date, productCategory, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foundProduct;
    }
}
