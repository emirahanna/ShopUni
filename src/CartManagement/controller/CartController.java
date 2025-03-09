package CartManagement.controller;

import CartManagement.model.Cart;
import CartManagement.view.CartContentsView;

import ProductManagement.model.Product;

import java.util.Scanner;

public class CartController {
    private final Cart cart;
    private final CartContentsView view;
    private final Scanner scanner;

    public CartController(Cart cart, CartContentsView view) {
        this.cart = cart;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void manageCart() {
        int choice;
        do {
            view.displayCart(cart.getCartContents(), cart.getTotalPrice());
            choice = view.displayOptions();

            switch (choice) {
                case 1 -> removeProduct();
                case 2 -> {
                    cart.emptyCart();
                    System.out.println("Cart emptied.");
                }
                case 3 -> buyCart();
                case 4 -> System.out.println("Exiting cart...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void addProduct(Product p) {
        cart.addProduct(p);
        System.out.println(p.getTitle() + " added to cart.");
    }

    private void removeProduct() {
        System.out.print("Enter product name to remove: ");
        String productName = scanner.next();

        for (Product p : cart.getCartContents().keySet()) {
            if (p.getTitle().equalsIgnoreCase(productName)) {
                cart.removeProduct(p);
                System.out.println(productName + " removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    private void buyCart() {
        if (cart.getCartContents().isEmpty()) {
            System.out.println("Cart is empty! Add products before purchasing.");
            return;
        }
        System.out.println("Proceeding to checkout... ");
        cart.emptyCart();  // Simulate purchase
    }
}

