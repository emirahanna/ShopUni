package ProductDetailManagement;

import java.util.Date;

/**
 *  Important details about a specific product so it can be listed and sold, also connects the product to the seller
 */

public class ProductDetails {
    private String productName;
    private String productImgID;
    private String productID;
    private String sellerID;
    private String productCategory;
    private boolean inStock;
    private int price;
    private int quantity;
    private String description;
    private int ProductVariations;
    private Date dateListed;

    //constructor for product details
    public ProductDetails (String productName, String productImgID, String productID, String sellerID, String productCategory, boolean inStock, int price, int quantity,String description, int ProductVariations, Date dateListed) {
        this.productName = productName;
        this.productImgID = productImgID;
        this.productID = productID;
        this.sellerID = sellerID;
        this.productCategory = productCategory;
        this.inStock = inStock;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.ProductVariations = ProductVariations;
        this.dateListed = dateListed;
    }

    //getters for each piece of information about the product
    public String getProductName() {
        return productName;
    }

    public String getProductImgID() {
        return productImgID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public String getProductID() {
        return productID;
    }

    public String getproductCategory() {
        return productCategory;
    }

    public String getDescription() {
        return description;
    }

    public boolean getInStock() {
        return inStock;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductVariations() {
        return ProductVariations;
    }

    public Date getDateListed() {
        return dateListed;
    }
}
