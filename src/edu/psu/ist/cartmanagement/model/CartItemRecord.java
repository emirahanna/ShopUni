package edu.psu.ist.cartmanagement.model;

/**
 * Helper class to ensure that the cart is persistent between sessions.
 * so tired
 */
public class CartItemRecord {
    private String productID;
    private int quantity;

    public CartItemRecord(String productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
}
