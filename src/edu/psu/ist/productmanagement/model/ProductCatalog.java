package edu.psu.ist.productmanagement.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ProductCatalog {
    private ArrayList<Product> products;
    private int productPerPage = 3;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        loadProducts();
        //loadSampleProducts(); // sample data, actual shop should be reading from a database
    }

    private void loadProducts(){ //this is terrible if we scale since we're loading everything at once. for now, it's fine to load the first 50
        String databaseURL = "jdbc:ucanaccess://C:\\Users\\Hanna\\OneDrive\\Documents\\PSU\\IST412\\ShopUni\\src\\ProductList.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {


            String sql = "SELECT * FROM sample_products";

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
                Pricing price = new Pricing(result.findColumn("price"));

                products.add(new Product(title, description, id, imageID, sellerID, date, productCategory, price));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadSampleProducts() {
        products.add(new Product("TOP", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("PANTS", "Effortlessly chic, this draped front top is crafted from a MicroModal blend offering a soft, luxurious feel with a hint of stretch.\nWith a slim fit and high neckline, it features gathered detailing across the front creating a flattering, asymmetrical silhouette.\nPair with skirts or tailored trousers for a sophisticated take.", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("HOODIE", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(30) ));
        products.add(new Product("PANTS", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance.\nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(60) ));
        products.add(new Product("SOMETHING", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(100) ));
        products.add(new Product("SOMETHING", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40.99) ));
    }

    /**
     * This basically returns the products in the list that will be displayed on a certain page
     * @param page
     * @return
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
}
