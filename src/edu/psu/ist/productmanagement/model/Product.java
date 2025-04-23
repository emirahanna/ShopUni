package edu.psu.ist.productmanagement.model;

import java.util.Date;

/**
 * Encapsulates the features of a product, which can be created and sold
 */
public class Product {
    final String title;
    final String description;
    final String ID;
    final String imageID;
    final String sellerID;
    final Date dateListed;
    final String productCategory;
    final Pricing price;


    public Product(String title, String description, String productID, String imageID, String sellerID, Date dateListed, String productCategory, Pricing price) {
        this.title = title;
        this.description = description;
        this.ID = productID;
        this.imageID = imageID;
        this.sellerID = sellerID;
        this.dateListed = dateListed;
        this.productCategory = productCategory;
        this.price = price;
    }

    public String displayProductDetails() {
        return "Product: " + title + "\n" + "Description: " + description + "\n" + "Category: " + productCategory + "\n" + "Price: "+ price.getPrice() + "\n" + "Listed on: " + dateListed;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
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

    public double getPrice() {
        return price.getPrice();
    }

    @Override
    public String toString(){
        return String.format("%s $%.2f",title,  price.getPrice());
    }
}
