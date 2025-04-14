package edu.psu.ist.productmanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.view.ProductPageView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class stores the model and the view
 * Establishes what occurs when user enters the view and what the buttons on the product details view do when clicked
 */

public class ProductPageController {

    private Product productDetails;
    private ProductPageView view;


    //constructor stores model and view
    public ProductPageController(Product product) {
        this.productDetails = product;
        this.view = new ProductPageView();
        attachActionListeners();
        readProductDetails();
        view.getProductPageBreadCrumb().setText(product.getTitle());
        //view.displayOptions(this);
        //handleLogic();
    }

    public void readProductDetails(){
        //uses html tags to force the tet to wrap. its times like these where i miss web development
        view.getProductTitle().setText("<html>" + productDetails.getTitle() + "</html>");
        view.getProductDescription().setText("<html>" + productDetails.getDescription() + "</html>");
        view.getProductPrice().setText(String.format("$%.2f", productDetails.getPrice()));
    }

    public void handleLogic() {
        String choice = view.getUserChoice().toUpperCase(); //sanitize user input :D

        switch (choice) {
            case "A" -> {
                view.succAddToCart();
                CartController cm  = new CartController();
                cm.addProduct(productDetails);
            }
            case "X" -> {
                new ProductListingController();
            }
            default -> view.invalidInput();
        }
    }

    public void attachActionListeners() {
        view.getBackButton().addActionListener(e -> {
            new ProductListingController();
            view.setVisible(false);
        });
        view.getAddToCartButton().addActionListener(e -> {
            view.setVisible(false);
            CartController cm  = new CartController();
            cm.addProduct(productDetails);
        });
        //using mouse listeners for the breadcrumbs, but that means I need to implement all the Mouse Listener methods ouch
        view.getProductCatalogBreadCrumb().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductListingController();
                view.setVisible(false);

                //JOptionPane.showMessageDialog(view.getBasePanel(), "Product Catalog Breadcrumb Pressed");
            }
        });
    }

    //retrieves information about product requested
    public String retrieveProduct() {
        return ("Product Details: \n \n" + productDetails.displayProductDetails());
    }

    //changes image and goes through image carousel for product on click if there's multiple images for a listing
    public String changeImg() {
        return productDetails.getImageID() ;
    }
}

