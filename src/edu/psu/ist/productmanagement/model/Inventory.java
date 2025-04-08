package edu.psu.ist.productmanagement.model;

public class Inventory {
    private int quantity;
    private boolean inStock;

    public Inventory(int quantity) {
        this.quantity = quantity;
        if (quantity > 0){
            this.inStock = true;
        }
        else{
            this.inStock = false;
        }
    }

    public boolean isAvailable() {
        return inStock;
    }

    public void updateStock(int newQuantity) {
        this.quantity = newQuantity;
        if (quantity > 0){
            this.inStock = true;
        }
        else{
            this.inStock = false;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public String stockStatus() {
        //ternary operator for easy 1-line readability
        return inStock ? "Available (" + quantity + " left)" : "Out of Stock";
    }

    public void addStock() {
        inStock = true; // this is here to mark product as available
    }

    public void reduceStock() {
        inStock = false; // Mark product as unavailable after purchase
    }
}
