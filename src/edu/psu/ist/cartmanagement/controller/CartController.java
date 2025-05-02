package edu.psu.ist.cartmanagement.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import edu.psu.ist.cartmanagement.model.CartDAO;
import edu.psu.ist.cartmanagement.model.CartItemRecord;
import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.util.CartObserver;
import edu.psu.ist.cartmanagement.view.CartContentsView;
import edu.psu.ist.paymentmanagement.controller.PaymentWizardController;
import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.productmanagement.controller.ProductNotFoundController;
import edu.psu.ist.productmanagement.controller.ProductPageController;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductDAO;
import edu.psu.ist.usermanagement.controller.LogInController;
import edu.psu.ist.usermanagement.model.UserSession;

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
        CartDAO.insertCart(cart, p);
        update();
    }

    private void buyCart() {
        if (!UserSession.getInstance().isLoggedIn()) {
            JOptionPane.showMessageDialog(view.getBasePanel(), "You must log in to proceed to payment.");
            new LogInController();
            view.setVisible(false);
            return;
        }
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
                    CartDAO.deleteCartItemsForUser(UserSession.getInstance().getUserID());
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

    public static void loadCartAtLogin(String userID) {
        List<CartItemRecord> records = CartDAO.getCartItemsForUser(userID);

        for (CartItemRecord record : records) {
            Product p = ProductDAO.findProductByID(record.getProductID());
            if (p != null) {
                for (int i = 0; i < record.getQuantity(); i++) {
                    CartManager.getInstance().addProduct(p);
                }
            }
            else {
                new ProductNotFoundController();
            }
        }
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

}

