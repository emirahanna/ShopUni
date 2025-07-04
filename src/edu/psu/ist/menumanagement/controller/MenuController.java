package edu.psu.ist.menumanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.util.User;
import edu.psu.ist.menumanagement.view.MenuView;
import edu.psu.ist.ordermanagement.controller.OrderTableController;
import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.productmanagement.controller.ProductPageController;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.usermanagement.controller.LogInController;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class MenuController {
    private MenuView view;

    public MenuController() {
        view = new MenuView();
        attachListeners();
        notifyCartContent();
    }

    private void notifyCartContent(){
        if (!CartManager.getInstance().getItems().isEmpty()) {
            CartManager.getInstance().notifyObservers();
        }
    }

    private void attachListeners() {
        view.getViewProductDetailsButton().addActionListener(e -> {
            openProductDetails();
            view.setVisible(false);
        });

        view.getAddToCartButton().addActionListener(e -> {
            openAddToCart();
            view.setVisible(false);
        });

        view.getPurchaseProductButton().addActionListener(e -> {
            openPurchaseProduct();
            view.setVisible(false);
        });

        view.getTrackOrdersButton().addActionListener(e -> {
            trackOrder();
            view.setVisible(false);
        });
        view.getLogOutButton().addActionListener(e -> {
            logOut();
            view.setVisible(false);
        });


        view.getPromptLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductListingController();
                view.setVisible(false);
            }
        });

        //trying to make the link look clickable
        view.getPromptLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view.getPromptLabel().setForeground(Color.BLUE); // Color when mouse is hovering
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view.getPromptLabel().setForeground(Color.BLACK); // Color when mouse leaves
            }
        });
    }

    private void openProductDetails() {
        // Open the product catalog so you can start seeing the product details
        new ProductListingController();
    }

    private void openAddToCart() {
        // Open the product page to start adding things to cart
        // this is sample data
        new ProductPageController(new Product("TOP", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. \n This is sample data and I don't know what else to write", "20342391331", "imageID", "sellerID", LocalDate.now(), "Top", 40.0));
    }

    private void openPurchaseProduct() {
        // Open the cart to start purchasing products
        new CartController();
    }

    private void trackOrder() {
        // Open the cart to start purchasing products
        new OrderTableController();
    }

    private void logOut(){
        new LogInController();
    }


}