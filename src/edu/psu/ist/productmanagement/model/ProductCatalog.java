package edu.psu.ist.productmanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ProductCatalog {
    private ArrayList<Product> products;
    private final int productPerPage = 5;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        loadProducts();

    }

    private void loadProducts(){ //this is terrible if we scale since we're loading everything at once. for now, it's fine to load the first 50
        String databaseURL = "jdbc:ucanaccess://src/ProductList.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM products";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String title = result.getString("title");
                String description = result.getString("description");
                String id = result.getString("ID");
                String imageID = result.getString("imageID");
                String sellerID = result.getString("sellerID");
                String productCategory = result.getString("productCategory");
                Date date = result.getDate("dateListed");
                double price = (result.getDouble("price"));

                products.add(new Product(title, description, id, imageID, sellerID, date, productCategory, price));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * This basically returns the products in the list that will be displayed on a certain page
     */
    public ArrayList<Product> getProductsOnPage(int page) {
        int start = (page - 1) * productPerPage;
        int end = Math.min(start + productPerPage, products.size());

        if (start >= products.size()) return new ArrayList<>(); // No more products

        return new ArrayList<>(products.subList(start, end));
    }

    public int getTotalPages() {
        return products.size() / productPerPage;
    }

    public ArrayList<Product> getFeaturedProducts(){
        int featuredProductCount = Math.min(3, products.size());
        return new ArrayList<>(products.subList(0,featuredProductCount));
    }
}
