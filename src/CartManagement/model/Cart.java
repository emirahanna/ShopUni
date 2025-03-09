package CartManagement.model;

import java.util.HashMap;
import java.util.Map;

import OrderManagement.controller.OrderController;
import ProductManagement.model.Product;

/**
 *  Class that emulates the behavior of an actual cart
 */
public class Cart {
    private String userID;
    private double totalPrice;
    private Map<Product, Integer> cartContents;

    public Cart(String userID) {
        this.userID = userID;
        cartContents = new HashMap<Product, Integer>();
        totalPrice = 0;
    }

    /**
     *     accesses the product's price and increments it to totalPrice
     */

    public void addProduct(Product p){
        cartContents.put(p, cartContents.getOrDefault(p, 0) + 1);
        calculateTotalPrice(p.getPrice());

    }

    /**
     *    accesses the product's price and decrements it from totalPrice
     */
    public void removeProduct(Product p){
        if (cartContents.containsKey(p) && cartContents.get(p) > 0) {
            cartContents.put(p, cartContents.get(p) - 1);
            calculateTotalPrice(-p.getPrice());
            if (cartContents.get(p) == 0) {
                cartContents.remove(p);
            }
        }

    }

    /**
     * purges the map, and total price
     */
    public void emptyCart(){
        cartContents.clear();
        totalPrice = 0;
    }

    /**
     * creates an order using the cartContent
     */
    public void buyCart(){
       //new OrderController(new);
    }
    private void calculateTotalPrice(double price){
        totalPrice+=price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Product, Integer> getCartContents() {
        return cartContents;
    }
}
