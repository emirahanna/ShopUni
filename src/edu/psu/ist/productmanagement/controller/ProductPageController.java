package edu.psu.ist.productmanagement.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.view.ProductPageView;

import javax.swing.*;

/**
 * This class stores the model and the view
 * Establishes what occurs when user enters the view and what the buttons on the product details view do when clicked
 */

public class ProductPageController {
    final Product product;
    final ProductPageView view;


    //constructor stores model and view
    public ProductPageController(Product product) {

        this.product = product;
        this.view = new ProductPageView();
        attachActionListeners();
        readProductDetails();
        displayProductImage();
    }


    private void displayProductImage() {
        try {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/" + product.getID() + ".jpg")));
            view.setProductImage(icon);
        } catch (Exception e) {
            view.setEmptyImage();
        }
    }

    public void readProductDetails() {
        try {
            //uses html tags to force the text to wrap. its times like these where i miss web development
            view.getProductTitle().setText("<html>" + product.getTitle() + "</html>");
            view.getProductDescription().setText("<html>" + product.getDescription() + "</html>");
            view.getProductPrice().setText(String.format("$%.2f", product.getPrice()));
            view.getProductPageBreadCrumb().setText(product.getTitle());
        } catch (Exception e) {
            new ProductNotFoundController();
            view.setVisible(false);
        }
    }


    public void attachActionListeners() {
        view.getBackButton().addActionListener(e -> {
            new ProductListingController();
            view.setVisible(false);
        });
        view.getAddToCartButton().addActionListener(e -> {
            view.setVisible(false);
            CartController cm = new CartController();
            cm.addProduct(product);
        });
        //using mouse listeners for the breadcrumbs, but that means I need to implement all the Mouse Listener methods ouch
        view.getProductCatalogBreadCrumb().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductListingController();
                view.setVisible(false);
            }
        });
    }

    //retrieves information about product requested
    public String retrieveProduct() {
        return ("Product Details: \n \n" + product.displayProductDetails());
    }

    //changes image and goes through image carousel for product on click if there's multiple images for a listing
    public String changeImg() {
        return product.getImageID();
    }
}

