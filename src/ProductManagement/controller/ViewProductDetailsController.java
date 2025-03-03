package ProductManagement.controller;

import ProductManagement.model.Product;
import ProductManagement.view.ProductPageView;

import java.util.ArrayList;

/**
 * This class stores the model and the view
 * Establishes what occurs when user enters the view and what the buttons on the product details view do when clicked
 */

public class ViewProductDetailsController {

    private Product productDetails;
    private ProductPageView productDetailsView;

    //constructor stores model and view
    public ViewProductDetailsController (Product productDetails, ProductPageView productDetailsView){
        this.productDetails = productDetails;
        this.productDetailsView = productDetailsView;
    }

    //retrieves information about product requested
    public ArrayList<String> retrieveProduct(){
        return null;
    }

    //changes image and goes through image carousel for product on click if there's multiple images for a listing
    public String changeImg(){
        return null;
    }

}
