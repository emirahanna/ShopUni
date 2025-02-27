package ProductManagement.model;

import java.util.Date;

/**
 * Encapsulates the features of a product, which can be created and sold
 */
public class Product {
    private String title;
    private String description;
    private String productID;
    private String imageID;
    private String sellerID;
    private Date dateListed;
    private String productCategory;


    public Product(String title, String description, String productID, String imageID, String sellerID, Date dateListed, String productCategory) {
        this.title = title;
        this.description = description;
        this.productID = productID;
        this.imageID = imageID;
        this.sellerID = sellerID;
        this.dateListed = dateListed;
        this.productCategory = productCategory;
    }

    public String displayProductDetails() {
        return "Product: " + title + "\n" + "Description: " + description + "\n" + "Category: " + productCategory + "\n" + "Listed on: " + dateListed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getProductID() {
        return productID;
    }

    public String getImageID() {
        return imageID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public Date getDateListed() {
        return dateListed;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
