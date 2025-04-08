package cartmanagement.controller;

import cartmanagement.model.Cart;
import cartmanagement.view.CartContentsView;

import ordermanagement.controller.OrderController;
import productmanagement.controller.ProductListingController;
import productmanagement.model.Product;

public class CartController {
    private Cart cart;
    private CartContentsView view;

    public CartController(Product p) {
        this.cart = Cart.getInstance(); //singleton model since there should only be one cart per session per user
        this.cart.addProduct(p);
        view = new CartContentsView();
        manageCart();
    }

    public void manageCart() {
        int choice;
        do {
            view.displayCart(cart.getCartContents(), cart.getTotalPrice());
            choice = view.displayOptions();

            switch (choice) {
                case 1 -> {
                    removeProduct();
                }
                case 2 -> {
                    cart.emptyCart();
                    view.cartEmptied();
                }
                case 3 -> {
                    buyCart();
                    choice = 4;
                    new OrderController(cart);
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
        String productName = view.getProductName();

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

