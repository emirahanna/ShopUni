package edu.psu.ist.cartmanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.psu.ist.cartmanagement.util.CartObserver;
import edu.psu.ist.cartmanagement.util.CartSubject;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductDAO;
import edu.psu.ist.usermanagement.model.UserSession;

/**
 * Class that emulates the behavior of an actual cart
 */
public class CartManager implements CartSubject, CartSnapshot {
    private double totalPrice;
    private final Map<Product, Integer> cartContents;
    private final List<CartObserver> observers = new ArrayList<>();
    final static CartManager instance = new CartManager();  // Singleton instance, eager loaded for thread safety

    private CartManager() {
        cartContents = new HashMap<Product, Integer>();
        totalPrice = 0;
    }

    public static CartManager getInstance() {
        return instance;
    }

    @Override
    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CartObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (CartObserver observer : observers) {
            observer.update();
        }
    }

    /**
     * accesses the product's price and increments it to totalPrice
     */

    public void addProduct(Product p) {
        cartContents.put(p, cartContents.getOrDefault(p, 0) + 1);
        calculateTotalPrice(p.getPrice());
        notifyObservers();

    }


    /**
     * accesses the product's price and decrements it from totalPrice
     */
    public void removeProduct(Product p) {
        if (cartContents.containsKey(p) && cartContents.get(p) > 0) {
            cartContents.put(p, cartContents.get(p) - 1);
            calculateTotalPrice(-p.getPrice());
            if (cartContents.get(p) == 0) {
                cartContents.remove(p);
            }
        }
        notifyObservers();
    }


    /**
     * purges the map, and total price
     */
    public void emptyCart() {
        cartContents.clear();
        totalPrice = 0;
    }

    //attempt to export a new snapshot for DAO purposes
    public CartSnapshot createSnapshot(HashMap<Product, Integer> map) {
        return new CartSnapshot() {

            @Override
            public Map<Product, Integer> getItems() {
                return Collections.unmodifiableMap(map);
            }

            @Override
            public double getTotal() {
                double total = 0;
                for (Product p: map.keySet()){
                    total += p.getPrice();
                }
                return total;
            }
        };
    }

    private void calculateTotalPrice(double price) {
        totalPrice += price;
    }

    public double getTotal() {
        return totalPrice;
    }

    public Map<Product, Integer> getItems() {
        return Collections.unmodifiableMap(cartContents); //added security, ensures map isn't exposed to modification
    }

    public boolean isEmpty() {
        return cartContents.isEmpty();
    }
}
