package edu.psu.ist.productmanagement.model;

import java.time.LocalDate;

/**
 * Encapsulates the features of a product, which can be created and sold
 */
public class Product {
    private final String title;
    private final String description;
    private final String ID;
    private final String imageID;
    private final String sellerID;
    private final LocalDate dateListed;
    private final ProductCategory productCategory;
    private final double price;


    public Product(String title, String description, String productID, String imageID, String sellerID, LocalDate dateListed, String productCategory, double price) {
        this.title = title;
        this.description = description;
        this.ID = productID;
        this.imageID = imageID;
        this.sellerID = sellerID;
        this.dateListed = dateListed;
        this.productCategory = ProductCategory.valueOf(productCategory.toUpperCase());
        this.price = price;
    }

    public String displayProductDetails() {
        return "Product: " + title + "\n" + "Description: " + description + "\n" + "Category: " + productCategory + "\n" + "Price: "+ price + "\n" + "Listed on: " + dateListed;
    }

    @Override
    public boolean equals(Object o) {
        //handling if it's comparing with itself, or comparing with different classes.
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //omg typecasting
        Product product = (Product) o;
        return ID.equals(product.getID());
    }

    @Override
    public int hashCode() {
        return  ID != null ? ID.hashCode() : 0;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getImageID() {
        return imageID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return String.format("%s $%.2f",title,  price);
    }
}
