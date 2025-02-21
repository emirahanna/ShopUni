package CartManagement.model;

import ProductManagement.model.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void updateQuantity(int newQuantity) { this.quantity = newQuantity; }
}
