package edu.psu.ist.productmanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.view.ProductPageView;

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
        view.displayOptions(this);
        handleLogic();
    }

    public void handleLogic() {
        String choice = view.getUserChoice().toUpperCase(); //sanitize user input :D

        switch (choice) {
            case "A" -> {
                view.succAddToCart();
                new CartController(productDetails);
            }
            case "X" -> {
                new ProductListingController();
            }
            default -> view.invalidInput();
        }
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

