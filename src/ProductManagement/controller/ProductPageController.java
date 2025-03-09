package ProductManagement.controller;

import CartManagement.controller.CartController;
import ProductManagement.model.Product;
import ProductManagement.view.ProductPageView;

import java.util.ArrayList;

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
        view.displayOptions();
        handleLogic();
    }

    public void handleLogic() {
        String choice = view.getUserChoice().toUpperCase(); //sanitize user input :D

        switch (choice) {
            case "A" -> {
                new CartController(productDetails);
            }
            case "X" -> {
                new ProductListingController();
            }
            default -> view.invalidInput();
        }
    }

    //retrieves information about product requested
    public ArrayList<String> retrieveProduct() {
        return null;
    }

    //changes image and goes through image carousel for product on click if there's multiple images for a listing
    public String changeImg() {
        return null;
    }
}

