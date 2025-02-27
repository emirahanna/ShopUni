package CartManagement.model;

import java.util.ArrayList;
import java.util.Map;

import ProductManagement.model.Product;

public class Cart {
    private String userID;
    private double totalPrice;
    private Map<Product, Integer> cartContent;

    public void addProduct(Product p){
        //accesses the product's price and increments it to totalPrice
    }
    public void removeProduct(Product p){
        //accesses the product's price and decrements it from totalPrice
    }
    public void emptyCart(){
        //purges the map, and total price
    }
    public void buyCart(){
        //creates an order using the cartContent
    }
    private void calculateTotalPrice(double price){
        totalPrice+=price;
    }
    public double displayTotalPrice(){
        return totalPrice;
    }

}
