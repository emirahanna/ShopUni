package edu.psu.ist.cartmanagement.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JOptionPane;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.util.CartObserver;
import edu.psu.ist.cartmanagement.view.CartContentsView;
import edu.psu.ist.paymentmanagement.controller.PaymentWizardController;
import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.productmanagement.controller.ProductPageController;
import edu.psu.ist.productmanagement.model.Product;

public class CartController implements CartObserver {
    final CartManager cart;
    final CartContentsView view;
    private Product recentProduct;

    public CartController() {
        this.cart = CartManager.getInstance(); //singleton model
        view = new CartContentsView();
        attachActionListeners();
        cart.addObserver(this);
        update(); // Populate view at start

    }


    public void addProduct(Product p) {
        cart.addProduct(p);
        recentProduct = p;
        view.getProductPageBreadcrumb().setText(p.getTitle() + ">");
        update();
    }

    private void buyCart() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(view.getBasePanel(), "Cart is empty! Add products before purchasing.");
        } else {
            new PaymentWizardController(cart);
            view.setVisible(false);
        }
    }


    public void attachActionListeners() {
        view.getEmptyCartButton().addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(view.getBasePanel(), "Cart is empty!");
            } else {
                int confirmMessage = JOptionPane.showConfirmDialog(view.getBasePanel(), "Are you sure you want to empty your cart?", "Empty Cart", JOptionPane.YES_NO_OPTION);

                if (confirmMessage == JOptionPane.YES_OPTION) {
                    cart.emptyCart();
                    update();
                    JOptionPane.showMessageDialog(view.getBasePanel(), "Cart has been emptied");
                }
            }
        });
        view.getBuyNowButton().addActionListener(e -> {
            buyCart();
        });
        view.getBackButton().addActionListener(e -> {
            new ProductListingController();
            view.setVisible(false);
        });
        //using mouse listeners for the breadcrumbs, but that means I need to implement all the Mouse Listener methods ouch
        view.getProductCtlgBreadcrumb().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductListingController();
                view.setVisible(false);
            }
        });
        view.getProductPageBreadcrumb().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductPageController(recentProduct);
                view.setVisible(false);
            }
        });
    }

    @Override
    public void update() {
        view.clearCartDisplay();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) { //I want both the product, and the quantity
            Product product = entry.getKey();
            int quantity = entry.getValue();
            view.createCartItemCard(product.getTitle(), quantity, product.getPrice(), e -> {
                cart.removeProduct(product);
                JOptionPane.showMessageDialog(view.getBasePanel(), product + " removed from cart");
            });
        }
        view.layoutComponents();
        view.repaintCartDisplay();
    }

    public String getCartContents() {
        StringBuilder sb = new StringBuilder();
        for (Product p : cart.getItems().keySet()) {
            sb.append(String.format("%-30s %5d %5.2f\n", p.getTitle(), cart.getItems().get(p), p.getPrice()));
        }
        return sb.toString();
    }
}

