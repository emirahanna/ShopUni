package CartManagement.controller;

import CartManagement.model.Cart;
import CartManagement.view.CartContentsView;

import ProductManagement.controller.ProductListingController;
import ProductManagement.model.Product;

import java.util.Scanner;

public class CartController {
    private Cart cart;
    private CartContentsView view;
    private Scanner scanner;

    public CartController(Product p) {
        this.cart = Cart.getInstance();
        this.cart.addProduct(p);
        this.view = new CartContentsView(cart.getCartContents(), cart.getTotalPrice());
        this.scanner = new Scanner(System.in);
        manageCart();
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
                    view.cartEmptied();
                }
                case 3 -> {
                    buyCart();
                    choice = 4;
                }
                case 4 -> {
                    view.exitingCart();
                    new ProductListingController();
                }
                default -> view.invalidChoice();
            }
        } while (choice != 4);
    }

    private void addProduct(Product p) {
        cart.addProduct(p);
    }

    private void removeProduct() {
        view.removeProductPrompt();
        String productName = scanner.next();

        for (Product p : cart.getCartContents().keySet()) {
            if (p.getTitle().equalsIgnoreCase(productName)) {
                cart.removeProduct(p);
                view.productWasRemoved(p.getTitle());
                manageCart();
                return;
            }
        }
        view.productNotFound();
    }

    private void buyCart() {
        if (cart.getCartContents().isEmpty()) {
            view.cartEmptyReminder();
            return;
        }
        cart.emptyCart();  // Simulate purchase
    }
}

