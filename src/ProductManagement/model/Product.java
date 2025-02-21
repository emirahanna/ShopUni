package ProductManagement.model;

import java.util.Date;

/**
 *  Encapsulates the features of a product, which can be created and sold
 */
public class Product {
    private String title;
    private String description;
    private String productID;
    private String imageID;
    private String sellerID;
    private Date date;
    private boolean isSold;
    private double price;
    private int stockQuantity;
    private String category; //maybe make it an enum? Finite Options would be easier


    public void sellProduct(){ }

    public void updatePrice(double newPrice) { this.price = newPrice; }
    public void updateStock(int newStock) { this.stockQuantity = newStock; }
}
