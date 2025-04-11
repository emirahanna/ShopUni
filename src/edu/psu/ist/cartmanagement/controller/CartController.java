package edu.psu.ist.cartmanagement.controller;

import edu.psu.ist.cartmanagement.model.Cart;

import edu.psu.ist.cartmanagement.view.CartContentsView;
import edu.psu.ist.productmanagement.model.Pricing;
import edu.psu.ist.productmanagement.model.Product;

import java.util.Date;
import java.util.Map;

public class CartController {
    private Cart cart;
    private CartContentsView view;

    public CartController(Product p) {
        this.cart = Cart.getInstance(); //singleton model since there should only be one cart per session per user
        this.cart.addProduct(p);
        view = new CartContentsView();
        refreshCartDisplay();
        manageCart();
    }

    public void manageCart() {
        int choice;
//        do {
//            view.displayCart(cart.getCartContents(), cart.getTotalPrice());
//            choice = view.displayOptions();
//
//            switch (choice) {
//                case 1 -> {
//                    removeProduct();
//                }
//                case 2 -> {
//                    cart.emptyCart();
//                    view.cartEmptied();
//                }
//                case 3 -> {
//                    buyCart();
//                    choice = 4;
//                    new OrderController(cart);
//                }
//                case 4 -> {
//                    view.exitingCart();
//                    new ProductListingController();
//                }
//                default -> view.invalidChoice();
//            }
//        } while (choice != 4);
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

    public void refreshCartDisplay() {
        view.clearCartDisplay();

        for (Map.Entry<Product, Integer> entry : cart.getCartContents().entrySet()) { //I want both the product, and the quantity
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + " - " + quantity);
            view.createCartItemCard(product.getTitle(), quantity, product.getPrice());
        }
        view.layoutComponents();
        view.repaintCartDisplay();
    }

    //you can test the cart page here
    public static void main(String[] args) {
        CartController crtl =  new CartController(new Product("Alo Top", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        crtl.addProduct(new Product("Levi Pants", "Effortlessly chic, this draped front top is crafted from a MicroModal blend offering a soft, luxurious feel with a hint of stretch.\nWith a slim fit and high neckline, it features gathered detailing across the front creating a flattering, asymmetrical silhouette.\nPair with skirts or tailored trousers for a sophisticated take.", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        crtl.addProduct(new Product("Nike Hoodie", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(30.0) ));
        crtl.addProduct(new Product("Zara Pants", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance.\nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(60.0) ));
        crtl.addProduct(new Product("Lorem Ipsum", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(100.0) ));

        crtl.refreshCartDisplay();
    }
}

