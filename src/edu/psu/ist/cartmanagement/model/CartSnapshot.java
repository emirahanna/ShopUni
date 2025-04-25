package edu.psu.ist.cartmanagement.model;

import edu.psu.ist.productmanagement.model.Product;

import java.util.Map;

/**
 * Allows for other packages to get cart information without accessing the actual, mutable cart
 */
public interface CartSnapshot {
    Map<Product, Integer> getItems();
    double getTotal();
}
